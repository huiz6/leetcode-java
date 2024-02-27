package org.example.no343;

public class IntegerBreak {

    public int integerBreak(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int maxProduct = 1;
        while (true) {
            if (n > 4) {
                maxProduct *= 3;
                n -= 3;
            } else if (n == 4){
                maxProduct *= 4;
                break;
            } else {
                maxProduct *= n;
                break;
            }
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(new IntegerBreak().integerBreak(45));
    }

}
