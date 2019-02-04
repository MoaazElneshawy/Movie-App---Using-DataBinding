package com.moaazfathyelneshawy.moviesusingdatabinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

public class MovieViewModel extends BaseObservable {

    private MovieModel movieModel;
    private boolean isLoaded = false;


    public void setMovieModel(MovieModel movieModel) {
        this.movieModel = movieModel;
        notifyPropertyChanged(BR.movieModel);
    }

    public void setLoaded(boolean loaded) {
        isLoaded = loaded;
        notifyPropertyChanged(BR.loaded);
    }

    @Bindable
    public MovieModel getMovieModel() {
        return movieModel;
    }

    @Bindable
    public boolean isLoaded() {
        return isLoaded;
    }

}
