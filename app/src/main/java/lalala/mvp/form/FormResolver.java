package lalala.mvp.form;

import lalala.mvp.AppContext;
import lalala.mvp.common.resolver.AbstractFlowResolver;
import lalala.mvp.common.resolver.FlowStepExecutor;
import lalala.mvp.review.ReviewActivity;

/**
 * Created by lgarbarini on 2/12/15.
 */
public class FormResolver extends AbstractFlowResolver {

    public void onFieldSelected(AppContext context, FlowStepExecutor executor) {
        goToActivity(context, executor, ReviewActivity.class);
    }
}
