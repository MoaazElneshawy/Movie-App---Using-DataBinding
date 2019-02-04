package com.moaazfathyelneshawy.moviesusingdatabinding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class MovieRecyclerBindingAdapter {
    @BindingAdapter("recycler_movies_adapter")
    public static void main(RecyclerView recyclerView, List<MovieModel> movieModels) {
        if (movieModels == null) return;
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            layoutManager = new GridLayoutManager(recyclerView.getContext(), 2);
            recyclerView.setLayoutManager(layoutManager);
        }

        MoviesAdapter adapter = (MoviesAdapter) recyclerView.getAdapter();
        if (adapter == null) {
            adapter = new MoviesAdapter(recyclerView.getContext(), movieModels);
            recyclerView.setAdapter(adapter);

        }
    }

}
