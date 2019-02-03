package com.moaazfathyelneshawy.moviesusingdatabinding;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moaazfathyelneshawy.moviesusingdatabinding.databinding.FragmentMovieDetailsBinding;

public class MovieDetailsFragment extends Fragment {

    FragmentMovieDetailsBinding binding;
    MovieModel movieModel;

    public void setArguments(MovieModel movieModel) {
        this.movieModel = movieModel;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMovieDetailsBinding.inflate(inflater);
        binding.setMovie(movieModel);
        return binding.getRoot();
    }
}
