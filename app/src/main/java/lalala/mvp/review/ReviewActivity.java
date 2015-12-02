package lalala.mvp.review;

import android.os.Bundle;
import android.widget.TextView;

import lalala.mvp.AbstractActivity;
import lalala.mvp.R;
import lalala.mvp.common.presenter.PresenterDelegate;

public class ReviewActivity extends AbstractActivity<ReviewPresenter> implements ReviewView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
    }

    @Override
    protected PresenterDelegate<?, ReviewPresenter> createDelegate() {
        return new PresenterDelegate<ReviewView, ReviewPresenter>(this, new ReviewPresenter());
    }

    @Override
    public void showText(String text) {
        TextView view = (TextView) findViewById(R.id.result_text);
        view.setText(text);
    }
}
