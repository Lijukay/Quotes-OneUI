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
import com.lijukay.quotes.About;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class PersonsActivity extends AppCompatActivity {
    private RecyclerView mRecyclerViewP;
    private PersonsAdapter mPAdapter;
    private ArrayList<PersonsItem> mPItem;
    private RequestQueue mRequestQueueP;
    private PersonsAdapter.RecyclerViewClickListener listener;
    private SwipeRefreshLayout swipeRefreshLayoutP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);


        mRecyclerViewP = findViewById(R.id.personsRV);
        mRecyclerViewP.setHasFixedSize(true);
        mRecyclerViewP.setLayoutManager(new LinearLayoutManager(this));

        mPItem = new ArrayList<>();
        swipeRefreshLayoutP = findViewById(R.id.swipeP);
        swipeRefreshLayoutP.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                Toast.makeText(PersonsActivity.this, "Refreshing... please wait", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        swipeRefreshLayoutP.setRefreshing(false);
                        mPItem.clear();
                        mPAdapter.notifyDataSetChanged();
                        parseJSONP();
                    }
                }, 2000);
            }
        });

        mRequestQueueP = Volley.newRequestQueue(this);
        parseJSONP();



    }

    private void parseJSONP() {
        String urlP = "https://lijukay.github.io/quotesaltdesign/editorschoice.json";


        JsonObjectRequest requestP = new JsonObjectRequest(Request.Method.GET, urlP, null,
                responseP -> {
                    try {
                        JSONArray jsonArrayP = responseP.getJSONArray("Persons");

                        for(int a = 0; a < jsonArrayP.length(); a++){
                            JSONObject ec = jsonArrayP.getJSONObject(a);

                            String authorP = ec.getString("authorP");

                            mPItem.add(new PersonsItem(authorP));
                        }

                        setOnClickListener();
                        mPAdapter = new PersonsAdapter(PersonsActivity.this, mPItem, listener);
                        mRecyclerViewP.setAdapter(mPAdapter);
                        mRecyclerViewP.addItemDecoration(new ItemDecoration(this));
                        Log.e("intent", "Hat geklapptAll...");
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Log.e("error", "hat nicht geklapptall...");
                    }
                }, errorAll -> {
            errorAll.printStackTrace();
            Log.e("error", "Hat nicht geklappt 2all");
        });
        mRequestQueueP.add(requestP);
    }

    private void setOnClickListener() {
        listener = (v, position) -> {
            String urlP = "https://lijukay.github.io/quotesaltdesign/editorschoice.json";


            JsonObjectRequest requestP = new JsonObjectRequest(Request.Method.GET, urlP, null,
                    responseP -> {
                        try {
                            JSONArray jsonArrayP = responseP.getJSONArray("Persons");

                            JSONObject ec = jsonArrayP.getJSONObject(position);

                            String authorP = ec.getString("authorP");

                            mPItem.add(new PersonsItem(authorP));

                            Intent intent = new Intent(PersonsActivity.this, PersonsQuote.class);
                            intent.putExtra("authorP", authorP);
                            startActivity(intent);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("error", "hat nicht geklapptall...");
                        }
                    }, errorAll -> {
                errorAll.printStackTrace();
                Log.e("error", "Hat nicht geklappt 2all");
            });
            mRequestQueueP.add(requestP);

        };
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_p, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.aboutP){
            AboutApp();
            return true;
        } else if(item.getItemId() == R.id.samsungdesignP){
            SamsungDesign();
            return true;
        } else if(item.getItemId() == R.id.ecP){
            ECP();
            return true;
        } else if(item.getItemId() == R.id.allP){
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

    private void ECP() {
        Intent intentP = new Intent(this, MainActivity.class);
        startActivity(intentP);
    }

    private void SamsungDesign() {
        Uri uriS = Uri.parse("https://github.com/Lijukay/quotesaltdesign");
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