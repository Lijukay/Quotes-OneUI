package com.lijukay.quotes;


import android.content.Context;
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
        //Get extras to set the Title of the Toolbar-Layout
        Bundle extras = getIntent().getExtras();
        if (extras != null){
            personsName = extras.getString("personsName");
        }
        //set the title of the Toolbar-Layout with the name of the clicked Item from MainActivity.java
        toolbarLayout.setTitle(personsName);
        //set Navigation Button as back to always go back to the MainActivity
        toolbarLayout.setNavigationButtonAsBack();
        //Set Toolbar-Animation(?), code by BlackMesa123
        toolbarLayout.getAppBarLayout().addOnOffsetChangedListener((appBarLayout, verticalOffset) -> {
            final int totalScrollRange = appBarLayout.getTotalScrollRange();
            FrameLayout content = findViewById(dev.oneuiproject.oneui.R.id.main_content);
            if (content != null) {
                content.setTranslationY(((float) (Math.abs(verticalOffset) - totalScrollRange)) / 2.0f);
            }
        });

        recyclerViewq = findViewById(R.id.recyclerViewQuotes);
        quotesList = new ArrayList<>();



        //Switch to add items to the RecyclerView based on personsName, sorted by the Name
        switch (personsName){
            //A
            case "Astrid Alauda":
                setQuotesNameAA();
                break;
            //B
            case "Benjamin Franklin":
                setQuotesNameBF();
                break;
            case "Blaise Pascal":
                setQuotesNameBP();
                break;
            case "Bob Marley":
                setQuotesNameBM();
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
            case "Franz Kafka":
                setQuotesNameFK();
            //G
            case "George Addair":
                setQuotesNameGA();
                break;
            //H
            //I
            //J
            case "Johann Wolfgang Goethe":
                setQuotesNameJWG();
                break;
            case "Joker":
                setQuotesNameJ();
                break;
            case "Joseph Camphell":
                setQuotesNameJC();
                break;
            case "John Wooden":
                setQuotesNameJW();
                break;
            case "Jackson Brown":
                setQuotesNameJB();
                break;
            case "Jean Paul":
                setQuotesNameJP();
                break;
            //K
            case "Konfuzius":
                setQuotesNameK();
                break;
            //L
            case "Lew Tolstoi":
                setQuotesNameLT();
                break;
            case "Lilian Dickson":
                setQuotesNameLD();
                break;
            case "Lucius Seneca":
                setQuotesNameLS();
                break;
            case "Laotse":
                setQuotesNameL();
                break;
            //M
            case "Mark Aurel":
                setQuotesNameMA();
                break;
            //N
            //O
            //P
            case "Pablo Picasso":
                setQuotesNamePP();
                break;
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

            //#
        }

        setAdapterq();
    }

    //Set Quotes, sorted by Name of Person
    //A
    private void setQuotesNameAA() {
        quotesList.add(new Quotes(getString(R.string.QuoteAA1)));
    }
    //B
    private void setQuotesNameBF() {
        quotesList.add(new Quotes(getString(R.string.QuoteBF1)));
    }
    private void setQuotesNameBP() {
        quotesList.add(new Quotes(getString(R.string.QouteBP1)));
    }
    private void setQuotesNameBM() {
        quotesList.add(new Quotes(getString(R.string.QuoteBM1)));
        quotesList.add(new Quotes(getString(R.string.QuoteBM2)));
        quotesList.add(new Quotes(getString(R.string.QuoteBM3)));
        quotesList.add(new Quotes(getString(R.string.QuoteBM4)));
    }
    //C
    private void setQuotesNameCB() {
        quotesList.add(new Quotes(getString(R.string.QuoteCB1)));
    }
    private void setQuotesNameCC(){
        quotesList.add(new Quotes(getString(R.string.QuoteCC1)));
        quotesList.add(new Quotes(getString(R.string.QuoteCC2)));
    }
    //D
    private void setQuotesNameDP() {
        quotesList.add(new Quotes(getString(R.string.QuoteDP1)));
        quotesList.add(new Quotes(getString(R.string.QuoteDP2)));
    }
    //E
    private void setQuotesNameEH() {
        quotesList.add(new Quotes(getString(R.string.QuoteEH1)));
    }
    //F
    private void setQuotesNameFK(){
        quotesList.add(new Quotes(getString(R.string.QuoteFK1)));
    }
    //G
    private void setQuotesNameGA(){
        quotesList.add(new Quotes(getString(R.string.QuotesGA1)));
    }
    //H
    //I
    //J
    private void setQuotesNameJP() {
        quotesList.add(new Quotes(getString(R.string.QuotesJP1)));
    }
    private void setQuotesNameJWG(){
        quotesList.add(new Quotes(getString(R.string.QuotesJWG1)));
        quotesList.add(new Quotes(getString(R.string.QuotesJWG2)));
    }
    private void setQuotesNameJW() {
        quotesList.add(new Quotes(getString(R.string.QuotesJW1)));
    }
    private void setQuotesNameJC() {
        quotesList.add(new Quotes(getString(R.string.QuotesJC1)));
    }
    private void setQuotesNameJ() {
        quotesList.add(new Quotes(getString(R.string.QuotesJ1)));
        quotesList.add(new Quotes(getString(R.string.QuotesJ2)));
    }
    private void setQuotesNameJB(){
        quotesList.add(new Quotes(getString(R.string.QuoteJB1)));
    }
    //K
    private void setQuotesNameK(){
        quotesList.add(new Quotes(getString(R.string.QuoteK1)));
    }
    //L
    private void setQuotesNameLT(){
        quotesList.add(new Quotes(getString(R.string.QuoteLT1)));
    }
    private void setQuotesNameLD() {
        quotesList.add(new Quotes(getString(R.string.QuoteLD1)));
    }
    private void setQuotesNameLS() {
        quotesList.add(new Quotes(getString(R.string.QuoteLS1)));
    }
    private void setQuotesNameL(){
        quotesList.add(new Quotes(getString(R.string.QuoteL1)));
    }
    //M
    private void setQuotesNameMA(){
        quotesList.add(new Quotes(getString(R.string.QuoteMA1)));
    }
    //N
    //O
    //P
    private void setQuotesNamePP(){
        quotesList.add(new Quotes(getString(R.string.QuotePP1)));
    }
    //Q
    //R
    //S
    private void setQuotesNameRS() {
        quotesList.add(new Quotes(getString(R.string.QuoteRS1)));
    }
    //T
    //U
    private void setQuotesNameU() {
        quotesList.add(new Quotes(getString(R.string.QuoteU1)));
        quotesList.add(new Quotes(getString(R.string.QuoteU2)));
        quotesList.add(new Quotes(getString(R.string.QuoteU3)));
        quotesList.add(new Quotes(getString(R.string.QuoteU4)));
        quotesList.add(new Quotes(getString(R.string.QuoteU5)));
        quotesList.add(new Quotes(getString(R.string.QuoteU6)));
        quotesList.add(new Quotes(getString(R.string.QuoteU7)));
        quotesList.add(new Quotes(getString(R.string.QuoteU8)));
        quotesList.add(new Quotes(getString(R.string.QuoteU9)));
        quotesList.add(new Quotes(getString(R.string.QuoteU10)));
        quotesList.add(new Quotes(getString(R.string.QuoteU11)));
        quotesList.add(new Quotes(getString(R.string.QuoteU12)));
        quotesList.add(new Quotes(getString(R.string.QuoteU13)));
        quotesList.add(new Quotes(getString(R.string.QuoteU14)));
        quotesList.add(new Quotes(getString(R.string.QuoteU15)));
        quotesList.add(new Quotes(getString(R.string.QuoteU16)));
        quotesList.add(new Quotes(getString(R.string.QuoteU17)));
        quotesList.add(new Quotes(getString(R.string.QuoteU18)));
        quotesList.add(new Quotes(getString(R.string.QuoteU19)));
        quotesList.add(new Quotes(getString(R.string.QuoteU20)));
        quotesList.add(new Quotes(getString(R.string.QuoteU21)));
        quotesList.add(new Quotes(getString(R.string.QuoteU22)));
    }
    //V
    //W
    private void setQuotesNameWP() {
        quotesList.add(new Quotes(getString(R.string.QuoteWP1)));
        quotesList.add(new Quotes(getString(R.string.QuoteWP2)));
    }
    private void setQuotesNameWS() {
        quotesList.add(new Quotes(getString(R.string.QuoteWS1)));
        quotesList.add(new Quotes(getString(R.string.QuoteWS2)));
    }
    //X
    //Y
    //Z

    //Adapter
    private void setAdapterq() {
        QuotesAdapter adapterq = new QuotesAdapter(this, quotesList);
        RecyclerView.LayoutManager layoutManagerq = new LinearLayoutManager(getApplicationContext());
        recyclerViewq.setLayoutManager(layoutManagerq);
        recyclerViewq.setAdapter(adapterq);
        recyclerViewq.addItemDecoration(new ItemDecorationq(this));
        recyclerViewq.setItemAnimator(null);
        recyclerViewq.seslSetFillBottomEnabled(true);
        recyclerViewq.seslSetLastRoundedCorner(true);
    }
    //Item Decoration, code by Yanndroid
    private static class ItemDecorationq extends RecyclerView.ItemDecoration {
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


//TODO: set quotesName Texts as Strings and add translation

//TODO: Add a about App page





// TODO: learn how you can save an instance with sharedPreferences or database and take the time you need