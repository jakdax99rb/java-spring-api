package com.example.demo.datafetchers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.demo.domain.MovieRecord;
import com.example.demo.Transformers.MovieTransformer;
import com.example.demo.generated.types.Movie;
import com.example.demo.services.MovieService;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;

import reactor.core.publisher.Flux;

@DgsComponent
public class MovieDataFetcher {

    private MovieService movieService;

    public MovieDataFetcher(MovieService movieService) {
        this.movieService = movieService;
    }

    @DgsQuery
    public Flux<Movie> movies(
            @InputArgument Optional<String> director,
            @InputArgument Optional<String> actor,
            @InputArgument Optional<String> title) {

        List<MovieRecord> movieRecords = movieService.getListOfMovieRecords();
        ArrayList<Movie> movieList = new ArrayList<Movie>();

        movieRecords.forEach((record) -> {
            movieList.add(transform(record));
        });

        return Flux.fromIterable(movieList);
    }


    @DgsQuery
    public Flux<Movie> movies(@InputArgument int amount) {

        List<MovieRecord> movieRecords = movieService.getListOfMovieRecords();
        ArrayList<Movie> movieList = new ArrayList<Movie>();

        for (int i = 0; i <= amount; i++) {
            movieList.add(transform(movieRecords.get(i)));
        }

        return Flux.fromIterable(movieList);
    }


    @DgsQuery
    public String test() {
        return "test";
    }

    private Movie transform(MovieRecord movieRecord) {
        return MovieTransformer.transform(movieRecord);
    }

}
