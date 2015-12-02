package lalala.mvp.form;

import android.os.Bundle;

import java.util.List;

import lalala.mvp.AppContext;
import lalala.mvp.common.presenter.Presenter;

/**
 * Created by lgarbarini on 1/12/15.
 */
public class FormPresenter extends Presenter<FormView> implements FieldsFinder.OnFieldsFoundListener {

    private FormResolver resolver;

    @Override
    public void init(Bundle bundle) {
        if (bundle == null) {
            appContext = new AppContext();
        } else {
            super.init(bundle);
        }

        resolver = new FormResolver();
    }

    @Override
    public void linkView(FormView view) {
        super.linkView(view);
        if (appContext.getFields().isEmpty()) {
            new FieldsFinder().findFields(this);
        } else {
            onFieldsFound(appContext.getFields());
        }
    }

    public void onFieldSelected(String field) {
        appContext.setSelectedField(field);
        resolver.onFieldSelected(appContext, view);
    }

    public void onAddField() {
        FormField field = new FormField("Item " + (appContext.getFields().size() + 1));
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
