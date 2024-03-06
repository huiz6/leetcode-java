package org.example.no476;

public class NumberComplement {

    public int findComplement(int num) {
        int n = num;
        int xorNum = 1;
        while (n != 0) {
            n >>= 1;
            xorNum <<= 1;
        }
        return num ^ (xorNum - 1);
    }

    public static void main(String[] args) {
        System.out.println(new NumberComplement().findComplement(5));
    }

}
