package lalala.mvp.resolver;

/**
 * Defines the next step in the flow
 * <p/>
 * Created by lgarbarini on 28/10/15.
 */
public class FlowStep {
    protected boolean clearBackStack;

    FlowStep(boolean clearBackStack) {
        this.clearBackStack = clearBackStack;
    }

    FlowStep() {
        this.clearBackStack = false;
    }

    /**
     * @return true if this step should remove every other step in the flow back stack
     */
    public boolean shouldClearBackStack() {
        return clearBackStack;
    }
}
