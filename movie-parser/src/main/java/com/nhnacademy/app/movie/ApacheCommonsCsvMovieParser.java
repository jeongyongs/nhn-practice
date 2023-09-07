package com.nhnacademy.app.movie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class ApacheCommonsCsvMovieParser implements MovieParser {

    @Override
    public List<Movie> parse(String fileName) throws IOException {
        InputStream inputStream = getMovieFileAsStream(fileName);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        CSVParser parser = CSVParser.parse(inputStreamReader, CSVFormat.EXCEL);
        List<Movie> list = new ArrayList<>();

        for (CSVRecord csvRecord : parser) {
            addNotNullItem(csvRecord, list);
        }

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

        return list;
    }

    private void addNotNullItem(CSVRecord csvRecord, List<Movie> list) {
        long movieId;
        try {
            movieId = Long.parseLong(csvRecord.get(0));
        } catch (Exception ignore) {
            return;
        }
        String title = csvRecord.get(1);
        String rawGenreString = csvRecord.get(2);

        list.add(MovieMapper.mapToMovie(movieId, title, rawGenreString));
    }
}
