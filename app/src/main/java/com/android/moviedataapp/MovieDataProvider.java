package com.android.moviedataapp;

public class MovieDataProvider {

    private String movieName;
    private int movieImagePath;
    private int movieGenre;

    public MovieDataProvider(String movieName, int movieImagePath, int movieGenre) {
        this.movieName = movieName;
        this.movieImagePath = movieImagePath;
        this.movieGenre = movieGenre;
    }

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(int movieGenre) {
        this.movieGenre = movieGenre;
    }

    public int getMovieImagePath() {
        return movieImagePath;
    }

    public void setMovieImagePath(int movieImagePath) {
        this.movieImagePath = movieImagePath;
    }

    @Override
    public String toString() {
        return "QuestionDataProvider{" +
                "movieName='" + movieName + '\'' +
                ", movieGenre='" + movieGenre + '\'' +
                ", movieImagePath='" + movieImagePath + '\'' +
                '}';
    }
}
