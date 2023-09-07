package com.nhnacademy.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Practice02Test {

    @Test
    public void null_문자열_null_테스트() {
        String input = null;
        boolean result = Practice02.isNullByString(input);

        assertTrue(result);
    }

    @Test
    public void 빈_문자열_False_null_테스트() {
        String input = "";
        boolean result = Practice02.isNullByString(input);

        assertFalse(result);
    }

    @Test
    public void 문자열_False_null_테스트() {
        String input = "문자열";
        boolean result = Practice02.isNullByString(input);

        assertFalse(result);
    }

    @Test
    public void null_문자열_empty_테스트() {
        String input = null;

        try {
            Practice02.isEmptyByString(input);
            assertTrue(false);
        } catch (NullPointerException ignore) {
        }
    }

    @Test
    public void 빈_문자열_empty_테스트() {
        String input = "";
        boolean result = Practice02.isEmptyByString(input);

        assertTrue(result);
    }

    @Test
    public void 문자열_empty_테스트() {
        String input = "문자열";
        boolean result = Practice02.isEmptyByString(input);

        assertFalse(result);
    }

    @Test
    public void null_문자열_empty_StringUtils_테스트() {
        String input = null;
        boolean result = Practice02.isEmptyByStringUtils(input);

        assertTrue(result);
    }

    @Test
    public void 빈_문자열_empty_StringUtils_테스트() {
        String input = "";
        boolean result = Practice02.isEmptyByStringUtils(input);

        assertTrue(result);
    }

    @Test
    public void 문자열_empty_StringUtils_테스트() {
        String input = "문자열";
        boolean result = Practice02.isEmptyByStringUtils(input);

        assertFalse(result);
    }
}
