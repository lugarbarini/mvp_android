package lalala.mvp.form;

import android.os.Bundle;

import java.util.List;

import lalala.mvp.AppContext;

/**
 * Created by lgarbarini on 1/12/15.
 */
public class FormPresenter implements FieldsFinder.OnFieldsFoundListener {

    FormView view;
    AppContext appContext;

    public FormPresenter(Bundle bundle) {
        if (bundle == null) {
            appContext = new AppContext();
        }
        else {
            appContext = bundle.getParcelable("app_context");
        }
    }

    public void save(Bundle bundle) {
        bundle.putParcelable("app_context", appContext);
    }

    public void linkView(FormView view) {
        this.view = view;
        new FieldsFinder().findFields(this);
    }

    public void unlinkView(FormView view) {
        if (this.view == view) {
            this.view = null;
        }
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
