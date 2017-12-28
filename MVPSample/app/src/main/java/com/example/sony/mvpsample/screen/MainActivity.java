package com.example.sony.mvpsample.screen;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;


import com.example.sony.mvpsample.R;

import com.example.sony.mvpsample.data.model.Movie;
import com.example.sony.mvpsample.data.source.MovieRepositoryimpl;
import com.example.sony.mvpsample.data.source.remote.MovieServiceClient;
import com.example.sony.mvpsample.data.source.remote.RemoteDataSoure;


import java.util.List;


public class MainActivity extends AppCompatActivity implements MainContract.View{

    RecyclerView recyclerView;
    MainPresenter mainPresenter;


    public static final String TAG = MainActivity.class.toString();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rcv);
        MovieRepositoryimpl movieRepositoryimpl = new MovieRepositoryimpl(null,
                new RemoteDataSoure(MovieServiceClient.getInstance()));
        mainPresenter = new MainPresenter(movieRepositoryimpl);
        mainPresenter.setView(this);
        mainPresenter.loadData();
    }

    @Override
    public void onGetMoviceSuccess(List<Movie> movies) {
        Log.d(TAG, "mainactivity: " + movies.toString());
        MovieAdapter movieAdapter = new MovieAdapter(this, movies);

        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
        recyclerView.setAdapter(movieAdapter);
    }

}
