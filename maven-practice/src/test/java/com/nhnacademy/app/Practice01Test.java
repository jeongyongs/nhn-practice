package com.nhnacademy.app;

import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class Practice01Test {

    @Test
    public void 랜덤_클래스를_사용한_랜덤_생성_테스트() {
        int randomInteger = Practice01.randomByUtilRandom();

        assertTrue(randomInteger >= 1 && randomInteger <= 100);
    }

    @Test
    public void 아파치_커먼을_사용한_랜덤_생성_테스트() {
        int randomInteger = Practice01.randomByApacheCommons();

        assertTrue(randomInteger >= 1 && randomInteger <= 100);
    }
}
