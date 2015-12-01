package lalala.mvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import lalala.mvp.common.Presenter;
import lalala.mvp.common.PresentingView;
import lalala.mvp.common.RequiresPresenter;
import lalala.mvp.review.ReviewPresenter;

/**
 * Created by lgarbarini on 1/12/15.
 */
public abstract class AbstractActivity<T extends Presenter> extends AppCompatActivity {

    protected T presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        presenter = (T) getLastCustomNonConfigurationInstance();
        if (presenter == null) {
            presenter = createInstance(getPresenterClass(), savedInstanceState != null ? savedInstanceState : getIntent().getExtras());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.linkView(this);
    }

    @Override
    protected void onPause() {
        presenter.unlinkView(this);
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.save(outState);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    T createInstance(Class<T> clazz, Bundle bundle) {
        T t = null;
        try {
            t = clazz.newInstance();
            t.init(bundle);
        } catch (InstantiationException | IllegalAccessException | NullPointerException e) {
            e.printStackTrace();
        }

        return t;
    }

    Class<T> getPresenterClass() {
        RequiresPresenter annotation = getClass().getAnnotation(RequiresPresenter.class);
        return annotation == null ? null : (Class<T>)annotation.value();
    }
}
