package com.example.demo.Transformers;

import java.util.Arrays;

import com.example.demo.domain.MovieRecord;
import com.example.demo.generated.types.Movie;

public class MovieTransformer {
    public static Movie transform(MovieRecord movieRecord) {
        Movie movie = new Movie();
        movie.setPosterLink(movieRecord.getPosterLink());
        movie.setTitle(movieRecord.getSeriesTitle());
        movie.setReleaseYear(movieRecord.getReleasedYear());
        movie.setCertificate(movieRecord.getCertificate());
        movie.setRuntime(Integer.parseInt(movieRecord.getRuntime().replace(" min", "")));
        movie.setGenre(Arrays.asList(movieRecord.getGenre().split(", ")));
        movie.setImdbRating(movieRecord.getImdbRating());
        movie.setOverview(movieRecord.getOverview());
        movie.setMetaCriticScore(movieRecord.getMetaScore());
        movie.setDirector(movieRecord.getDirector());
        movie.setStars(Arrays.asList(
                new String[] { movieRecord.getStar1(), movieRecord.getStar2(), movieRecord.getStar3(), movieRecord.getStar4() }));
        movie.setVotes(movieRecord.getNoOfVotes());
        movie.setGross(Integer.parseInt(movieRecord.getGross().replaceAll(",", "")));

        return movie;
    }
}
