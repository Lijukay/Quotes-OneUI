package com.lijukay.quotes;


import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.util.SeslRoundedCorner;
import androidx.appcompat.util.SeslSubheaderRoundedCorner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

import dev.oneuiproject.oneui.layout.ToolbarLayout;

public class PersonsActivity extends AppCompatActivity {

    private ArrayList<Quotes> quotesList;
    private RecyclerView recyclerViewq;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.persons_activity);

        ToolbarLayout toolbarLayout = findViewById(R.id.toolbar_persons);

        String personsName = "personsName not set";

        Bundle extras = getIntent().getExtras();

        if (extras != null){
            personsName = extras.getString("personsName");
        }

        toolbarLayout.setTitle(personsName);

        toolbarLayout.setNavigationButtonAsBack();
        toolbarLayout.getAppBarLayout().addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            final int totalScrollRange = appBarLayout.getTotalScrollRange();
            FrameLayout content = findViewById(dev.oneuiproject.oneui.R.id.main_content);
            if (content != null) {
                content.setTranslationY(((float) (Math.abs(verticalOffset) - totalScrollRange)) / 2.0f);
            }
        });

        recyclerViewq = findViewById(R.id.recyclerViewQuotes);
        quotesList = new ArrayList<>();

        switch (personsName){
            //A
            case "Astrid Alauda":
                setQuotesNameAA();
                break;
            //B
            case "Benjamin Franklin":
                setQuotesNameBF();
                break;
            //C
            case "Charles Bukowski":
                setQuotesNameCB();
                break;
            case "Coco Chanel":
                setQuotesNameCC();
                break;
            //D
            case "Dolly Parton":
                setQuotesNameDP();
                break;
            //E
            case "Ernest Hemingway":
                setQuotesNameEH();
                break;
            //F
            //G
            case "George Addair":
                setQuotesNameGA();
                break;
            //H
            //I
            //J
            case "Joker":
                setQuotesNameJ();
                break;
            case "Joseph Camphell":
                setQuotesNameJC();
                break;
            case "John Wooden":
                setQuotesNameJW();
                break;
            //K
            //L
            case "Lilian Dickson":
                setQuotesNameLD();
                break;
            //M
            //N
            //O
            //P
            //Q
            //R
            case "Robert Schuller":
                setQuotesNameRS();
                break;
            //S
            //T
            //U
            case "Unknown":
                setQuotesNameU();
                break;
            //V
            //W
            case "William Shakespeare":
                setQuotesNameWS();
                break;
            case "Winnie Pooh":
                setQuotesNameWP();
                break;
            //X
            //Y
            //Z
        }

        setAdapterq();
    }
    //A
    private void setQuotesNameAA() {
        quotesList.add(new Quotes("The wounds you do not see, are the most difficult to cure"));
    }
    //B
    private void setQuotesNameBF() {
        quotesList.add(new Quotes("Some people are dying at the age of 25 but are buried at the age of 75"));
    }
    //C
    private void setQuotesNameCB() {
        quotesList.add(new Quotes("Do you remember who you were before the world told you who to be?"));
    }
    private void setQuotesNameCC(){
        quotesList.add(new Quotes("I do not regret anything in life except for the things I did not do"));
    }
    //D
    private void setQuotesNameDP() {
        quotesList.add(new Quotes("If you don't like the path you're walking, simply make a new one."));
        quotesList.add(new Quotes("When someone shows you their true colors, thrust them."));
    }
    //E
    private void setQuotesNameEH() {
        quotesList.add(new Quotes("You are so brave and quiet that I forget that you are suffering"));
    }
    //F
    //G
    private void setQuotesNameGA(){
        quotesList.add(new Quotes("Everything you ever wanted is on the other side of the fear"));
    }
    //H
    //I
    //J
    private void setQuotesNameJW() {
        quotesList.add(new Quotes("Do not give up on your dreams or your dreams will give up on you"));
    }

    private void setQuotesNameJC() {
        quotesList.add(new Quotes("The cage you fear to enter includes the treasure you are searching"));
    }

    private void setQuotesNameJ() {
        quotesList.add(new Quotes("Pain is not just visible in tears. Sometimes it is hidden behind a smile."));
    }
    //K
    //L
    private void setQuotesNameLD() {
        quotesList.add(new Quotes("The life is like a coin. You can buy anything with it but just one time"));
    }
    //M
    //N
    //O
    //P
    //Q
    //R
    //S
    private void setQuotesNameRS() {
        quotesList.add(new Quotes("What would you do if you would know that you cannot lose?"));
    }
    //T
    //U
    private void setQuotesNameU() {
        quotesList.add(new Quotes("I would like to travel back to the past, not to avoid mistakes but to give a hug to somebody who is not here anymore."));
        quotesList.add(new Quotes("Broken humans smile the most beautiful smile, because they know what luck means."));
        quotesList.add(new Quotes("It is not the things that scares us, it is the way we think about it."));
        quotesList.add(new Quotes("The worst feeling is, when you are at home but have the feeling you want to go home."));
        quotesList.add(new Quotes("Sometimes good things end because the people are not ready for it."));
        quotesList.add(new Quotes("If you are not ready for it you would not have the possibility to do it."));
        quotesList.add(new Quotes("The worst kind of sadness is the one you cannot explain."));
        quotesList.add(new Quotes("Although thoughts do not weigh anything, you can collapse under their load."));
        quotesList.add(new Quotes("Grief is not the opposite of luck, it is a part of it."));
        quotesList.add(new Quotes("The death must be a wonderful place because no one has returned yet"));
    }
    //V
    //W
    private void setQuotesNameWP() {
        quotesList.add(new Quotes("How to spell love? You don't spell it, you feel it."));
        quotesList.add(new Quotes("Some people care a lot of someone. I think that is called love"));
    }

    private void setQuotesNameWS() {
        quotesList.add(new Quotes(""));
    }
    //X
    //Y
    //Z






    private void setAdapterq() {
        QuotesAdapter adapterq = new QuotesAdapter(this, quotesList);
        RecyclerView.LayoutManager layoutManagerq = new LinearLayoutManager(getApplicationContext());
        recyclerViewq.setLayoutManager(layoutManagerq);
        recyclerViewq.setAdapter(adapterq);
        recyclerViewq.addItemDecoration(new PersonsActivity.ItemDecorationq(this));
        recyclerViewq.setItemAnimator(null);
        recyclerViewq.seslSetFillBottomEnabled(true);
        recyclerViewq.seslSetLastRoundedCorner(true);
    }



    private class ItemDecorationq extends RecyclerView.ItemDecoration {
        private final Drawable mDividerq;
        private final SeslSubheaderRoundedCorner mRoundedCornerq;

        public ItemDecorationq(@NonNull Context contextq) {
            TypedValue outValueq = new TypedValue();
            contextq.getTheme().resolveAttribute(dev.oneuiproject.oneui.R.attr.isLightTheme, outValueq, true);

            mDividerq = contextq.getDrawable(outValueq.data == 0
                    ? dev.oneuiproject.oneui.R.drawable.sesl_list_divider_dark
                    : dev.oneuiproject.oneui.R.drawable.sesl_list_divider_light);

            mRoundedCornerq = new SeslSubheaderRoundedCorner(contextq);
            mRoundedCornerq.setRoundedCorners(SeslRoundedCorner.ROUNDED_CORNER_ALL);
        }

        @Override
        public void onDraw(@NonNull Canvas q, @NonNull RecyclerView parentq,
                           @NonNull RecyclerView.State stateq) {
            super.onDraw(q, parentq, stateq);

            for (int qu= 0; qu < parentq.getChildCount(); qu++) {
                View childq = parentq.getChildAt(qu);
                QuotesAdapter.QViewHolder holderq
                        = (QuotesAdapter.QViewHolder) parentq.getChildViewHolder(childq);
                if (!holderq.isSeparatorq) {
                    final int topq = childq.getBottom()
                            + ((ViewGroup.MarginLayoutParams) childq.getLayoutParams()).bottomMargin;
                    final int bottomq = mDividerq.getIntrinsicHeight() + topq;

                    mDividerq.setBounds(parentq.getLeft(), topq, parentq.getRight(), bottomq);
                    mDividerq.draw(q);
                }
            }
        }

        @Override
        public void seslOnDispatchDraw(Canvas q, RecyclerView parentq, RecyclerView.State stateq) {
            for (int qu = 0; qu < parentq.getChildCount(); qu++) {
                View childq = parentq.getChildAt(qu);
                QuotesAdapter.QViewHolder holderq
                        = (QuotesAdapter.QViewHolder) parentq.getChildViewHolder(childq);
                if (holderq.isSeparatorq) {
                    mRoundedCornerq.drawRoundedCorner(childq, q);
                }
            }
        }
    }
}
