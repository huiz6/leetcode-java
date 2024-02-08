package org.example.no69;

public class Sqrtx {

    public int mySqrt(int x) {
        if (0 == x) {
            return x;
        }
        int l = 1, r = x, mid, sqrt;
        while(l <= r) {
            mid = l + (r - l) / 2;
            sqrt = x / mid;
            if (sqrt == mid) {
                return mid;
            } else if (sqrt < mid) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new Sqrtx().mySqrt(8));
    }
}
