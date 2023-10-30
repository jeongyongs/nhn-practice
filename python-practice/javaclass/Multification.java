package javaclass;

public class Multification {

    @SuppressWarnings("squid:S106")
    public void printMutificationTable(int number) {
        for (int i = 1; i < 10; i++) {
            System.out.println(number + " * " + i + " = " + String.format("%2d", number * i));
        }
    }

    public static void main(String[] args) {
        new Multification().printMutificationTable(7);
    }
}
