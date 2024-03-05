package org.example.no461;

public class HammingDistance {

    public int hammingDistance(int x, int y) {
        int r = x ^ y;
        int distance = 0;
        while (r != 0) {
            distance += r & 1;
            r = r >> 1;
        }
        return distance;
    }

    public static void main(String[] args) {
        int x = 1, y = 3;
        System.out.println(new HammingDistance().hammingDistance(x, y));
    }

}
