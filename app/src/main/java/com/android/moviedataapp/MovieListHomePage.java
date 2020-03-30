package com.android.moviedataapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class MovieListHomePage extends AppCompatActivity {

    private  ArrayList<MovieDataProvider> movieDetails = null;
    String[] categories={"All","Biography","Crime","Comedy","Horror","Science Fiction","Romance","Thriller"};
    private Spinner spinner_filter;
    MovieAdapter movieAdapter;
    RecyclerView recyclerView_movie_list;
    private ArrayList<MovieDataProvider> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_list_home_page);
        initialiseUI();
        setupUIListeners();


    }

    @Override
    public void onBackPressed() {
    }

    private void initialiseUI() {
        spinner_filter = findViewById(R.id.spinner_filter);
        spinner_filter.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, categories));
        movies = new ArrayList<MovieDataProvider>();
        // get the reference of RecyclerView
        recyclerView_movie_list = (RecyclerView) findViewById(R.id.recyclerView_movie_list);
        // set a StaggeredGridLayoutManager with 3 number of columns and vertical orientation
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL );
        recyclerView_movie_list.setLayoutManager(staggeredGridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        movieDetails = getMovieData();
        movieAdapter = new MovieAdapter(this,movieDetails);
        recyclerView_movie_list.setAdapter(movieAdapter); // set the Adapter to RecyclerView


    }

    private void setupUIListeners() {

        //spinner selection events
        spinner_filter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long itemID) {
                if (position >= 0 && position < categories.length) {
                    getSelectedCategoryData(position);
                    movieAdapter.notifyDataSetChanged();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    private void getSelectedCategoryData(int categoryID) {
        ArrayList<MovieDataProvider> movieItems = new ArrayList<>();
        movieDetails.clear();
        if (categoryID == 0){
            //all
            movieDetails.addAll(getMovieData());
        }else {
            for (MovieDataProvider movieItem : getMovieData()) {
                if (movieItem.getMovieGenre() == categoryID) {
                    movieDetails.add(movieItem);
                }
            }
        }

    }




    public ArrayList<MovieDataProvider> getMovieData() {
        ArrayList<MovieDataProvider> movieDetailsList = new ArrayList<MovieDataProvider>();
        movieDetailsList.add(0,new MovieDataProvider("Lincoln",R.drawable.lincon,Genre.BIOGRAPHY));
        movieDetailsList.add(1,new MovieDataProvider("Anabelle",R.drawable.anabelle,Genre.HORROR));
        movieDetailsList.add(2,new MovieDataProvider("Bruce Lee",R.drawable.bruce_lee,Genre.BIOGRAPHY));
        movieDetailsList.add(3,new MovieDataProvider("Scary Movie",R.drawable.scareymovie,Genre.COMEDY));
        movieDetailsList.add(4,new MovieDataProvider("Its a crime",R.drawable.itsacrime,Genre.CRIME));
        movieDetailsList.add(5,new MovieDataProvider("Interstellar",R.drawable.intesteller,Genre.SCIFI));
        movieDetailsList.add(6,new MovieDataProvider("silence",R.drawable.scilence,Genre.THRILLER));
        movieDetailsList.add(7,new MovieDataProvider("The vow ",R.drawable.thevow,Genre.ROMANCE));
        movieDetailsList.add(0,new MovieDataProvider("Gandhi",R.drawable.gandhi,Genre.BIOGRAPHY));


       return movieDetailsList;
    }

    public static class Genre{
        public static final int BIOGRAPHY = 1;
        public static final int CRIME = 2;
        public static final int COMEDY = 3;
        public static final int HORROR = 4;
        public static final int ROMANCE = 5;
        public static final int SCIFI = 6;
        public static final int THRILLER = 7;
    }


}


