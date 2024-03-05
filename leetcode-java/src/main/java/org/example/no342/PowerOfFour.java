package org.example.no342;

public class PowerOfFour {

    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        if ((n & (n - 1)) != 0) {
            return false;
        }
        int i = 0;
        while (n != 0) {
            n >>= 1;
            i++;
        }
        return i % 2 == 1;
    }

    public static void main(String[] args) {
        System.out.println(new PowerOfFour().isPowerOfFour(1));
    }

}
