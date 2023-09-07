package com.nhnacademy.app.movie;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public interface MovieParser {

    List<Movie> parse(String fileName) throws IOException;

    default InputStream getMovieFileAsStream(String fileName) {
        return getClass().getClassLoader().getResourceAsStream(fileName);
    }
}
