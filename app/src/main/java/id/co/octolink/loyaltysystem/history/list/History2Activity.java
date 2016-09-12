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
import id.co.octolink.utils.Constants;
import id.co.octolink.utils.SessionManager;

public class History2Activity extends AppCompatActivity {
    private static final String url =  Constants.BASE_URL + "/users/history";
    @BindView(R.id.toolbar)Toolbar toolbar;
    @BindView(R.id.history2_recyclerview)RecyclerView history2_recyclerview;
    ArrayList<HashMap<String, String>> arraylist;
    private History2Adapter adapter;
    private SwipeRefreshLayout swipeContainerHistory;
    SessionManager session;
    String d_version = "0.0.0.1";
    String currentDate,yearNow,monthNow,year,month;
    private List<History2> eventList = new ArrayList<History2>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);
        ButterKnife.bind(this);

        setupToolbar();
        getHistoryFromCloud();

        //List<History2> history2 = fill_with_history();
        adapter = new History2Adapter(eventList, this);
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

    private void getHistoryFromCloud(){
        session = new SessionManager(getApplicationContext());
        HashMap<String, String> user = session.getUserDetails();
        final String cid = user.get(SessionManager.KEY_CID);

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
        Date date = new Date();
        currentDate = dateFormat.format(date);

        //Log.e("CURRENT_DATE",currentDate);

        StringRequest movieReq = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                //Log.d("History Bro : ", response.toString());
                arraylist = new ArrayList<HashMap<String, String>>();
                //hidePDialog();
                try {
                    //Thread.sleep(2000);
                    JSONObject job = new JSONObject(response);
                    JSONArray data = job.getJSONArray("history");
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject obj = data.getJSONObject(i);
                        History2 event = new History2();
//                        event.setTitle(obj.getString("merchant_id"));
//                        event.setDesc(obj.getString("transaction_date"));
                        event.setDatemerchant_history2(obj.getString("total_amount"));
                        event.setAddressmerchant_history2(obj.getString("merchant_name"));
                        event.setNamemerchant_history2(obj.getString("store_name"));
//                        event.setDiskon(obj.getString("discount"));

                        String date = event.getDatemerchant_history2();
                        String dateFromAPI = "";
                        for (int j = 0; j <7 ; j++) {
                            //dateFromAPI += date.charAt(j);
                        }

                        if (validationYearAndMonth(currentDate,dateFromAPI)){
                            eventList.add(event);
                        }

                        HashMap<String, String> map = new HashMap<String, String>();
                        obj = data.getJSONObject(i);
                        // Retrive JSON Objects
                        map.put("name", obj.getString("merchant_name"));
                        map.put("rank", obj.getString("merchant_id"));
                        map.put("country", obj.getString("transaction_date"));
                        map.put("population", obj.getString("total_amount"));
                        arraylist.add(map);
                    }

                    history2_recyclerview.setAdapter(adapter);
//                    swipeContainerHistory.setRefreshing(false);
                }

                catch (JSONException e) {
                    e.printStackTrace();
                }/*catch (InterruptedException e) {
                    e.printStackTrace();
                }*/
                //hidePDialog();
                adapter.notifyDataSetChanged();
                //hidePDialog();

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //VolleyLog.d(TAG, "Error: " + error.getMessage());
                //hidePDialog();
                swipeContainerHistory.setRefreshing(false);

//                alertDialogBuilder.setMessage("Error in Collecting Data \n" +
//                        "Swipe Down to Refresh");
//                alertDialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        //comment
//                    }
//                });
//                AlertDialog alertDialog = alertDialogBuilder.create();
//                alertDialog.show();

            }
        }) {
            @Override
            protected Map<String, String> getParams() {
                // Posting parameters to login url
                Map<String, String> params = new HashMap<String, String>();
                params.put("cid", cid);
                //Log.d("cidkey", "cidkey" + cid);
                return params;
            }
        };

        movieReq.setRetryPolicy(new DefaultRetryPolicy(
                (int) TimeUnit.SECONDS.toMillis(20),
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        AppController.getInstance().addToRequestQueue(movieReq);
        History2Adapter adapter = new History2Adapter(eventList, History2Activity.this);
        history2_recyclerview.setAdapter(adapter);
    }

    private boolean validationYearAndMonth (String currentMonthAndYear, String MonthAndYear){

        if (currentMonthAndYear.equals(MonthAndYear)){return true;}else {return false;}
    }
}


