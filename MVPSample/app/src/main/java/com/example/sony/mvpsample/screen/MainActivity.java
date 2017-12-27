package com.example.sony.mvpsample.screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;

import com.example.sony.mvpsample.R;

import com.example.sony.mvpsample.data.model.Movie;
import com.example.sony.mvpsample.data.source.MovieRepositoryimpl;
import com.example.sony.mvpsample.data.source.remote.MovieServiceClient;
import com.example.sony.mvpsample.data.source.remote.RemoteDataSoure;
import com.example.sony.mvpsample.util.Constant;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import rx.Scheduler;
import rx.Subscriber;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements MainContract.View{

    RecyclerView recyclerView;
    Button button;
    MainPresenter mainPresenter;
    public static final String TAG = MainActivity.class.toString();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn);
        recyclerView = (RecyclerView) findViewById(R.id.rcv);
        MovieRepositoryimpl movieRepositoryimpl = new MovieRepositoryimpl(null,
                new RemoteDataSoure(MovieServiceClient.getInstance()));
        mainPresenter = new MainPresenter(movieRepositoryimpl);
        mainPresenter.setView(this);
        mainPresenter.loadData();





    }

    @Override
    public void onGetMoviceSuccess(List<Movie> movies) {
        MovieAdapter movieAdapter = new MovieAdapter(getApplicationContext(), movies);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(movieAdapter);
    }

}
