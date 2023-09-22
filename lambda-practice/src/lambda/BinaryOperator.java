package lambda;
@FunctionalInterface
public interface BinaryOperator {
    int apply(int x, int y);
}


class Adder implements BinaryOperator {
    @Override
    public int apply(int x, int y) {
        return x + y;
    }
}


class Main {
    @SuppressWarnings({"squid:S106", "squid:S1604"})
    public static void main(String[] args) {
        // class
        System.out.println(calc(new Adder(), 1, 2));

        // anonymous class
        System.out.println(calc(new BinaryOperator() {
            @Override
            public int apply(int x, int y) {
                return x + y;
            }
        }, 1, 2));

        // lambda expression
        System.out.println(calc((x, y) -> x + y, 1, 2));
    }

    private static int calc(BinaryOperator binaryOperator, int x, int y) {
        return binaryOperator.apply(x, y);
    }
}
