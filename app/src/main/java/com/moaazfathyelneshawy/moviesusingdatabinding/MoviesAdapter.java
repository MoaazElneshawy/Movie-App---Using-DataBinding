package com.moaazfathyelneshawy.moviesusingdatabinding;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moaazfathyelneshawy.moviesusingdatabinding.databinding.MovieItemBinding;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.ViewHolder> {

    Context context;
    List<MovieModel> models;
    OnMovieClickListener onMovieClickListener;

    public MoviesAdapter(Context context, List<MovieModel> models) {
        this.context = context;
        this.models = models;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        MovieItemBinding binding =
                MovieItemBinding.inflate(LayoutInflater.from(context), viewGroup, false);
        return new ViewHolder(binding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        MovieModel model = models.get(i);
        viewHolder.itemBinding.setMovie(model);
        viewHolder.itemBinding.setOnMovie((OnMovieClickListener) context);
        viewHolder.itemBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        MovieItemBinding itemBinding;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemBinding = DataBindingUtil.bind(itemView);
        }
    }
}
