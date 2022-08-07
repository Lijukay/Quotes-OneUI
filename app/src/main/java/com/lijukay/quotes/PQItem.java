package com.lijukay.quotes;

public class PQItem {
    private final String authorPQ;
    private final String quotePQ;

    public PQItem(String authorPQ, String quotePQ) {
        this.authorPQ = authorPQ;
        this.quotePQ = quotePQ;
    }

    public String getAuthorPQ() {
        return authorPQ;
    }

    public String getQuotePQ() {
        return quotePQ;
    }
}