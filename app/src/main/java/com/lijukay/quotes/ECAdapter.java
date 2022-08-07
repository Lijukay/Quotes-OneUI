package com.lijukay.quotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ECAdapter extends RecyclerView.Adapter<ECAdapter.ECViewHolder> {
    private final Context mContext;
    private final ArrayList<ECItems> mECItem;

    public ECAdapter (Context context, ArrayList<ECItems> ecList){
        mContext = context;
        mECItem = ecList;

    }

    @NonNull
    @Override
    public ECViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.editor_choice, parent, false);
        return new ECViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ECViewHolder holder, int position) {
        ECItems currentItem = mECItem.get(position);

        String ecQuote = currentItem.getQuote();
        String ecAuthor = currentItem.getAuthor();

        holder.mQuote.setText(ecQuote);
        holder.mAuthor.setText(ecAuthor);
    }

    @Override
    public int getItemCount() {
        return mECItem.size();
    }

    public static class ECViewHolder extends RecyclerView.ViewHolder{
        public TextView mQuote;
        public TextView mAuthor;


        public ECViewHolder(@NonNull View itemView) {
            super(itemView);
            mQuote = itemView.findViewById(R.id.quote);
            mAuthor = itemView.findViewById(R.id.author);

        }
    }
}
