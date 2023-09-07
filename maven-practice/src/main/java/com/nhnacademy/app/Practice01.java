package com.nhnacademy.app;

import java.util.Random;
import org.apache.commons.math3.random.RandomDataGenerator;

/**
 * 4일차 메이븐 의존성 관리 연습을 위한 클래스입니다.
 */
public class Practice01 {

    private Practice01() {}

    /**
     * java.util.Random 라이브러리를 사용하여 1부터 100까지 정수 중 하나를 반환합니다.
     * 
     * @return 1부터 100까지 무작위 정수를 반환합니다.
     */
    public static int randomByUtilRandom() {
        return new Random(0).nextInt(100);
    }

    /**
     * org.apache.commons.math3.random.RandomDataGenerator 라이브러리를 사용하여 1부터 100까지 정수 중 하나를 반환합니다.
     * 
     * @return 1부터 100까지 무작위 정수를 반환합니다.
     */
    public static int randomByApacheCommons() {
        return new RandomDataGenerator().nextInt(1, 100);
    }
}
