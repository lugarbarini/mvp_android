package lalala.mvp.form;

import android.os.Bundle;

import java.util.List;

import lalala.mvp.common.PresentingView;

/**
 * Created by lgarbarini on 1/12/15.
 */
public interface FormView extends PresentingView {

    void createForm(List<FormField> fields);

    void onFieldAdded(FormField field);

    void goToReview(Bundle extras);
}
