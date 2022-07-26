package com.lijukay.quotes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.util.SeslRoundedCorner;
import androidx.appcompat.util.SeslSubheaderRoundedCorner;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dev.oneuiproject.oneui.widget.Separator;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    private ArrayList<Persons> personsList;


    public RecyclerAdapter(Context context, ArrayList <Persons> list){
        this.mContext = context;
        this.personsList = list; //or whatever you had before
    }
    @Override
    public int getItemCount() {
        return personsList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return (personsList.get(position).isSeparator) ? 1 : 0;
    }
    private Context mContext;



    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            View view = inflater.inflate(R.layout.list_item, parent, false);
            return new RecyclerAdapter.ViewHolder(view, false);
        } else {
            return new RecyclerAdapter.ViewHolder(new Separator(mContext), true);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, final int position) {
        if (holder.isSeparator) {
            holder.textView.setLayoutParams(new RecyclerView.LayoutParams(RecyclerView.LayoutParams.MATCH_PARENT, RecyclerView.LayoutParams.WRAP_CONTENT));
        }
        holder.textView.setText(personsList.get(position).getPersonsName()); //get name of person / the text
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        boolean isSeparator;
        TextView textView;

        ViewHolder(View itemView, boolean isSeparator) {
            super(itemView);
            this.isSeparator = isSeparator;
            if (isSeparator) {
                textView = (TextView) itemView;
            } else {
                textView = itemView.findViewById(R.id.persons);
            }
        }
    }
}

