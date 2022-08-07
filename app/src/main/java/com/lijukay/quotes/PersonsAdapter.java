package com.lijukay.quotes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PersonsAdapter extends RecyclerView.Adapter<PersonsAdapter.PViewHolder> {
    private final Context mContextP;
    private final ArrayList<PersonsItem> mPItem;
    public RecyclerViewClickListener listener2;

    public PersonsAdapter (Context contextP, ArrayList<PersonsItem> PList, RecyclerViewClickListener listener){
        mContextP = contextP;
        mPItem = PList;
        listener2 = listener;

    }

    @NonNull
    @Override
    public PViewHolder onCreateViewHolder(@NonNull ViewGroup parentP, int viewTypeP) {
        View vP = LayoutInflater.from(mContextP).inflate(R.layout.persons_item, parentP, false);
        return new PViewHolder(vP);
    }

    @Override
    public void onBindViewHolder(@NonNull PViewHolder holderP, int positionP) {
        PersonsItem currentItemP = mPItem.get(positionP);

        String PAuthor = currentItemP.getAuthorP();
        holderP.mAuthorP.setText(PAuthor);
    }

    @Override
    public int getItemCount() {
        return mPItem.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public class PViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView mAuthorP;


        public PViewHolder(@NonNull View itemViewP) {
            super(itemViewP);
            mAuthorP = itemViewP.findViewById(R.id.person);
            itemViewP.setOnClickListener(this);
        }
        @Override
        public void onClick(View viewP) {
            listener2.onClick(viewP, getAdapterPosition());
        }
    }
}