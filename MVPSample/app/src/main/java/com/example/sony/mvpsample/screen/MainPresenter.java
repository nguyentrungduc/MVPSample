package com.example.sony.mvpsample.screen;

import android.util.Log;

import com.example.sony.mvpsample.data.model.Movie;
import com.example.sony.mvpsample.data.source.MovieRepository;
import com.example.sony.mvpsample.data.source.MovieRepositoryimpl;
import com.example.sony.mvpsample.data.source.remote.MovieServiceClient;
import com.example.sony.mvpsample.data.source.remote.RemoteDataSoure;
import com.example.sony.mvpsample.util.Constant;

import java.util.List;

import io.reactivex.annotations.NonNull;
import rx.Subscriber;
import rx.schedulers.Schedulers;

/**
 * Created by Sony on 12/22/2017.
 */

public class MainPresenter implements MainContract.Presenter{

    private MovieRepository movieRepository;
    private MainContract.View mview;
    public final String TAG = MainPresenter.class.toString();

    public MainPresenter(@NonNull MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public void setView(MainContract.View view) {
            mview = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }


    @Override
    public void loadData() {
        MovieRepositoryimpl movieRepositoryimpl = new MovieRepositoryimpl(null,
                new RemoteDataSoure(MovieServiceClient.getInstance()));

        movieRepositoryimpl.searchPopularMovie(Constant.API_KEY_V3, Constant.LANGUAGE, "1").subscribeOn(Schedulers.io())
                .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Movie>>() {
                    @Override
                    public void onCompleted() {
                        Log.d(TAG ,"omCompleted");


                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d(TAG, e.toString());

                    }

                    @Override
                    public void onNext(List<Movie> movies) {

                        Log.d(TAG, "onNext");
                        mview.onGetMoviceSuccess(movies);
                        Log.d(TAG,movies.toString()+"jojo");


                    }
                });


    }
}
