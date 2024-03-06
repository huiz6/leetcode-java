package org.example.no693;

public class BinaryNumberWithAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        while (n != 0) {
            if (((n & 1) ^ ((n >> 1) & 1)) == 1) {
                n >>= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new BinaryNumberWithAlternatingBits().hasAlternatingBits(7));
    }

}
