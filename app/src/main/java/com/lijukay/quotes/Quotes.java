package com.lijukay.quotes;

public class Quotes {
    private String quotesName;
    public boolean isSeparatorq;
    //public int color; <-- will be added when i know how to use it

    public String getQuotesName() {
        return quotesName;
    }

    public void setQuotesName(String quotesName/*, int color*/) {
        this.quotesName = quotesName;
        //this.color = color; <-- will be added when i know how to use it
    }

    public Quotes(String quotesName) {
        this(quotesName, false);
    }

    public Quotes(String quotesName, boolean isSeparatorq) {
        this.quotesName = quotesName;
        this.isSeparatorq = isSeparatorq;
    }
}

//TODO: learn about setters/getters and constructors, maybe try this again: https://youtu.be/fis26HvvDII
//TODO: Also have a look on Android Studio website: https://developer.android.com/docs?hl=de
//TODO: Add the possibility to set the Text color of a single object in the RecyclerView