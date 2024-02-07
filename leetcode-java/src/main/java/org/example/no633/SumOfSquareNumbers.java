package org.example.no633;

public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        long i = 0;
        long j = (int)Math.sqrt(c) + 1;
        while (i <= j) {
            if (i * i + j * j > c) {
                j--;
            } else if (i * i + j * j < c) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new SumOfSquareNumbers().judgeSquareSum(2147483600));
    }
}
