package com.moaazfathyelneshawy.moviesusingdatabinding;

public interface OnMovieClickListener {
    void onMovieClicked(MovieModel model);
    void onAddToFavorite(MovieModel model);
    void onShowAddToFavDialog(MovieModel model);
}
