package id.co.octolink.loyaltysystem.merchant.detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.octolink.R;

public class MerchantDetail extends AppCompatActivity {
    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.toolbar_layout)CollapsingToolbarLayout collapsingToolbarLayout;
    @BindView(R.id.txt_detail_place_name)TextView txt_detail_place_name;
    @BindView(R.id.txt_detail_street_name)TextView txt_detail_street_name;
    @BindView(R.id.txt_detail_diskon)TextView txt_detail_diskon;

    private String storeName, storeAddr, storeDisc, storeLati, storeLngi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_promo);
        ButterKnife.bind(this);

        setupToolbar();
        getData();

        txt_detail_place_name.setText(storeName);
        txt_detail_street_name.setText(storeAddr);
        txt_detail_diskon.setText("Discount "+storeDisc+"%");

        collapsingToolbarLayout.setTitleEnabled(true);
        collapsingToolbarLayout.setTitle(storeName);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.transparent));

    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() == null) {
            throw new IllegalStateException("Activity must implement toolbar");
        }
    }

    private void getData(){
        Intent i = getIntent();
        storeName = i.getStringExtra("namaStore");
        storeAddr = i.getStringExtra("addrStore");
        storeDisc = i.getStringExtra("discStore");
        storeLati = i.getStringExtra("lattitude");
        storeLngi = i.getStringExtra("longitude");
    }

}
