package com.example.sony.mvpsample.screen;

import com.example.sony.mvpsample.data.source.MovieRepository;

import java.util.List;

/**
 * Created by Sony on 12/22/2017.
 */

public class MainPresenter implements MainContract.Presenter{

    MovieRepository movieRepository;

    public MainPresenter(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void setView(MainContract.View view) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }


    @Override
    public void loadData() {
        movieRepository.getAllMovie();

    }
}
