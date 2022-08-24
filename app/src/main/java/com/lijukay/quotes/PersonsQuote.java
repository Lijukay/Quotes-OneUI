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
import com.google.android.material.appbar.CollapsingToolbarLayout;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.Locale;

import dev.oneuiproject.oneui.layout.ToolbarLayout;

public class PersonsQuote extends AppCompatActivity {
    private RecyclerView mRecyclerViewPQ;
    private PQAdapter mPQAdapter;
    private ArrayList<PQItem> mPQItem;
    private RequestQueue mRequestQueuePQ;
    private String pQuotes;
    private String authorP;
    private SwipeRefreshLayout swipeRefreshLayoutPQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons_quote);



        Intent intent = getIntent();

        authorP = intent.getStringExtra("authorP");

        ToolbarLayout toolbarLayout = findViewById(R.id.tlPQ);
        toolbarLayout.setTitle(authorP);


        mRecyclerViewPQ = findViewById(R.id.PQRV);
        mRecyclerViewPQ.setHasFixedSize(true);
        mRecyclerViewPQ.setLayoutManager(new LinearLayoutManager(this));

        mPQItem = new ArrayList<>();

        swipeRefreshLayoutPQ = findViewById(R.id.swipePQ);
        swipeRefreshLayoutPQ.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(PersonsQuote.this, "Refreshing... please wait", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayoutPQ.setRefreshing(false);
                        mPQItem.clear();
                        mPQAdapter.notifyDataSetChanged();
                        getLanguagePQ();
                    }
                }, 2000);
            }
        });

        mRequestQueuePQ = Volley.newRequestQueue(this);
        getLanguagePQ();
    }

    private void getLanguagePQ() {
        String langPQ = Locale.getDefault().getLanguage();
        if (langPQ.equals("en")){
            parseJSONPQ();
        } else if (langPQ.equals("de")){
            parseJSONPQGER();
        } else {
            parseJSONPQ();
        }
    }

    private void parseJSONPQGER() {
        String urlPQ = "https://lijukay.github.io/Quotes-M3/quotesGER.json";


        JsonObjectRequest requestPQGER = new JsonObjectRequest(Request.Method.GET, urlPQ, null,
                responsePQGER -> {
                    try {
                        pQuotes = authorP;
                        JSONArray jsonArrayPQGER = responsePQGER.getJSONArray(pQuotes);

                        for(int a = 0; a < jsonArrayPQGER.length(); a++){
                            JSONObject pq = jsonArrayPQGER.getJSONObject(a);

                            String quotePQGER = pq.getString("quotePQ");
                            String authorPQGER = pq.getString("authorPQ");

                            mPQItem.add(new PQItem(authorPQGER, quotePQGER));
                        }

                        mPQAdapter = new PQAdapter(PersonsQuote.this, mPQItem);
                        mRecyclerViewPQ.setAdapter(mPQAdapter);
                        mRecyclerViewPQ.addItemDecoration(new ItemDecoration(this));
                        Log.e("intent", "Hat geklapptAll...");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("error", "hat nicht geklapptall...");
                    }
                }, errorPQ -> {
            errorPQ.printStackTrace();
            Log.e("error", "Hat nicht geklappt 2all");
        });
        mRequestQueuePQ.add(requestPQGER);
    }

    private void parseJSONPQ() {
        String urlPQ = "https://lijukay.github.io/Quotes-M3/quotesEN.json";


        JsonObjectRequest requestPQ = new JsonObjectRequest(Request.Method.GET, urlPQ, null,
                responsePQ -> {
                    try {
                        pQuotes = authorP;
                        JSONArray jsonArrayPQ = responsePQ.getJSONArray(pQuotes);

                        for(int a = 0; a < jsonArrayPQ.length(); a++){
                            JSONObject pq = jsonArrayPQ.getJSONObject(a);

                            String quotePQ = pq.getString("quotePQ");
                            String authorPQ = pq.getString("authorPQ");

                            mPQItem.add(new PQItem(authorPQ, quotePQ));
                        }

                        mPQAdapter = new PQAdapter(PersonsQuote.this, mPQItem);
                        mRecyclerViewPQ.setAdapter(mPQAdapter);
                        mRecyclerViewPQ.addItemDecoration(new ItemDecoration(this));
                        Log.e("intent", "Hat geklapptAll...");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("error", "hat nicht geklapptall...");
                    }
                }, errorPQ -> {
            errorPQ.printStackTrace();
            Log.e("error", "Hat nicht geklappt 2all");
        });
        mRequestQueuePQ.add(requestPQ);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menuPQ) {
        getMenuInflater().inflate(R.menu.menu_aq, menuPQ);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.aboutA){
            AboutApp();
            return true;
        } else if(item.getItemId() == R.id.samsungdesignA){
            SamsungDesign();
            return true;
        } else if(item.getItemId() == R.id.personsA){
            People();
            return true;
        } else if(item.getItemId() == R.id.ecA){
            ECA();
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    private void ECA() {
        Intent intentAM = new Intent(this, MainActivity.class);
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