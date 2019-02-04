package com.moaazfathyelneshawy.moviesusingdatabinding;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moaazfathyelneshawy.moviesusingdatabinding.databinding.FragmentMovieDetailsBinding;

public class MovieDetailsFragment extends Fragment {
    static final String TAG = MovieDetailsFragment.class.getSimpleName();
    FragmentMovieDetailsBinding binding;
    MovieModel movieModel;

    public void setArguments(MovieModel movieModel) {
        this.movieModel = movieModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMovieDetailsBinding.inflate(inflater);
        MovieViewModel model = new MovieViewModel();
        model.setMovieModel(movieModel);
        binding.setMovieViewModel(model);
        binding.setOnAddClick((OnMovieClickListener) getActivity());
        return binding.getRoot();
    }


}
