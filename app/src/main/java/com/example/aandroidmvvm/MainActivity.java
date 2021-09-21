package com.example.aandroidmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.example.aandroidmvvm.model.MovieModel;
import com.example.aandroidmvvm.adapter.MovieListAdapter;
import com.example.aandroidmvvm.viewmodel.MovieListViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MovieListAdapter movieListAdapter;
    Context ctx= MainActivity.this;
    private List<MovieModel> movieModels;
    MovieListViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        movieListAdapter = new MovieListAdapter(ctx, movieModels);

        LinearLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(movieListAdapter);


        viewModel = ViewModelProviders.of(this).get(MovieListViewModel.class);
        viewModel.getMoviesList().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                if(movieModels !=null){
                    movieModels = movieModels;
                    movieListAdapter.setMovieModelList(movieModels);
                }
                else{
                    Toast.makeText(ctx, "No Result Found!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        viewModel.makeApiCall();

    }
}