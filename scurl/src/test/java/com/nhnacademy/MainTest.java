package com.nhnacademy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class MainTest {

    @AfterEach
    void 초기화() {
        System.setOut(System.out);
    }

    @Test
    void 옵션을_넣지_않으면_사용법을_출력한다() {
        // given
        OutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        final String HELP_MESSAGE = //
                "usage: scurl [option] url\n" //
                        + "Options:\n" //
                        + " -d <arg>   POST, PUT 등에 데이터를 전송한다.\n" //
                        + " -F <arg>   multipart/form-data를 구성하여 전송한다. content 부분에 @filename을 사용할 수\n" //
                        + "            있다.\n" //
                        + " -H <arg>   임의의 헤더를 서버로 전송한다.\n" //
                        + " -L         서버의 응답이 30x 계열이면 다음 응답을 따라 간다.\n" //
                        + " -v         verbose, 요청, 응답 헤더를 출력한다.\n" //
                        + " -X <arg>   사용할 method를 지정한다. 지정되지 않은 경우, 기본값은 GET";

        // when
        Main.main(new String[] {});

        // then
        assertEquals(HELP_MESSAGE, outputStream.toString().trim());
    }
}
