package lalala.mvp.review;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import lalala.mvp.R;
import lalala.mvp.form.FormPresenter;

public class ReviewActivity extends AppCompatActivity implements ReviewView {

    ReviewPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        presenter = (ReviewPresenter) getLastCustomNonConfigurationInstance();
        if (presenter == null) {
            presenter = new ReviewPresenter(savedInstanceState != null ? savedInstanceState : getIntent().getExtras());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.linkView(this);
    }

    @Override
    protected void onPause() {
        presenter.unlinkView(this);
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.save(outState);
    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return presenter;
    }

    @Override
    public void showText(String text) {
        TextView view = (TextView) findViewById(R.id.result_text);
        view.setText(text);
    }
}
