package lalala.mvp.common;

import android.os.Bundle;

import lalala.mvp.AppContext;

/**
 * Created by lgarbarini on 1/12/15.
 */
public class Presenter<T extends PresentingView> {

    protected T view;
    protected AppContext appContext;

    protected Presenter() {
        // nothing
    }

    public void init(Bundle bundle) {
        if (bundle == null)
            throw new IllegalArgumentException();
        appContext = bundle.getParcelable("app_context");
    }

    public void save(Bundle bundle) {
        bundle.putParcelable("app_context", appContext);
    }

    public void linkView(T view) {
        this.view = view;
    }

    public void unlinkView(T view) {
        if (this.view == view) {
            this.view = null;
        }
    }
}
