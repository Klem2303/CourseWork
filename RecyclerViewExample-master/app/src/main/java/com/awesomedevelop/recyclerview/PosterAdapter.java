package com.awesomedevelop.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PosterAdapter extends RecyclerView.Adapter<PosterAdapter.MyViewHolder> {
    private ArrayList<PosterData> posters;
    public Context mContext;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imagePoster;
        public MyViewHolder(View itemView){
            super (itemView);
            this.imagePoster = (ImageView)itemView.findViewById(R.id.image);
        }
    }
    public PosterAdapter(Context context, ArrayList<PosterData> posters){
        this.posters = posters;
        mContext=context;
    }
    public void swap(ArrayList<PosterData> list){
        this.posters = list;
        if (posters != null) {
            posters.clear();
            posters.addAll(list);
        }
        else {
            posters = list;
        }
        notifyDataSetChanged();
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.poster_card, parent, false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        ImageView imageViewPoster = holder.imagePoster;
        String src = posters.get(listPosition).getImage();
        Picasso.with(mContext)
                .load("http://posterkeeper.xyz/" + src)
                .resize(700, 980)
                .into(imageViewPoster);
    }
    @Override
    public int getItemCount() {
        return posters.size();
    }
}