package org.example.no338;

import java.util.Arrays;

public class CountingBits {

    public int[] countBits(int n) {
        int[] resultArray = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            resultArray[i] = this.countOneNum(i);
        }
        return resultArray;
    }

    private int countOneNum(int num) {
        int count = 0;
        while (num != 0) {
            if ((num & 1) == 1) {
                count++;
            }
            num >>= 1;
        }
        return count;
    }

    public static void main(String[] args) {
        CountingBits countingBits = new CountingBits();
        int[] resultArray = countingBits.countBits(4);
        System.out.println(Arrays.toString(resultArray));
    }

}
