package com.lijukay.quotes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import dev.oneuiproject.oneui.layout.ToolbarLayout;

public class About extends AppCompatActivity {

    int versionC;
    int versionA;
    private RequestQueue mRequestQueueU;
    private SwipeRefreshLayout swipeRefreshLayoutAb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ToolbarLayout toolbarLayoutAbout = findViewById(R.id.toolbar_about);

        toolbarLayoutAbout.setNavigationButtonAsBack();

        //Create a String with the current name of the App-Version
        String versionName = BuildConfig.VERSION_NAME;
        toolbarLayoutAbout.setExpandedSubtitle(versionName);

        ImageView telegram = findViewById(R.id.telegram_logo);
        telegram.setOnClickListener(view -> {
            Uri uriT = Uri.parse("https://t.me/Lijukay");
            Intent intentT = new Intent(Intent.ACTION_VIEW, uriT);
            startActivity(intentT);
        });
        ImageView github = findViewById(R.id.github_logo);
        github.setOnClickListener(view -> {
            Uri uriG = Uri.parse("https://github.com/Lijukay");
            Intent intentG = new Intent(Intent.ACTION_VIEW, uriG);
            startActivity(intentG);
        });

        swipeRefreshLayoutAb = findViewById(R.id.refreshAbout);
        swipeRefreshLayoutAb.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(About.this, "Refreshing... please wait", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayoutAb.setRefreshing(false);
                        parseJSONVersion();
                    }
                }, 2000);
            }
        });

        mRequestQueueU = Volley.newRequestQueue(this);
        parseJSONVersion();
    }
    private void parseJSONVersion() {
        String urlU = "https://lijukay.github.io/Quotes-M3/quotesEN.json";

        JsonObjectRequest requestU = new JsonObjectRequest(Request.Method.GET, urlU, null,
                responseU -> {
                    try {
                        JSONArray jsonArrayAll = responseU.getJSONArray("VersionS");

                        for(int a = 0; a < jsonArrayAll.length(); a++){
                            JSONObject v = jsonArrayAll.getJSONObject(a);

                            versionC = BuildConfig.VERSION_CODE;
                            versionA = v.getInt("VersionAS");

                        }
                        if (versionA > versionC){
                            Button update = findViewById(R.id.updateB);
                            TextView updateA = findViewById(R.id.updateT);

                            update.setVisibility(View.VISIBLE);
                            updateA.setVisibility(View.VISIBLE);

                            update.setOnClickListener(view -> {
                                Uri uriU = Uri.parse("https://github.com/Lijukay/Quotes-OneUI/releases/latest");
                                Intent intentU = new Intent(Intent.ACTION_VIEW, uriU);
                                startActivity(intentU);
                            });
                        }

                        Log.e("intent", "Refreshing completed...");
                        Toast.makeText(this, "Completed", Toast.LENGTH_SHORT).show();
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("error", "JSON Exeption.");
                    }
                }, errorAll -> {
            errorAll.printStackTrace();
            Log.e("error", "Something went wrong");
        });
        mRequestQueueU.add(requestU);
    }
}