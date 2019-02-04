package com.moaazfathyelneshawy.moviesusingdatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.Toast;

import com.moaazfathyelneshawy.moviesusingdatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements OnMovieClickListener {

    ActivityMainBinding mainBinding;
    static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        MoviesListFragment fragment = new MoviesListFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_fragment_container, fragment, getString(R.string.frag_movies))
                .commit();
    }

    @Override
    public void onMovieClicked(MovieModel model) {
        MovieDetailsFragment detailsFragment = new MovieDetailsFragment();
        detailsFragment.setArguments(model);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_fragment_container, detailsFragment, getString(R.string.frag_movie_details))
                .addToBackStack(getString(R.string.frag_movies))
                .commit();
    }

    @Override
    public void onAddToFavorite(MovieModel model) {
        Toast.makeText(this, model.getTitle(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onShowAddToFavDialog(MovieModel model) {
        Log.e(TAG, "onShowAddToFavDialog from " + TAG);
        AddToFavoriteDialog dialog = new AddToFavoriteDialog();
        dialog.setArguments(model);
        dialog.show(getSupportFragmentManager(), "tag");
    }
}
