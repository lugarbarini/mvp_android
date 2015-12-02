package lalala.mvp.resolver;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Interface for objects that are capable of executing flow steps
 * Eg: An activity or fragment
 * <p/>
 * Created by lgarbarini on 28/10/15.
 */
public interface FlowStepExecutor {

    /**
     * Go to the next activity
     *
     * @param nextStep an activity definition step
     */
    void goToNextStep(@NonNull ActivityFlowStep nextStep);

    /**
     * @return application context
     */
    @NonNull
    Context getContext();
}
