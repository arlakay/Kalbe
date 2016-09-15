package id.co.octolink.loyaltysystem.history.list;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.octolink.R;
import id.co.octolink.api.RestApi;
import id.co.octolink.api.services.ApiService;
import id.co.octolink.loyaltysystem.history.detail.StrukDetailHistory;
import id.co.octolink.model.History;
import id.co.octolink.model.HistoryResponse;
import id.co.octolink.utils.SessionManager;
import retrofit2.Call;
import retrofit2.Callback;

public class History2Activity extends AppCompatActivity {
    private static final String TAG = History2Activity.class.getSimpleName();
    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.history2_recyclerview)RecyclerView history2_recyclerview;
    @BindView(R.id.loading_history)ProgressBar loadingH;
    private History2Adapter adapter;
    private SessionManager session;
    private String cid, currentDate, yearNow, monthNow, year, month;
    private List<History> historyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);
        ButterKnife.bind(this);

        session = new SessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        cid = user.get(SessionManager.KEY_CID);

        setupToolbar();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplication().getBaseContext());
        history2_recyclerview.setLayoutManager(linearLayoutManager);
        history2_recyclerview.setHasFixedSize(true);

        getHistoryByCustomerId(cid);
    }

    private void setupToolbar() {
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

    private void getHistoryByCustomerId(String custId) {
        loadingH.setVisibility(View.VISIBLE);

        ApiService apiService =
                RestApi.getClient().create(ApiService.class);

        Call<HistoryResponse> call = apiService.getHistoryByCustId(custId);
        call.enqueue(new Callback<HistoryResponse>() {
            @Override
            public void onResponse(Call<HistoryResponse>call, retrofit2.Response<HistoryResponse> response) {
                loadingH.setVisibility(View.GONE);

                historyList = response.body().getHistories();

                Log.d(TAG, "Status Code = " + response.code());
                Log.d(TAG, "Data received: " + new Gson().toJson(response.body()));

                adapter = new History2Adapter(historyList, R.layout.history2_card, getApplicationContext(), new History2Adapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(History model) {
                        String namaMerchant =  model.getStore_name();
                        String transactDate =  model.getTransaction_date();

                        Intent intent = new Intent(History2Activity.this, StrukDetailHistory.class);
                        intent.putExtra("namaStore", namaMerchant);
                        intent.putExtra("dateTransact", transactDate);
                        startActivity(intent);
                    }
                });
                history2_recyclerview.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<HistoryResponse>call, Throwable t) {
                loadingH.setVisibility(View.GONE);

                Log.e(TAG, t.toString());

                android.app.AlertDialog alertDialog = new android.app.AlertDialog.Builder(History2Activity.this).create();
                alertDialog.setTitle("Error");
                alertDialog.setMessage("Kesalahan Jaringan");
                alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        finish();
                        startActivity(getIntent());
                    }
                });
                alertDialog.show();
            }
        });
    }

    private boolean validationYearAndMonth (String currentMonthAndYear, String MonthAndYear){
        if (currentMonthAndYear.equals(MonthAndYear)){return true;}else {return false;}
    }

}


