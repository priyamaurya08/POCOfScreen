package com.example.priyamaurya.pocofscreen.Adpater;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.priyamaurya.pocofscreen.R;

/**
 * Created by Priya Maurya on 1/7/2018.
 */

public class CardRecyclerViewAdpater  extends RecyclerView.Adapter<CardRecyclerViewAdpater.MyViewHolder>{

    View view;

    @Override
    public CardRecyclerViewAdpater.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        MyViewHolder myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(CardRecyclerViewAdpater.MyViewHolder holder, int position) {


    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public MyViewHolder(View itemView) {

            super(itemView);
        }
    }
}
