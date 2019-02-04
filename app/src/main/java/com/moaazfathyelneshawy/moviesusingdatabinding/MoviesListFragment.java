package com.moaazfathyelneshawy.moviesusingdatabinding;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.moaazfathyelneshawy.moviesusingdatabinding.databinding.FragmentMoviesListBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MoviesListFragment extends Fragment {

    FragmentMoviesListBinding binding;
    List<MovieModel> movies;
    RequestQueue queue;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        queue = Volley.newRequestQueue(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentMoviesListBinding.inflate(inflater);
        binding.fragRefresh.setRefreshing(true);
        movies = new ArrayList<>();
        requestMovies("http://api.themoviedb.org/3/movie/popular?api_key=aefc2ec42abab63002f7ffeb604c33a1");
        binding.fragRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                requestMovies("http://api.themoviedb.org/3/movie/popular?api_key=aefc2ec42abab63002f7ffeb604c33a1");
            }
        });
        return binding.getRoot();
    }

    private void requestMovies(String order) {

        JsonObjectRequest request = new JsonObjectRequest(order, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                binding.fragRefresh.setRefreshing(false);
                if (response != null) {
                    MovieViewModel model = new MovieViewModel();
                    model.setLoaded(true);
                    binding.setMovieViewModel(model);
                    jsonFormat(response);
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                binding.fragRefresh.setRefreshing(false);
            }
        });

        queue.add(request);

    }

    private void jsonFormat(JSONObject response) {
        if (movies.size() > 0) movies.clear();
        try {
            JSONArray results = response.getJSONArray("results");
            for (int i = 0; i < results.length(); i++) {
                JSONObject movieObject = results.getJSONObject(i);
                MovieModel model = new MovieModel();
                model.setOverview(movieObject.getString("overview"));
                model.setTitle(movieObject.getString("title"));
                double vote = movieObject.getDouble("vote_average");
                model.setVote_average((float) vote);
                model.setDate(movieObject.getString("release_date"));
                model.setPoster_path("http://image.tmdb.org/t/p/w500/" + movieObject.getString("poster_path"));
                movies.add(model);

            }
            binding.setMovies(movies);
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

}
