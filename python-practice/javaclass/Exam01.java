package javaclass;

import java.util.ArrayList;
import java.util.List;

public class Exam01 {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> stream = new Stream<>(list);

        stream.map(String::valueOf) //
                .forEach(System.out::println);
    }
}


class Stream<T> {
    private Iterable<T> iterable;

    public Stream(Iterable<T> iterable) {
        this.iterable = iterable;
    }

    public <R> Iterable<R> map(Mapper<T, R> mapper) {
        List<R> result = new ArrayList<>();

        for (T element : iterable) {
            result.add(mapper.apply(element));
        }

        return result;
    }
}


interface Mapper<T, R> {
    R apply(T element);
}
