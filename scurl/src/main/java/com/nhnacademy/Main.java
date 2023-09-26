package com.nhnacademy;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;

/**
 * 커맨드라인 옵션을 처리하는 클래스입니다.
 */
public class Main {

    /**
     * 애플리케이션 진입점입니다.
     * 
     * @param args 커맨드라인 옵션입니다.
     */
    public static void main(String[] args) {
        Options options = new Options();
        options.addOption("v", false, "verbose, 요청, 응답 헤더를 출력한다.");
        options.addOption("H", true, "임의의 헤더를 서버로 전송한다.");
        options.addOption("d", true, "POST, PUT 등에 데이터를 전송한다.");
        options.addOption("X", true, "사용할 method를 지정한다. 지정되지 않은 경우, 기본값은 GET");
        options.addOption("L", false, "서버의 응답이 30x 계열이면 다음 응답을 따라 간다.");
        options.addOption("F", true,
                "multipart/form-data를 구성하여 전송한다. content 부분에 @filename을 사용할 수 있다.");

        HelpFormatter helpFormatter = new HelpFormatter();
        helpFormatter.printHelp("scurl [option] url" + System.lineSeparator() + "Options:",
                options);
    }
}
