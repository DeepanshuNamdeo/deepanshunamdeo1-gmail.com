package com.android.moviedataapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MyViewHolder> {
    private ArrayList<MovieDataProvider> movieDetail;

    private Context context;
    MovieAdapter(Context context, ArrayList<MovieDataProvider> movieDetail) {
        this.context = context;
        this.movieDetail = movieDetail;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card_view, parent, false);
        // set the view's size, margins, paddings and layout parameters
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // set the data in items
        MovieDataProvider movieItem = movieDetail.get(position) ;
        holder.name.setText(movieItem.getMovieName());

        holder.image.setImageResource(movieItem.getMovieImagePath());
        // implement setOnClickListener event on item view.
      /*  holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // open another activity on item click
                Intent intent = new Intent(context, SecondActivity.class);
                intent.putExtra("image", personImages.get(position)); // put image data in Intent
                context.startActivity(intent); // start Intent
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return movieDetail.size();
    }
    static class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        TextView name;
        ImageView image;

        MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            name = (TextView) itemView.findViewById(R.id.textView_movie_name);
            image = (ImageView) itemView.findViewById(R.id.imageView_movie_image);
        }
    }
}
