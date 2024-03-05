package org.example.no202;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

    public boolean isHappy(int n) {
        int finalN = n;
        Set<Integer> recordSet = new HashSet<Integer>() {{
            add(finalN);
        }};
        while (n != 1) {
            n = this.calculate(n);
            if (recordSet.contains(n)) {
                return false;
            }
            recordSet.add(n);
        }
        return true;
    }

    private int calculate(int n) {
        int result = 0;
        while (n > 0) {
            result += (int) Math.pow((n % 10), 2);
            n /= 10;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new HappyNumber().isHappy(2));
    }

}
