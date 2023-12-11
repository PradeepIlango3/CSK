package interviews;

import java.math.BigDecimal;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 2000;
        printFibSeq(n);
    }
    private static void printFibSeq(int n) {
        if (n < 0) throw new IllegalArgumentException("Input is invalid. cannot be negative");
        BigDecimal prev = new BigDecimal(1);
        BigDecimal prevParent = new BigDecimal(0);
        for (int i = 0; i < n; i++) {
            if (i <= 1) System.out.println(i);
            else {
                BigDecimal fib = new BigDecimal(0).add(prevParent).add(prev);
                System.out.println(fib);
                prevParent = prev;
                prev = fib;
            }
        }
    }
}
