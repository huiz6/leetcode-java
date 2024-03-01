package org.example.no204;

public class CountPrimes {

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            count += this.isPrime(i) ? 1 : 0;
        }
        return count;
    }

    private boolean isPrime(int k) {
        if (k == 2) {
            return true;
        }
        for (int i = 2; i * i <= k; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new CountPrimes().countPrimes(5000000));
    }

}
