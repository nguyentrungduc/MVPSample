package com.example.sony.mvpsample.data.source;

/**
 * Created by Sony on 12/22/2017.
 */

public interface BaseLocalDataSource {
    void openTransaction();

    void closeTransaction();

    void openReadTransaction();
}
