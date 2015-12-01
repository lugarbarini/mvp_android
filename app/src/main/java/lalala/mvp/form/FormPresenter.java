package lalala.mvp.form;

import android.os.Bundle;

import java.util.List;

import lalala.mvp.AppContext;
import lalala.mvp.common.Presenter;

/**
 * Created by lgarbarini on 1/12/15.
 */
public class FormPresenter extends Presenter<FormView> implements FieldsFinder.OnFieldsFoundListener {


    @Override
    public void init(Bundle bundle) {
        if (bundle == null) {
            appContext = new AppContext();
        }
        else {
            super.init(bundle);
        }
    }

    @Override
    public void linkView(FormView view) {
        super.linkView(view);
        new FieldsFinder().findFields(this);
    }

    public void onFieldSelected(String field) {
        appContext.setSelectedField(field);

        if (view != null) {
            Bundle extra = new Bundle();
            extra.putParcelable("app_context", appContext);
            view.goToReview(extra);
        }
    }

    public void onAddField() {
        FormField field = new FormField("Item " + (appContext.getFields().size()+1));
        appContext.getFields().add(field);
        if (view != null) {
            view.onFieldAdded(field);
        }
    }

    @Override
    public void onFieldsFound(List<FormField> fieldsList) {
        appContext.setFields(fieldsList);
        if (view != null) {
            view.createForm(fieldsList);
        }
    }
}
