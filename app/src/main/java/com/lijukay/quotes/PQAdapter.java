package com.lijukay.quotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PQAdapter extends RecyclerView.Adapter<PQAdapter.PQViewHolder> {
    private final Context mContextPQ;
    private final ArrayList<PQItem> mPQItem;

    public PQAdapter (Context contextPQ, ArrayList<PQItem> pQList){
        mContextPQ = contextPQ;
        mPQItem = pQList;

    }

    @NonNull
    @Override
    public PQViewHolder onCreateViewHolder(@NonNull ViewGroup parentPQ, int viewTypePQ) {
        View vPQ = LayoutInflater.from(mContextPQ).inflate(R.layout.pquotes_item, parentPQ, false);
        return new PQViewHolder(vPQ);
    }

    @Override
    public void onBindViewHolder(@NonNull PQViewHolder holderPQ, int positionPQ) {
        PQItem currentItemPQ = mPQItem.get(positionPQ);

        String PQQuote = currentItemPQ.getQuotePQ();
        String PQAuthor = currentItemPQ.getAuthorPQ();

        holderPQ.mQuotePQ.setText(PQQuote);
        holderPQ.mAuthorPQ.setText(PQAuthor);
    }

    @Override
    public int getItemCount() {
        return mPQItem.size();
    }

    public static class PQViewHolder extends RecyclerView.ViewHolder{
        public TextView mQuotePQ;
        public TextView mAuthorPQ;


        public PQViewHolder(@NonNull View itemViewPQ) {
            super(itemViewPQ);
            mQuotePQ = itemViewPQ.findViewById(R.id.quoteP);
            mAuthorPQ = itemViewPQ.findViewById(R.id.authorP);

        }
    }
}
