package com.lijukay.quotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.util.SeslRoundedCorner;
import androidx.appcompat.util.SeslSubheaderRoundedCorner;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Persons> personsList;
    private RecyclerView recyclerView;
    private RecyclerAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        personsList = new ArrayList<>();

        setPersonsName();
        setAdapter();
    }


    private void setAdapter() {
        setOnClickListener();
        RecyclerAdapter adapter = new RecyclerAdapter(this, personsList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new ItemDecoration(this));
        recyclerView.setItemAnimator(null); //remove the other one
        recyclerView.seslSetFillBottomEnabled(true);
        recyclerView.seslSetLastRoundedCorner(true);
    }

    private void setOnClickListener() {
        listener = new RecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int position) {
                Intent intentOC = new Intent(getApplicationContext(), PersonsActivity.class);
                intentOC.putExtra("personsName", personsList.get(position).getPersonsName());
                startActivity(intentOC);
            }
        };
    }

    private void setPersonsName() {
        personsList.add(new Persons(getString(R.string.persons), true));
        //A
        personsList.add(new Persons("Astrid Alauda"));
        //B
        personsList.add(new Persons("Blaise Pascal"));
        personsList.add(new Persons("Benjamin Franklin"));
        personsList.add(new Persons("Bob Marley"));
        //C
        personsList.add(new Persons("Charles Bukowski"));
        personsList.add(new Persons("Coco Chanel"));
        //D
        personsList.add(new Persons("Dolly Parton"));
        //E
        personsList.add(new Persons("Ernest Hemingway"));
        //F
        //G
        personsList.add(new Persons("George Addair"));
        //H
        //I
        //J
        personsList.add(new Persons("Johann Wolfgang Goethe"));
        personsList.add(new Persons("Jean Paul"));
        personsList.add(new Persons("Joker"));
        personsList.add(new Persons("Joseph Camphell"));
        personsList.add(new Persons("John Wooden"));
        personsList.add(new Persons("Jackson Brown"));
        //K
        personsList.add(new Persons("Konfuzius"));
        //L
        personsList.add(new Persons("Lew Tolstoi"));
        personsList.add(new Persons("Lilian Dickson"));
        personsList.add(new Persons("Lucius Seneca"));
        personsList.add(new Persons("Laotse"));
        //M
        //N
        //O
        //P
        personsList.add(new Persons("Pablo Picasso"));
        //Q
        //R
        personsList.add(new Persons("Robert Schuller"));
        //S
        //T
        //U
        personsList.add(new Persons("Unknown"));
        //V
        //W
        personsList.add(new Persons("William Shakespeare"));
        personsList.add(new Persons("Winnie Pooh"));
        //X
        //Y
        //Z
    }
    private class ItemDecoration extends RecyclerView.ItemDecoration {
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

            for (int i = 0; i < parent.getChildCount(); i++) {
                View child = parent.getChildAt(i);
                RecyclerAdapter.ViewHolder holder
                        = (RecyclerAdapter.ViewHolder) parent.getChildViewHolder(child);
                if (!holder.isSeparator) {
                    final int top = child.getBottom()
                            + ((ViewGroup.MarginLayoutParams) child.getLayoutParams()).bottomMargin;
                    final int bottom = mDivider.getIntrinsicHeight() + top;

                    mDivider.setBounds(parent.getLeft(), top, parent.getRight(), bottom);
                    mDivider.draw(c);
                }
            }
        }

        @Override
        public void seslOnDispatchDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
            for (int i = 0; i < parent.getChildCount(); i++) {
                View child = parent.getChildAt(i);
                RecyclerAdapter.ViewHolder holder
                        = (RecyclerAdapter.ViewHolder) parent.getChildViewHolder(child);
                if (holder.isSeparator) {
                    mRoundedCorner.drawRoundedCorner(child, c);
                }
            }
        }
    }
}
