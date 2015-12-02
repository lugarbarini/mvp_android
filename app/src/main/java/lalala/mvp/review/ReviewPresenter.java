package lalala.mvp.review;

import lalala.mvp.common.presenter.Presenter;

/**
 * Created by lgarbarini on 1/12/15.
 */
public class ReviewPresenter extends Presenter<ReviewView> {

    @Override
    public void linkView(ReviewView view) {
        super.linkView(view);
        this.view.showText(appContext.getSelectedField());
    }

}
