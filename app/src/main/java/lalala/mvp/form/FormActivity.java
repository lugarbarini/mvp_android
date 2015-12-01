package lalala.mvp.form;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import lalala.mvp.R;
import lalala.mvp.review.ReviewActivity;

public class FormActivity extends AppCompatActivity implements FormView, View.OnClickListener {

    FormPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onAddField();
            }
        });

        presenter = (FormPresenter) getLastCustomNonConfigurationInstance();
        if (presenter == null) {
            presenter = new FormPresenter(savedInstanceState != null ? savedInstanceState : getIntent().getExtras());
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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void createForm(List<FormField> fields) {
        ViewGroup view = (ViewGroup) findViewById(R.id.content_main);

        view.removeAllViews();
        for (FormField field : fields) {
            createField(view, field);
        }
    }

    private void createField(ViewGroup view, FormField field) {
        Button text = new Button(this);
        text.setOnClickListener(this);
        text.setText(field.label);
        view.addView(text);
    }

    @Override
    public void onFieldAdded(FormField field) {
        ViewGroup view = (ViewGroup) findViewById(R.id.content_main);
        createField(view, field);
        Snackbar.make(view, "New field: " + field.label, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void goToReview(Bundle extras) {
        Intent intent = new Intent(this, ReviewActivity.class);
        intent.putExtras(extras);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        Button view = (Button) v;
        presenter.onFieldSelected(view.getText().toString());
    }
}
