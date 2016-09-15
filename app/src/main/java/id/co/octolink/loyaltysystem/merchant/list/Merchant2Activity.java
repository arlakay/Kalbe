package id.co.octolink.loyaltysystem.merchant.list;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.octolink.R;
import id.co.octolink.api.RestApi;
import id.co.octolink.api.services.ApiService;
import id.co.octolink.loyaltysystem.merchant.detail.MerchantDetail;
import id.co.octolink.model.Merchant;
import id.co.octolink.model.MerchantResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Merchant2Activity extends AppCompatActivity {
    private StoreAdapter adapter2;
    private List<Merchant> merchantList;
    private String TAG = Merchant2Activity.class.getSimpleName();
    private int idCategoryPromo2;
    private String categoryAfterFiltering;

    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.merchant_recyclerview) RecyclerView merchant_recyclerView;
    @BindView(R.id.loading_merchant)ProgressBar loadingM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant2);
        ButterKnife.bind(this);

        setupToolbar();
        getData();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplication().getBaseContext());
        merchant_recyclerView.setLayoutManager(linearLayoutManager);
        merchant_recyclerView.setHasFixedSize(true);

        getStoreByCategory(idCategoryPromo2);
    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() == null) {
            throw new IllegalStateException("Activity must implement toolbar");
        }
    }

    private void getData(){
        Intent i = getIntent();
        idCategoryPromo2 = i.getIntExtra("id", 0);

    }

    private void getStoreByCategory(int category) {
        loadingM.setVisibility(View.VISIBLE);

        Log.e(TAG, String.valueOf(category));
        if(category == 0){
            categoryAfterFiltering = "Architecture";
        }else if (category == 1) {
            categoryAfterFiltering = "Automotive";
        }else if (category == 2){
            categoryAfterFiltering = "F&B";
        }else if (category == 3){
            categoryAfterFiltering = "Health";
        }else if (category == 4){
            categoryAfterFiltering = "Leisure";
        }else if (category == 5){
            categoryAfterFiltering = "Sport";
        }else{
            categoryAfterFiltering = "Master";
        }
        Log.e(TAG, categoryAfterFiltering);

        ApiService apiService =
                RestApi.getClient().create(ApiService.class);

        Call<MerchantResponse> call = apiService.getMerchantByCategory(categoryAfterFiltering);
        call.enqueue(new Callback<MerchantResponse>() {
            @Override
            public void onResponse(Call<MerchantResponse>call, Response<MerchantResponse> response) {
                loadingM.setVisibility(View.GONE);

                merchantList = response.body().getStore();

                Log.d(TAG, "Status Code = " + response.code());
                Log.d(TAG, "Data received: " + new Gson().toJson(response.body()));

                adapter2 = new StoreAdapter(merchantList, R.layout.mercant_card, getApplicationContext(), new StoreAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(Merchant model) {
                        String namaStore =  model.getStore_name();
                        String addrStore =  model.getStreet();
                        String discStore = model.getDiscount();
                        String lati = model.getLatitude();
                        String lngi = model.getLongitude();

                        Intent intent = new Intent(Merchant2Activity.this, MerchantDetail.class);
                        intent.putExtra("namaStore", namaStore);
                        intent.putExtra("addrStore", addrStore);
                        intent.putExtra("discStore", discStore);
                        intent.putExtra("lattitude", lati);
                        intent.putExtra("longitude", lngi);
                        startActivity(intent);
                    }
                });
                merchant_recyclerView.setAdapter(adapter2);
            }

            @Override
            public void onFailure(Call<MerchantResponse>call, Throwable t) {
                loadingM.setVisibility(View.GONE);

                Log.e(TAG, t.toString());

                AlertDialog alertDialog = new AlertDialog.Builder(Merchant2Activity.this).create();
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

}
