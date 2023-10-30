package javaclass;

public class Prime {

    public boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("squid:S106")
    public void printPrimesInRange(int start, int end) {
        if (start < 2) {
            start = 2;
        }
        for (int i = start; i < end; i++) {
            if (isPrime(i)) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        new Prime().printPrimesInRange(2, 20);
    }
}
