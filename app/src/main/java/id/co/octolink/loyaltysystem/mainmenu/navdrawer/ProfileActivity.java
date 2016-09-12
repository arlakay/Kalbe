package id.co.octolink.loyaltysystem.mainmenu.navdrawer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import id.co.octolink.R;
import id.co.octolink.loyaltysystem.mainmenu.Main2Activity;

public class ProfileActivity extends AppCompatActivity {
    TextView creditcard_name;
    ImageView creditcard_photo;
    String fullname;
    Toolbar toolbar;
    int photo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        creditcard_name = (TextView) findViewById(R.id.credit_card_name);
        creditcard_photo = (ImageView) findViewById(R.id.credit_card_photo);
        Intent i = getIntent();
        fullname = i.getStringExtra("fullname");
        photo = getIntent().getIntExtra("image_url",R.drawable.photo);
        creditcard_name.setText(fullname);
        creditcard_photo.setImageResource(photo);
        //TOOLBAR BACK BUTTON
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);
    }


    public boolean onOptionsItemSelected(MenuItem item){
//        Intent myIntent = new Intent(ProfileActivity.this, Main2Activity.class);
//        startActivityForResult(myIntent, 0);
//        finish();
        onBackPressed();
        return true;

    }
}
