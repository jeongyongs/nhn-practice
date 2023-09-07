package com.nhnacademy.app.movie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MovieMapper {

    private MovieMapper() {}

    public static Movie mapToMovie(Long movieId, String title, String rawGenreString) {
        Set<String> genres = mapGenreSet(rawGenreString);

        return new Movie(movieId, title, genres);
    }

    private static Set<String> mapGenreSet(String rawGenreString) {
        String[] genreStrings = rawGenreString.split("\\|");
        Set<String> genres = new HashSet<>();

        Arrays.stream(genreStrings).forEach(genre -> genres.add(genre));

        return genres;
    }
}
