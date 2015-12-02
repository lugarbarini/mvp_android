package lalala.mvp.common.presenter;

import android.os.Bundle;

/**
 * Handles the mapping of view and presentes
 * Created by lgarbarini on 2/12/15.
 */
public class PresenterDelegate<V extends PresentingView, T extends Presenter<V>> {

    private T presenter;
    private final V view;


    public PresenterDelegate(V view, T presenter) {
        this.presenter = presenter;
        this.view = view;
    }

    public void restorePresenter(T oldPresenter) {
        this.presenter = oldPresenter;
    }

    public void linkView() {
        presenter.linkView(view);
    }

    public void unlinkView() {
        presenter.unlinkView(view);
    }

    public void save(Bundle outState) {
        presenter.save(outState);
    }

    public void restore(Bundle savedState) {
        presenter.init(savedState);
    }

    public T getPresenter() {
        return presenter;
    }

}
