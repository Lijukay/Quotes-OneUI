package com.lijukay.quotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.util.SeslRoundedCorner;
import androidx.appcompat.util.SeslSubheaderRoundedCorner;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private ECAdapter mECAdapter;
    private ArrayList<ECItems> mECItem;
    private RequestQueue mRequestQueue;
    private SwipeRefreshLayout swipeRefreshLayoutEC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.editorsChoiceRV);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mECItem = new ArrayList<>();
        swipeRefreshLayoutEC = findViewById(R.id.swipeEC);
        swipeRefreshLayoutEC.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(MainActivity.this, "Refreshing... please wait", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayoutEC.setRefreshing(false);
                        mECItem.clear();
                        mECAdapter.notifyDataSetChanged();
                        getLanguage();
                    }
                }, 2000);
            }
        });
        mRequestQueue = Volley.newRequestQueue(this);
        getLanguage();
    }

    private void getLanguage() {
        String lang = Locale.getDefault().getLanguage();
        if (lang.equals("en")){
            parseJSON();
        } else if (lang.equals("de")){
            parseJSONGER();
        } else{
            parseJSON();
        }
    }

    private void parseJSONGER() {
        String urlGER = "https://lijukay.github.io/Quotes-M3/quotesGER.json";

        JsonObjectRequest requestGER = new JsonObjectRequest(Request.Method.GET, urlGER, null,
                response -> {
                    try {
                        JSONArray jsonArrayGER = response.getJSONArray("EditorsChoice");

                        for(int i = 0; i < jsonArrayGER.length(); i++){
                            JSONObject ec = jsonArrayGER.getJSONObject(i);

                            String quoteECGER = ec.getString("quote");
                            String authorECGER = ec.getString("author");

                            mECItem.add(new ECItems(authorECGER, quoteECGER));
                        }

                        mECAdapter = new ECAdapter(MainActivity.this, mECItem);
                        mRecyclerView.setAdapter(mECAdapter);
                        mRecyclerView.addItemDecoration(new ItemDecoration(this));
                        Log.e("intent", "Hat geklappt...");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("error", "hat nicht geklappt...");
                    }
                }, error -> {
            error.printStackTrace();
            Log.e("error", "Hat nicht geklappt 2");
        });
        mRequestQueue.add(requestGER);
    }

    private void parseJSON() {
        String url = "https://lijukay.github.io/Quotes-M3/quotesEN.json";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                response -> {
                    try {
                        JSONArray jsonArray = response.getJSONArray("EditorsChoice");

                        for(int i = 0; i < jsonArray.length(); i++){
                            JSONObject ec = jsonArray.getJSONObject(i);

                            String quoteEC = ec.getString("quote");
                            String authorEC = ec.getString("author");

                            mECItem.add(new ECItems(authorEC, quoteEC));
                        }

                        mECAdapter = new ECAdapter(MainActivity.this, mECItem);
                        mRecyclerView.setAdapter(mECAdapter);
                        mRecyclerView.addItemDecoration(new ItemDecoration(this));
                        Log.e("intent", "Hat geklappt...");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("error", "hat nicht geklappt...");
                    }
                }, error -> {
            error.printStackTrace();
            Log.e("error", "Hat nicht geklappt 2");
        });
        mRequestQueue.add(request);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.about){
            AboutApp();
            return true;
        } else if(item.getItemId() == R.id.samsungdesign){
            SamsungDesign();
            return true;
        } else if(item.getItemId() == R.id.people){
            People();
            return true;
        } else if(item.getItemId() == R.id.all){
            All();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void All() {
        Intent intentAM = new Intent(this, AllActivity.class);
        startActivity(intentAM);
    }
    private void People() {
        Intent intentP = new Intent(this, PersonsActivity.class);
        startActivity(intentP);
    }
    private void SamsungDesign() {
        Uri uriS = Uri.parse("https://github.com/Lijukay/Quotes-M3");
        Intent intentS = new Intent(Intent.ACTION_VIEW, uriS);
        startActivity(intentS);
    }
    private void AboutApp() {
        Intent intentA = new Intent(this, About.class);
        startActivity(intentA);
    }

    //Item Decoration, code by Yanndroid
    private static class ItemDecoration extends RecyclerView.ItemDecoration {
        private final Drawable mDivider;
        private final SeslSubheaderRoundedCorner mRoundedCorner;

        public ItemDecoration(@NonNull Context context) {
            TypedValue outValue = new TypedValue();
            context.getTheme().resolveAttribute(dev.oneuiproject.oneui.R.attr.isLightTheme, outValue, true);

            mDivider = context.getDrawable(outValue.data == 0
                    ? dev.oneuiproject.oneui.R.drawable.sesl_list_divider_dark
                    : dev.oneuiproject.oneui.R.drawable.sesl_list_divider_light);

            mRoundedCorner = new SeslSubheaderRoundedCorner(context);
            mRoundedCorner.setRoundedCorners(SeslRoundedCorner.ROUNDED_CORNER_ALL);
        }
        @Override
        public void onDraw(@NonNull Canvas c, @NonNull RecyclerView parent,
                           @NonNull RecyclerView.State state) {
            super.onDraw(c, parent, state);

            for (int i= 0; i < parent.getChildCount(); i++) {
                View child = parent.getChildAt(i);
                final int top = child.getBottom()
                        + ((ViewGroup.MarginLayoutParams) child.getLayoutParams()).bottomMargin;
                final int bottom = mDivider.getIntrinsicHeight() + top;

                mDivider.setBounds(parent.getLeft(), top, parent.getRight(), bottom);
                mDivider.draw(c);
            }
        }
    }
}

