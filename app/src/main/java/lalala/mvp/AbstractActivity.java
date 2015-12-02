package lalala.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import lalala.mvp.common.Presenter;
import lalala.mvp.common.PresenterDelegate;

/**
 * Generic activity
 * Created by lgarbarini on 1/12/15.
 */
public abstract class AbstractActivity<T extends Presenter<?>> extends AppCompatActivity {

    protected PresenterDelegate<?, T> delegate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        delegate = createDelegate();
        delegate.restore(savedInstanceState == null ? getIntent().getExtras() : savedInstanceState);
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

}
