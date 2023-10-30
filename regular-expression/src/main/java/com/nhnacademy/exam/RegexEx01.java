package com.nhnacademy.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SuppressWarnings("squid:S106")
public class RegexEx01 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[abcd][abcd]");
        Matcher matcher = pattern.matcher("hifhsdaoifhsdhi");

        int count = 0;
        while (matcher.find()) {
            System.out.println(matcher.start() + " : " + matcher.end());
            System.out.println("hifhsdaoifhsdhi".substring(matcher.start(), matcher.end()));
            count++;
        }

        System.out.println(count);
    }
}
