package org.example.no932;

import java.util.Arrays;

public class BeautifulArray2 {

    public int[] beautifulArray(int n) {
        if (n == 1) {
            return new int[] {1};
        }

        int[] odd = this.beautifulArray((n + 1) / 2);
        int[] even = this.beautifulArray(n / 2);
        int[] result = new int[n];
        for (int i = 0; i < odd.length; i++) {
            result[i] = 2 * odd[i] - 1;
        }
        for (int i = 0; i < even.length; i++) {
            result[i + odd.length] = 2 * even[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] resultArray = new BeautifulArray2().beautifulArray(7);
        System.out.println(Arrays.toString(resultArray));
    }
}
