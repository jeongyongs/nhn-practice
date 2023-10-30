package javaclass;

import java.util.function.IntBinaryOperator;

public class Algorithm {

    public static int exam(IntBinaryOperator binaryOperator, int x, int y) {
        return binaryOperator.applyAsInt(x, y);
    }

    @SuppressWarnings("squid:S106")
    public static void main(String[] args) {
        IntBinaryOperator sum = (a, b) -> a + b;

        int result = Algorithm.exam(sum, 5, 3);

        System.out.println(result);
    }
}
