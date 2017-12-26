package com.example.sony.mvpsample.screen;

/**
 * Created by Sony on 12/22/2017.
 */

public interface BasePresenter<T> {

    void setView(T view);

    void onStart();

    void onStop();
}
