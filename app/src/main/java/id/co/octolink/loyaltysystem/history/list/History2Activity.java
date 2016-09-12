package id.co.octolink.loyaltysystem.history.list;

import android.content.DialogInterface;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.octolink.R;
import id.co.octolink.model.History2;
import id.co.octolink.singleton.AppController;
import id.co.octolink.utils.SessionManager;

public class History2Activity extends AppCompatActivity {
    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.history2_recyclerview)RecyclerView history2_recyclerview;

    private History2Adapter adapter;
    private SwipeRefreshLayout swipeContainerHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);
        ButterKnife.bind(this);

        setupToolbar();

        List<History2> history2 = fill_with_history();
        adapter = new History2Adapter(history2, getApplication());
        history2_recyclerview.setAdapter(adapter);
        history2_recyclerview.setLayoutManager(new LinearLayoutManager(this));

    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);
        //TOOLBAR BACK BUTTON
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        if (getSupportActionBar() == null) {
            throw new IllegalStateException("Activity must implement toolbar");
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
//        Intent myIntent = new Intent(History2Activity.this, Main2Activity.class);
//        startActivityForResult(myIntent, 0);
//        startActivity(new Intent(History2Activity.this,Main2Activity.class));
//        finish();
        onBackPressed();
        return true;

    }
    public List<History2> fill_with_history() {

        List<History2> history2 = new ArrayList<>();

        history2.add(new History2("name", "address", "halooo"));
        history2.add(new History2("name", "address", "halooo"));
        history2.add(new History2("name", "address", "halooo"));
        history2.add(new History2("name", "address", "halooo"));
        history2.add(new History2("name", "address", "halooo"));
        history2.add(new History2("name", "address", "halooo"));
        history2.add(new History2("name", "address", "halooo"));


        return history2;
    }

}
