package com.example.sony.mvpsample.data.source.remote;

import android.app.Application;
import android.support.annotation.NonNull;


import com.google.gson.Gson;

import okhttp3.Interceptor;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Sony on 12/22/2017.
 */

public class ServerClient {



    static <T> T createService(Application application, String endPoint, Class<T> serviceClass) {


            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(endPoint)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofit.create(serviceClass);
    }


}
