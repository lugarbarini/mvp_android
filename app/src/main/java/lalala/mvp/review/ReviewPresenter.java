package lalala.mvp.review;

import lalala.mvp.AppContext;
import lalala.mvp.common.Presenter;

/**
 * Created by lgarbarini on 1/12/15.
 */
public class ReviewPresenter extends Presenter<ReviewView> {

    AppContext appContext;
    ReviewView view;


    @Override
    public void linkView(ReviewView view) {
        super.linkView(view);
        this.view.showText(appContext.getSelectedField());
    }

}
