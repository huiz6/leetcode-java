package org.example.no264;

public class UglyNumberII {

    public int nthUglyNumber(int n) {
        int index2 = 0, index3 = 0, index5 = 0;
        int[] uglyArray = new int[n];
        uglyArray[0] = 1;
        for (int i = 1; i < n; i++) {
            int factor2 = 2 * uglyArray[index2];
            int factor3 = 3 * uglyArray[index3];
            int factor5 = 5 * uglyArray[index5];
            uglyArray[i] = Integer.min(factor2, Integer.min(factor3, factor5));

            if (uglyArray[i] == factor2) {
                index2++;
            }
            if (uglyArray[i] == factor3) {
                index3++;
            }
            if (uglyArray[i] == factor5) {
                index5++;
            }
        }
        return uglyArray[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumberII().nthUglyNumber(10));
    }

}
