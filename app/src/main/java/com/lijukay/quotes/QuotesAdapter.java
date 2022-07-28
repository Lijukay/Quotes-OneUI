package com.lijukay.quotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import dev.oneuiproject.oneui.widget.Separator;

//Code is a changed copy of RecyclerAdapter.java
public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QViewHolder> {
    private ArrayList<Quotes> quotesList;


    public QuotesAdapter(Context contextq, ArrayList <Quotes> listq){
        this.mContextq = contextq;
        this.quotesList = listq;
    }



    @Override
    public int getItemCount() {
        return quotesList.size();
    }



    @Override
    public int getItemViewType(int positionq) {
        return (quotesList.get(positionq).isSeparatorq) ? 1 : 0;
    }
    private Context mContextq;



    @NonNull
    @Override
    public QuotesAdapter.QViewHolder onCreateViewHolder(@NonNull ViewGroup parentq, int viewTypeq) {
        if (viewTypeq == 0) {
            LayoutInflater inflaterq = LayoutInflater.from(mContextq);
            View viewq = inflaterq.inflate(R.layout.quote_item, parentq, false);
            return new QViewHolder(viewq, false);
        } else {
            return new QViewHolder(new Separator(mContextq), true);
        }
    }

    @Override
    public void onBindViewHolder(QuotesAdapter.QViewHolder holderq, final int positionq) {
        if (holderq.isSeparatorq) {
            holderq.textViewq.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        }
        holderq.textViewq.setText(quotesList.get(positionq).getQuotesName());
        //quotesList.get(positionq).color; <-- not a statement, maybe try to learn how to use this thing?
    }

    public static class QViewHolder extends RecyclerView.ViewHolder{
        boolean isSeparatorq;
        TextView textViewq;

        QViewHolder(View itemViewq, boolean isSeparatorq) {
            super(itemViewq);
            this.isSeparatorq = isSeparatorq;
            if (isSeparatorq) {
                textViewq = (TextView) itemViewq;
            } else {
                textViewq = itemViewq.findViewById(R.id.quotes);
            }
        }

    }

}

