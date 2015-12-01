package lalala.mvp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import lalala.mvp.form.FormField;

/**
 * Created by lgarbarini on 1/12/15.
 */
public class AppContext implements Parcelable {

    List<FormField> fields;
    String selectedField;

    public AppContext() {
        fields = new ArrayList<>();
    }

    public List<FormField> getFields() {
        return fields;
    }

    public String getSelectedField() {
        return selectedField;
    }

    public void setFields(List<FormField> fields) {
        this.fields = fields;
    }

    public void setSelectedField(String selectedField) {
        this.selectedField = selectedField;
    }


    protected AppContext(Parcel in) {
        selectedField = in.readString();
        fields = new ArrayList<>();
    }

    public static final Creator<AppContext> CREATOR = new Creator<AppContext>() {
        @Override
        public AppContext createFromParcel(Parcel in) {
            return new AppContext(in);
        }

        @Override
        public AppContext[] newArray(int size) {
            return new AppContext[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(selectedField);
    }
}
