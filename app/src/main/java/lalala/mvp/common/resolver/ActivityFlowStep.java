package lalala.mvp.common.resolver;

import android.content.Intent;
import android.support.annotation.NonNull;

/**
 * Represents the following state in the screen flow, which is an Activity
 * <p/>
 * Created by lgarbarini on 28/10/15.
 */
public class ActivityFlowStep extends FlowStep {
    private final Intent nextIntent;

    public ActivityFlowStep(@NonNull Intent intent, boolean clearStack) {
        super(clearStack);
        nextIntent = intent;
    }

    public ActivityFlowStep(@NonNull Intent intent) {
        super();
        nextIntent = intent;
    }

    @NonNull
    public Intent getNextIntent() {
        return nextIntent;
    }
}
