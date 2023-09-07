package com.nhnacademy.app;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class Practice02 {

    private Practice02() {}

    public static boolean isNullByString(String input) {
        return Objects.isNull(input);
    }

    public static boolean isEmptyByString(String input) {
        return input.isEmpty();
    }

    public static boolean isEmptyByStringUtils(String input) {
        return StringUtils.isEmpty(input);
    }
}
