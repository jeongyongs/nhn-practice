package com.nhnacademy.quiz;

import java.util.ArrayList;
import java.util.List;

public class Quiz01 {

    private static List<String> options = new ArrayList<>();
    private static List<String> tokens = new ArrayList<>();

    public static void main(String[] args) {
        for (String arg : args) {
            separateByType(arg);
        }

        printList("Options:", options);
        printList("Tokens:", tokens);
    }

    private static void printList(String name, List<?> list) {
        System.out.println();
        System.out.println(name);
        list.stream().forEach(element -> System.out.println(" ".repeat(4) + element));
    }

    private static void separateByType(String arg) {
        if (arg.startsWith("-")) {
            options.add(arg);
            return;
        }
        tokens.add(arg);
    }
}
