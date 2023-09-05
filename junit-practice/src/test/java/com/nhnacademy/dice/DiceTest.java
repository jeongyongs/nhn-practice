package com.nhnacademy.dice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Random;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class DiceTest {

    @DisplayName("다이스 합 테스트")
    @Test
    void 다이스_합_테스트() {
        // given
        Random random = new Random();

        int firstNumber = random.nextInt(5) + 1;
        int secondNumber = random.nextInt(5) + 1;
        Dice dice1 = new Dice(firstNumber);
        Dice dice2 = new Dice(secondNumber);

        int expected = firstNumber + secondNumber;

        // when
        int actual = DiceCalculator.addDice(dice1, dice2);

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("다이스 차 테스트")
    @Test
    void 다이스_차_테스트() {
        // given
        Random random = new Random();

        int firstNumber = random.nextInt(5) + 1;
        int secondNumber = random.nextInt(5) + 1;
        Dice dice1 = new Dice(firstNumber);
        Dice dice2 = new Dice(secondNumber);

        int expected = Math.abs(firstNumber - secondNumber);

        // when
        int actual = DiceCalculator.subDice(dice1, dice2);

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("다이스 곱 테스트")
    @Test
    void 다이스_곱_테스트() {
        // given
        Random random = new Random();

        int firstNumber = random.nextInt(5) + 1;
        int secondNumber = random.nextInt(5) + 1;
        Dice dice1 = new Dice(firstNumber);
        Dice dice2 = new Dice(secondNumber);

        int expected = firstNumber * secondNumber;

        // when
        int actual = DiceCalculator.mulDice(dice1, dice2);

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("다이스 몫 테스트")
    @Test
    void 다이스_몫_테스트() {
        // given
        Random random = new Random(0);

        int firstNumber = random.nextInt(5) + 1;
        int secondNumber = random.nextInt(5) + 1;
        Dice dice1 = new Dice(firstNumber);
        Dice dice2 = new Dice(secondNumber);

        int max = Integer.max(firstNumber, secondNumber);
        int min = Integer.min(firstNumber, secondNumber);

        int expected = max / min;

        // when
        int actual = DiceCalculator.divDice(dice1, dice2);

        // then
        assertEquals(expected, actual);
    }

    @DisplayName("잘못된 주사위 값 테스트")
    @Test
    void 잘못된_주사위_값_테스트() {
        // given
        int number = 10;

        // when
        Executable executable = () -> new Dice(number);

        // then
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, executable);
        assertEquals("잘못된 주사위 값입니다.", exception.getMessage());
    }
}
