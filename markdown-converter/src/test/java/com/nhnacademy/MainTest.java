package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MainTest {

    @DisplayName("마크다운 파서 테스트")
    @Test
    void 마크다운_파서_테스트() {
        // given
        String inputString = "ExampleForTest";
        InputStream inputStream = new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inputStream);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        String expectedString = "<h1>이것은 제목입니다.</h1>\n"
                + "<p>여기는 본문 내용입니다.</p>\n"
                + "<ul>\n"
                + "<li>순서 없는 리스트1</li>\n"
                + "<li>순서 없는 리스트2</li>\n"
                + "</ul>";

        // when
        Main.main(null);

        // then
        assertEquals(expectedString, outputStream.toString().trim());

        // reset
        System.setIn(System.in);
        System.setOut(System.out);
    }
}
