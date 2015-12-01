package lalala.mvp.form;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lgarbarini on 1/12/15.
 */
public class FormField implements Parcelable {
    String label;

    protected FormField(Parcel in) {
        label = in.readString();
    }

    public static final Creator<FormField> CREATOR = new Creator<FormField>() {
        @Override
        public FormField createFromParcel(Parcel in) {
            return new FormField(in);
        }

        @Override
        public FormField[] newArray(int size) {
            return new FormField[size];
        }
    };

    public FormField(String label) {
        this.label = label;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(label);
    }
}
