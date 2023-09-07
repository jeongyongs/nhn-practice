package com.nhnacademy.app.movie;

import static org.junit.jupiter.api.Assertions.assertThrows;
import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class BasicMovieParserTest {

    public static void main(String[] args) throws IOException {
        String fileName = "movies.csv";
        MovieParser movieParser = new BasicMovieParser();

        List<Movie> movies = movieParser.parse(fileName);

        for (Movie movie : movies) {
            System.out.println(movie);
        }
    }

    @Test
    void 잘못된_파일명_예외처리() {
        // given
        String fileName = "a";
        MovieParser movieParser = new BasicMovieParser();

        // when
        Executable executable = () -> movieParser.parse(fileName);

        // then
        assertThrows(NullPointerException.class, executable);
    }
}
