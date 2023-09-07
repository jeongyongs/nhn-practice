package com.nhnacademy.app.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BasicMovieParser implements MovieParser {

    @Override
    public List<Movie> parse(String fileName) throws IOException {
        InputStream inputStream = getMovieFileAsStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        List<Movie> list = new ArrayList<>();
        String line = bufferedReader.readLine(); // 컬럼(첫줄)을 제외하기 위해 한 줄을 불러온다.

        while (line != null) {
            line = bufferedReader.readLine();
            addNotNullItem(line, list);
        }

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

        return list;
    }

    private void addNotNullItem(String line, List<Movie> list) {
        if (line == null) {
            return;
        }

        String[] splittedLine = line.split(",");
        Long movieId = Long.parseLong(splittedLine[0]);
        String title = splittedLine[1];
        String rawGenreString = splittedLine[2];

        list.add(MovieMapper.mapToMovie(movieId, title, rawGenreString));
    }
}
