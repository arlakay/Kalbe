package id.co.octolink.loyaltysystem.merchant.detail;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.co.octolink.R;
import id.co.octolink.loyaltysystem.merchant.list.Merchant2Activity;

public class MerchantDetail extends AppCompatActivity {
    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.toolbar_layout)CollapsingToolbarLayout collapsingToolbarLayout;
    TextView txt_detail_place_name, txt_detail_street_name;
    private String storeName;
    private String storeStreet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_promo);
        ButterKnife.bind(this);

        setupToolbar();

        Intent i = getIntent();
        storeName = i.getStringExtra("namaStore");
        storeStreet = i.getStringExtra("streetStore");

        txt_detail_place_name = (TextView) findViewById(R.id.txt_detail_place_name);
        txt_detail_place_name.setText(storeName);

        txt_detail_street_name = (TextView) findViewById(R.id.txt_detail_street_name);
        //txt_detail_street_name.setText(storeStreet);
        collapsingToolbarLayout.setTitleEnabled(true);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(R.color.transparent));

    }

    private void setupToolbar() {
        setSupportActionBar(toolbar);

        if (getSupportActionBar() == null) {
            throw new IllegalStateException("Activity must implement toolbar");
        }
    }

}
