package org.example.no326;

public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n <= 0) {
            return false;
        }
        if (n == 1) {
            return true;
        }
        long k = 1;
        while (k * 3 <= n) {
            k = k * 3;
        }
        return k == n;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfThree().isPowerOfThree(1162261467));
    }
}
