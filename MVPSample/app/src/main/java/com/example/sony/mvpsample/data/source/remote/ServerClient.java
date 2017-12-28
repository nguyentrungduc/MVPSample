package com.example.sony.mvpsample.data.source.remote;

import android.app.Application;
import android.support.annotation.NonNull;


import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.realm.RealmObject;
import okhttp3.Interceptor;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
/**
 * Created by Sony on 12/22/2017.
 */

public class ServerClient {



    static <T> T createService(Application application, String endPoint, Class<T> serviceClass) {


        ExclusionStrategy exclusionStrategy = new ExclusionStrategy() {
            @Override
            public boolean shouldSkipField(FieldAttributes f) {
                return f.getDeclaringClass().equals(RealmObject.class);
            }

            @Override
            public boolean shouldSkipClass(Class<?> clazz) {
                return false;
            }
        };

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(endPoint)
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofit.create(serviceClass);
    }


}
