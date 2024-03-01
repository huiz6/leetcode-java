package org.example.no172;

public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int zeroCount = 0;
        while (n != 0) {
            n = n / 5;
            zeroCount += n;
        }
        return zeroCount;
    }

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(6));
    }

}
