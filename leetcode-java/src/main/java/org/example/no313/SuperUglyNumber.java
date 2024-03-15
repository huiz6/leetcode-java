package org.example.no313;

public class SuperUglyNumber {

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] index = new int[primes.length];
        long[] superUglyNumberArray = new long[n];
        superUglyNumberArray[0] = 1;
        for (int i = 1; i < n; i++) {
            long num = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++) {
                num = Long.min(num, primes[j] * superUglyNumberArray[index[j]]);
            }
            for (int j = 0; j < primes.length; j++) {
                if (num == primes[j] * superUglyNumberArray[index[j]]) {
                    index[j]++;
                }
            }
            superUglyNumberArray[i] = num;
        }
        return (int) superUglyNumberArray[n - 1];
    }

    public static void main(String[] args) {
        SuperUglyNumber superUglyNumber = new SuperUglyNumber();
        System.out.println(superUglyNumber.nthSuperUglyNumber(12, new int[]{2, 7, 13, 19}));
        System.out.println(superUglyNumber.nthSuperUglyNumber(1, new int[]{2, 3, 5}));
        System.out.println(superUglyNumber.nthSuperUglyNumber(5911, new int[]{2, 3, 5, 7}));
    }

}
