package lalala.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;

import lalala.mvp.common.presenter.Presenter;
import lalala.mvp.common.presenter.PresenterDelegate;
import lalala.mvp.common.resolver.ActivityFlowStep;
import lalala.mvp.common.resolver.FlowStepExecutor;

/**
 * Generic activity
 * Created by lgarbarini on 1/12/15.
 */
public abstract class AbstractActivity<T extends Presenter<?>> extends AppCompatActivity implements FlowStepExecutor {

    protected PresenterDelegate<?, T> delegate;

    @SuppressWarnings("unchecked")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PresenterDelegate<?, T> oldDelegate = (PresenterDelegate<?, T>) getLastCustomNonConfigurationInstance();

        delegate = createDelegate();
        if (oldDelegate == null) {
            delegate.restore(savedInstanceState == null ? getIntent().getExtras() : savedInstanceState);
        } else {
            delegate.restorePresenter(oldDelegate.getPresenter());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        delegate.linkView();
    }

    @Override
    protected void onPause() {
        delegate.unlinkView();
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        delegate.save(outState);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return delegate;
    }

    protected abstract PresenterDelegate<?, T> createDelegate();

    protected T getPresenter() {
        return delegate.getPresenter();
    }

    @NonNull
    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void goToNextStep(@NonNull ActivityFlowStep nextStep) {
        startActivity(nextStep.getNextIntent());
    }
}
