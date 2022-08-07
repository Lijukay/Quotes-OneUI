package com.lijukay.quotes;


public class ECItems {
    private final String author;
    private final String quote;

    public ECItems(String author, String quote) {
        this.author = author;
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public String getQuote() {
        return quote;
    }
}
