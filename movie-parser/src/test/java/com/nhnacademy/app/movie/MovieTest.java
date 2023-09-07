package com.nhnacademy.app.movie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class MovieTest {

    @Test
    void 영화_객체_출력_테스트() {
        // given
        String expected =
                "Movie [movieId=0, title=Andrew Dice Clay: Dice Rules (1991), genres=[Comedy]]";
        Movie movie = new Movie(0, "Andrew Dice Clay: Dice Rules (1991)", Set.of("Comedy"));

        // when
        String actual = movie.toString();

        // then
        assertEquals(expected, actual);
    }
}
