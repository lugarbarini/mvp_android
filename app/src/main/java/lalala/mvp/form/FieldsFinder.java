package lalala.mvp.form;

import android.os.Handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by lgarbarini on 1/12/15.
 */
public class FieldsFinder {

    public interface OnFieldsFoundListener {
        void onFieldsFound(List<FormField> fieldsList);
    }

    public void findFields(final OnFieldsFoundListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override public void run() {
                listener.onFieldsFound(createArrayList());
            }
        }, 2000);
    }

    /**
     * simulate a server call
     */
    private List<FormField> createArrayList() {
        return new ArrayList<>(Arrays.asList(
                new FormField("Item 1"),
                new FormField("Item 2"),
                new FormField("Item 3"),
                new FormField("Item 4")
        ));
    }
}
