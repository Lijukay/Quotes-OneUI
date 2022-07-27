package com.lijukay.quotes;

public class Quotes {
    private String quotesName;
    public boolean isSeparatorq;

    public String getQuotesName() {
        return quotesName;
    }

    public void setQuotesName(String quotesName) {
        this.quotesName = quotesName;
    }

    public Quotes(String quotesName) {
        this(quotesName, false);
    }

    public Quotes(String quotesName, boolean isSeparatorq) {
        this.quotesName = quotesName;
        this.isSeparatorq = isSeparatorq;
    }
}