package com.moaazfathyelneshawy.moviesusingdatabinding;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.moaazfathyelneshawy.moviesusingdatabinding.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

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
}
