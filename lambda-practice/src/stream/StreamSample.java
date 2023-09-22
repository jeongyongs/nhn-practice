package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import builder.Guitarlist;

public class StreamSample {

    public static int[] getIntegers(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    public static List<Integer> getIntegerList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        return list;
    }

    public static List<Guitarlist> getGuitarlist() {
        List<Guitarlist> list = new ArrayList<>();
        list.add(Guitarlist.builder().name("A").build());
        list.add(Guitarlist.builder().name("B").build());
        list.add(Guitarlist.builder().name("C").build());
        return list;
    }
}


class Main {

    @SuppressWarnings("squid:S106")
    public static void main(String[] args) {
        int[] array = StreamSample.getIntegers(100);
        for (int i : array) {
            System.out.println(i);
        }

        List<Integer> list = StreamSample.getIntegerList(100);
        for (Integer i : list) {
            System.out.println(i);
        }

        List<Guitarlist> guitarlists = StreamSample.getGuitarlist();
        for (Guitarlist guitarlist : guitarlists) {
            System.out.println(guitarlist);
        }

        Arrays.stream(StreamSample.getIntegers(100))
                .filter(i -> i % 20 == 0)
                .map(i -> i + 1)
                .forEach(System.out::println);
    }
}
