package lalala.mvp.common.resolver;

import android.content.Intent;
import android.support.annotation.NonNull;

import lalala.mvp.AppContext;

/**
 * Generic flow resolver
 * <p/>
 * Created by lgarbarini on 28/10/15.
 */
public class AbstractFlowResolver {

    /**
     * Go to an activity
     *
     * @param executor      executor for the step
     * @param activityClass activity to open
     */
    protected void goToActivity(AppContext appContext, @NonNull FlowStepExecutor executor, @NonNull Class activityClass) {
        goToActivity(appContext, executor, activityClass, false);
    }

    /**
     * Go to an activity
     *
     * @param executor      executor for the step
     * @param activityClass activity to open
     * @param clearStack    whether to clear the current activity
     */
    protected void goToActivity(AppContext appContext, @NonNull FlowStepExecutor executor, @NonNull Class activityClass, boolean clearStack) {
        Intent intent = new Intent(executor.getContext(), activityClass);
        intent.putExtra(AppContext.SAVE_KEY, appContext);
        executor.goToNextStep(new ActivityFlowStep(intent, clearStack));
    }

}
