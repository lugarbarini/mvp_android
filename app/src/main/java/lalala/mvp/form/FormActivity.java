package lalala.mvp.form;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import lalala.mvp.AbstractActivity;
import lalala.mvp.R;
import lalala.mvp.common.presenter.PresenterDelegate;

public class FormActivity extends AbstractActivity<FormPresenter> implements FormView, View.OnClickListener {

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
                getPresenter().onAddField();
            }
        });
    }

    @Override
    protected PresenterDelegate<?, FormPresenter> createDelegate() {
        return new PresenterDelegate<FormView, FormPresenter>(this, new FormPresenter());
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
    public void onClick(View v) {
        Button view = (Button) v;
        getPresenter().onFieldSelected(view.getText().toString());
    }
}
