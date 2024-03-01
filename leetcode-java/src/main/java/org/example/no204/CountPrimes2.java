package org.example.no204;

import java.util.Arrays;

public class CountPrimes2 {

    public int countPrimes(int n) {
        if (n <= 2) {
            return 0;
        }
        int[] prime = new int[n];
        Arrays.fill(prime, 1);
        prime[0] = 0;
        prime[1] = 0;
        for (int i = 2; i < n; i++) {
            int k = 2;
            while (k * i < n) {
                prime[k * i] = 0;
                k++;
            }
        }
        return (int)Arrays.stream(prime).filter(o -> o == 1).count();
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes2().countPrimes(5000000));
    }

}
