package com.example.demo.domain;

import com.example.demo.GlobalConstants;

import lombok.Getter;

public class MovieRecord {

    @Getter
    private String posterLink;
    @Getter
    private String seriesTitle;
    @Getter
    private int releasedYear;
    @Getter
    private String certificate;
    @Getter
    private String runtime;
    @Getter
    private String genre;
    @Getter
    private double imdbRating;
    @Getter
    private String overview;
    @Getter
    private int metaScore;
    @Getter
    private String director;
    @Getter
    private String star1;
    @Getter
    private String star2;
    @Getter
    private String star3;
    @Getter
    private String star4;
    @Getter
    private int noOfVotes;
    @Getter
    private String gross;

    public MovieRecord (String[] movieStrings) {
        this.posterLink = movieStrings[GlobalConstants.Poster_Link];
        this.seriesTitle = movieStrings[GlobalConstants.Series_Title];
        this.releasedYear = Integer.parseInt(movieStrings[GlobalConstants.Released_Year]);
        this.certificate = movieStrings[GlobalConstants.Certificate];
        this.runtime = movieStrings[GlobalConstants.Runtime];
        this.genre = movieStrings[GlobalConstants.Genre];
        this.imdbRating = Double.parseDouble(movieStrings[GlobalConstants.IMDB_Rating]);
        this.overview = movieStrings[GlobalConstants.Overview];
        this.metaScore = Integer.parseInt(movieStrings[GlobalConstants.Meta_score]);
        this.director = movieStrings[GlobalConstants.Director];
        this.star1 = movieStrings[GlobalConstants.Star1];
        this.star2 = movieStrings[GlobalConstants.Star2];
        this.star3 = movieStrings[GlobalConstants.Star3];
        this.star4 = movieStrings[GlobalConstants.Star4];
        this.noOfVotes = Integer.parseInt(movieStrings[GlobalConstants.No_of_Votes]);
        this.gross = movieStrings[GlobalConstants.Gross];
    }
}