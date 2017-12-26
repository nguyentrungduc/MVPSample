package com.example.sony.mvpsample.screen;

import com.example.sony.mvpsample.data.model.Movie;

import java.util.List;

/**
 * Created by Sony on 12/22/2017.
 */

public interface MainContract {
    interface View {

        void onGetMoviceSuccess(List<Movie> movies);

    }

    /**
     * Presenter
     */
    interface Presenter extends BasePresenter<View> {

        void loadData();
    }
}
