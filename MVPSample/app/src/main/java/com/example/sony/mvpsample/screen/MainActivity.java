package com.example.sony.mvpsample.screen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.example.sony.mvpsample.R;

import com.example.sony.mvpsample.data.source.MovieRepositoryimpl;
import com.example.sony.mvpsample.data.source.remote.MovieServiceClient;
import com.example.sony.mvpsample.data.source.remote.RemoteDataSoure;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Button button;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.btn);
        recyclerView = (RecyclerView) findViewById(R.id.rcv);
        MovieRepositoryimpl movieRepositoryimpl = new MovieRepositoryimpl(null,
                new RemoteDataSoure(MovieServiceClient.getInstance()));
        MainPresenter mainPresenter = new MainPresenter(movieRepositoryimpl);


    }
}
