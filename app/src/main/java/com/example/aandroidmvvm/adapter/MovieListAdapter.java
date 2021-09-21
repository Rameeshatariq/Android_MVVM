package com.example.aandroidmvvm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.aandroidmvvm.R;
import com.example.aandroidmvvm.model.MovieModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {
    private Context ctx;
    private List<MovieModel> movieModelList;

    public MovieListAdapter(Context ctx, List<MovieModel> movieModelList){
        this.ctx = ctx;
        this.movieModelList = movieModelList;
    }

    public void setMovieModelList(List<MovieModel> movieModelList){
        this.movieModelList = movieModelList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.recyler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MyViewHolder holder, int position) {

        holder.tv_title.setText(this.movieModelList.get(position).getTitle());
        Glide.with(ctx).load(this.movieModelList.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        if(this.movieModelList != null){
            return this.movieModelList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tv_title= itemView.findViewById(R.id.tv_title);
        ImageView  image= itemView.findViewById(R.id.imageView);
        public MyViewHolder(View itemView){
            super(itemView);


        }
    }
}
