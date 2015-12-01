package lalala.mvp.review;

import android.os.Bundle;

import lalala.mvp.AppContext;

/**
 * Created by lgarbarini on 1/12/15.
 */
public class ReviewPresenter {

    AppContext appContext;
    ReviewView view;

    public ReviewPresenter(Bundle bundle) {
        if(bundle == null)
            throw new IllegalArgumentException();
        appContext = bundle.getParcelable("app_context");
    }

    public void save(Bundle bundle) {
        bundle.putParcelable("app_context", appContext);
    }

    public void linkView(ReviewView view) {
        this.view = view;
        this.view.showText(appContext.getSelectedField());
    }

    public void unlinkView(ReviewView view) {
        if (this.view == view) {
            this.view = null;
        }
    }
}
