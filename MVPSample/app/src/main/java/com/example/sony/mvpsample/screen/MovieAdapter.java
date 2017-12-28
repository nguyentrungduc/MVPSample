package com.example.sony.mvpsample.screen;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sony.mvpsample.R;
import com.example.sony.mvpsample.data.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ADMIN on 12/27/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    List<Movie> movieList = new ArrayList<>();
    private static final String TAG = MovieAdapter.class.toString();
    Context context;


    public MovieAdapter(Context context, List<Movie> movieList){
        this.movieList = movieList;
        this.context = context;
        Log.d(TAG, "contrustor adapter");
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.item_view_movie, parent, false);
        return  new MovieViewHolder(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MovieViewHolder movieViewHolder = (MovieViewHolder) holder;
        Picasso.with(context).load("https://image.tmdb.org/t/p/w300_and_h450_bestv2/" + movieList.get(position).getBackdropPath()).into(movieViewHolder.imageView);
        Picasso.with(context).load("https://image.tmdb.org/t/p/w300_and_h450_bestv2/" + movieList.get(position).getBackdropPath()).into(movieViewHolder.imageViewBackGround);
        movieViewHolder.textViewNameMovie.setText(movieList.get(position).getTitle());


    }


    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public class MovieViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textViewNameMovie;
        ImageView imageViewBackGround;
        public MovieViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imv_posterMovie);
            textViewNameMovie = (TextView) itemView.findViewById(R.id.tv_nameMovie);
            imageViewBackGround = (ImageView) itemView.findViewById(R.id.imv_background);
        }
    }
}
