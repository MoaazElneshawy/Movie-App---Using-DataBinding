package com.moaazfathyelneshawy.moviesusingdatabinding;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.moaazfathyelneshawy.moviesusingdatabinding.databinding.DialogAddMovieFoFavoritesBinding;

public class AddToFavoriteDialog extends DialogFragment {

    MovieModel movieModel;

    void setArguments(MovieModel movieModel) {
        this.movieModel = movieModel;
    }

    DialogAddMovieFoFavoritesBinding binding;
    OnMovieClickListener onMovieClickListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DialogAddMovieFoFavoritesBinding.inflate(inflater);
        binding.setMovie(movieModel);
        onMovieClickListener = (OnMovieClickListener) getActivity();
        binding.setOnActionListener(onMovieClickListener);
        getDialog().getWindow().setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.FILL_PARENT);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

        binding.addToFavBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
                onMovieClickListener.onAddToFavorite(movieModel);
            }
        });
        binding.addToFavBtnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        return binding.getRoot();
    }

    private void OnAddToFavorite(MovieModel model) {
    }
}
