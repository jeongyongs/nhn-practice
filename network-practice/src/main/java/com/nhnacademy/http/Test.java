package com.nhnacademy.http;

public class Test {

    private static final String REQUEST_SEPARATOR = System.lineSeparator().repeat(2);
    private static final int HEADER = 0;
    private static final int BODY = 1;

    public static void main(String[] args) {
        String request = //
                "POST /welcome.html HTTP/1.1\n"//
                        + "Host: test-vm.com:3000\n" //
                        + "Connection: keep-alive\n" //
                        + "Content-Length: 45\n"//
                        + "Cache-Control: max-age=0\n" //
                        + "Origin: http://test-vm.com\n"//
                        + "Upgrade-Insecure-Requests: 1\n"//
                        + "User-Agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_12_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36\n"//
                        + "Content-Type: application/x-www-form-urlencoded\n"//
                        + "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n"//
                        + "DNT: 1\n" //
                        + "Referer: http://test-vm.com:3000/form-post1.html\n"//
                        + "Accept-Encoding: gzip, deflate, br\n" //
                        + "Accept-Language: ko\n" //
                        + "\n"//
                        + "name=TEST-NAME&content=TEST-CONTENT&send=send";

        String[] splittedRequest = request.split(REQUEST_SEPARATOR);
        System.out.println(splittedRequest[BODY]);
    }
}
