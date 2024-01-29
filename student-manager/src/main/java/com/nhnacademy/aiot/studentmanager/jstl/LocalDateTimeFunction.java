package com.nhnacademy.aiot.studentmanager.jstl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeFunction {
    private LocalDateTimeFunction() {
        // Util class
    }

    public static String formatDate(LocalDateTime localDateTime, String pattern) {
        return localDateTime.format(DateTimeFormatter.ofPattern(pattern));
    }
}