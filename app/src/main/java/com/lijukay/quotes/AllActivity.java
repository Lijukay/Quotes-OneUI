package com.lijukay.quotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.util.SeslRoundedCorner;
import androidx.appcompat.util.SeslSubheaderRoundedCorner;
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

    public class AllActivity extends AppCompatActivity {
        private RecyclerView mRecyclerViewAll;
        private AllAdapter mAllAdapter;
        private ArrayList<AllItem> mAllItem;
        private RequestQueue mRequestQueueAll;
        private SwipeRefreshLayout swipeRefreshLayoutAll;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_all_quotes);

            mRecyclerViewAll = findViewById(R.id.allQuotesRV);
            mRecyclerViewAll.setHasFixedSize(true);
            mRecyclerViewAll.setLayoutManager(new LinearLayoutManager(this));

            mAllItem = new ArrayList<>();
            swipeRefreshLayoutAll = findViewById(R.id.swipeAll);
            swipeRefreshLayoutAll.setOnRefreshListener(() -> {
                Toast.makeText(AllActivity.this, "Refreshing... please wait", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(() -> {
                    swipeRefreshLayoutAll.setRefreshing(false);
                    mAllItem.clear();
                    mAllAdapter.notifyDataSetChanged();
                    parseJSONAll();
                }, 2000);
            });
            mRequestQueueAll = Volley.newRequestQueue(this);
            parseJSONAll();
        }

        private void parseJSONAll() {
            String urlAll = "https://lijukay.github.io/quotesaltdesign/editorschoice.json";

            JsonObjectRequest requestAll = new JsonObjectRequest(Request.Method.GET, urlAll, null,
                    responseAll -> {
                        try {
                            JSONArray jsonArrayAll = responseAll.getJSONArray("AllQuotes");

                            for(int a = 0; a < jsonArrayAll.length(); a++){
                                JSONObject ec = jsonArrayAll.getJSONObject(a);

                                String quoteAll = ec.getString("quoteAll");
                                String authorAll = ec.getString("authorAll");

                                mAllItem.add(new AllItem(authorAll, quoteAll));
                            }

                            mAllAdapter = new AllAdapter(AllActivity.this, mAllItem);
                            mRecyclerViewAll.setAdapter(mAllAdapter);
                            mRecyclerViewAll.addItemDecoration(new ItemDecoration(this));
                            Log.e("intent", "Hat geklapptAll...");
                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.e("error", "hat nicht geklapptall...");
                        }
                    }, errorAll -> {
                errorAll.printStackTrace();
                Log.e("error", "Hat nicht geklappt 2all");
            });
            mRequestQueueAll.add(requestAll);
        }


        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.menu_aq, menu);
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
            Intent intentEM = new Intent(this, MainActivity.class);
            startActivity(intentEM);
        }

        private void People() {
            Intent intentP = new Intent(this, PersonsActivity.class);
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
