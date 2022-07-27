package com.lijukay.quotes;


import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.ColorRes;
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
        }

        setAdapterq();
    }



    //A
    private void setQuotesNameAA() {
        quotesList.add(new Quotes("Die Wunden, die du nicht siehst, sind am schwersten zu heilen"));
    }
    //B
    private void setQuotesNameBF() {
        quotesList.add(new Quotes("Manche Leute sterben mit 25, aber werden erst mit 75 beerdigt"));
    }
    private void setQuotesNameBP() {
        quotesList.add(new Quotes("Ein Tropfen Liebe ist mehr als ein Ozean Verstand"));
    }
    private void setQuotesNameBM() {
        quotesList.add(new Quotes("Die guten Zeiten von heute sind die traurigen Gedanken von morgen"));
        quotesList.add(new Quotes("Öffne die Augen, schau nach innen. Bist du zufrieden mit dem Leben, das du lebst"));
        quotesList.add(new Quotes("Der Tag an dem du aufhörst das Rennen mitzumachen, ist der Tag an dem du das Rennen gewinnst"));
        quotesList.add(new Quotes("Liebe das Leben, das du lebst. Lebe das Leben, das du liebst."));
    }
    //C
    private void setQuotesNameCB() {
        quotesList.add(new Quotes("Kannst du dich erinnern wer du warst, bevor dir die Welt gesagt hat, wer du bist?"));
    }
    private void setQuotesNameCC(){
        quotesList.add(new Quotes("Ich bereue nichts im Leben, außer dem, was ich nicht getan habe"));
        quotesList.add(new Quotes("Wenn man ohne Flügel geboren wurde, darf man sie nicht am wachsen hindern."));
    }
    //D
    private void setQuotesNameDP() {
        quotesList.add(new Quotes("Wenn du den Weg auf dem du gehst nicht magst, mach dir einen neuen"));
        quotesList.add(new Quotes("Wenn dir jemand seine wahren Farben zeigt, vertraue ihm"));
    }
    //E
    private void setQuotesNameEH() {
        quotesList.add(new Quotes("Du bist so mutig und ruhig, dass ich vergesse, dass du leidest"));
    }
    //F
    //G
    private void setQuotesNameGA(){
        quotesList.add(new Quotes("Alles was du jemals wolltest ist auf der anderen Seite der Angst"));
    }
    //H
    //I
    //J
     private void setQuotesNameJP() {
        quotesList.add(new Quotes("Vielleicht gibt es schönere Zeiten, aber das hier ist unsere Zeit"));
    }
    private void setQuotesNameJWG(){
        quotesList.add(new Quotes("Es muss vom Herzen kommen, was auf Herzen wirken soll"));
    }
    private void setQuotesNameJW() {
        quotesList.add(new Quotes("Gib deine Träume nicht auf oder deine Träume geben dich auf"));
    }

    private void setQuotesNameJC() {
        quotesList.add(new Quotes("Der Käfig, den du dich nicht traust zu betreten, hat den Schatz, den du suchst"));
    }

    private void setQuotesNameJ() {
        quotesList.add(new Quotes("Schmerz sieht man nicht nur in Tränen, manchmal ist es auch hinter einem Lächeln versteckt"));
        quotesList.add(new Quotes("Viele können dich zum lachen bringe, aber nur wenige können dich glücklich machen"));
    }
    private void setQuotesNameJB(){
        quotesList.add(new Quotes("Manchmal sieht das Herz Dinge, die für das Auge unsichtbar sind"));
    }
    //K
    private void setQuotesNameK(){
        quotesList.add(new Quotes("Es ist nicht von Bedeutung wie langsam du gehst, solange du nicht stehenbleibst"));
    }
    //L
    private void setQuotesNameLT(){
        quotesList.add(new Quotes("Alle wollen die Welt verändern aber keiner sich selbst"));
    }
    private void setQuotesNameLD() {
        quotesList.add(new Quotes("Das Leben ist wie eine Münze, du kannst alles mit ihr kaufen, aber nur einmal"));
    }
    private void setQuotesNameLS() {
        quotesList.add(new Quotes("Den Charakter kann man auch aus den kleinsten Handlungen erkennen"));
    }
    private void setQuotesNameL(){
        quotesList.add(new Quotes("Auch eine Reise von tausend Meilen beginnt mit einem Schritt"));
    }
    //M
    //N
    //O
    //P
    private void setQuotesNamePP(){
        quotesList.add(new Quotes("Alles, was du dir vorstellen kannst ist real"));
    }
    //Q
    //R
    //S
    private void setQuotesNameRS() {
        quotesList.add(new Quotes("Was würdest du tun, wenn du wüsstest, dass nicht scheitern kannst?"));
    }
    //T
    //U
    private void setQuotesNameU() {
        quotesList.add(new Quotes("Mach es oder mach es nicht, du wirst beides bereuen"));
        quotesList.add(new Quotes("Kaputte Menschen haben das schönste Lächeln, weil sie wissen, was Glück bedeutet"));
        quotesList.add(new Quotes("Es sind nicht die Dinge, die uns Angst machen, sondern die Art und weise, wie wir über sie denken"));
        quotesList.add(new Quotes("Das schlimmste Gefühl ist, wenn du zu Hause bist aber"));
        quotesList.add(new Quotes("Manchmal enden schöne Dinge, weil die Leute noch nicht bereit dafür sind"));
        quotesList.add(new Quotes("Wenn du noch nicht bereit dafür wärst, dann hättest du nicht die Möglichkeit dazu."));
        quotesList.add(new Quotes("Die schlimmste Art von Traurigkeit ist die, die du nicht erklären kannst."));
        quotesList.add(new Quotes("Obwohl Gedanken nichts wiegen, kann man unter ihrer Last zusammenbrechen."));
        quotesList.add(new Quotes("Trauer ist nicht das Gegenteil von Glück, es ist ein Teil davon."));
        quotesList.add(new Quotes("Der Tod muss eine schöne Reise sein, denn bis jetzt ist noch keiner zurückgekehrt."));
        quotesList.add(new Quotes("Du verdienst die Liebe, die du die ganze Zeit versuchst anderen zu geben."));
        quotesList.add(new Quotes("Wenn ich an dich denke, dann lächle ich, doch mein Herz tut verdammt weh"));
        quotesList.add(new Quotes("Sein Herz zu verlieren ist die beste Art zu entdecken, dass man eins hat"));
        quotesList.add(new Quotes("Es ist egal, wer vor dir steht, wenn du weißt, wer hinter dir steht."));
        quotesList.add(new Quotes("Manchmal passiert lange Zeit nichts und dann alles auf einmal"));
        quotesList.add(new Quotes("In dem Moment, wo du dich akzeptierst, wirst du schön"));
        quotesList.add(new Quotes("Das Leben wiederholt Dinge so lange, bis du die Lektion gelernt hast"));
        quotesList.add(new Quotes("Woran deine Augen hängen bleiben, zeigt dir wonach deine Seele sucht"));
        quotesList.add(new Quotes("Ich werde mich nie für mein Herz entschuldigen, das so leicht bricht, aber so stark liebt"));
        quotesList.add(new Quotes("Du kannst nicht glücklich werden, wenn das, was du etwas festhälst, das dich traurig macht"));
        quotesList.add(new Quotes("Du kannst mich berühren, ohne mich zu berühren."));
    }
    //V
    //W
    private void setQuotesNameWP() {
        quotesList.add(new Quotes("Wie buchstabiert man Liebe? Du buchstabierst es nicht, du fühlst es."));
        quotesList.add(new Quotes("Manche Leute sorgen sich zu viel um einen, ich denke, man nennt es Liebe."));
    }

    private void setQuotesNameWS() {
        quotesList.add(new Quotes("Die ganze Welt ist eine Bühne und wir alle sind Schauspieler."));
        quotesList.add(new Quotes("Der Kummer,der nicht spricht, nagt am Herzen, bis es bricht."));
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


//TODO: set quotesName Texts as Strings and add translation

//TODO: Add a about App page





// TODO: learn how you can save an instance with sharedPreferences or database and take the time you need