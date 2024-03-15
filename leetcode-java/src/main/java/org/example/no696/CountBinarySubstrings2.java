package org.example.no696;

public class CountBinarySubstrings2 {

    public int countBinarySubstrings(String s) {
        int pre = 0, cur = 1, count = 0;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }

            if (pre >= cur) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountBinarySubstrings2 countBinarySubstrings = new CountBinarySubstrings2();
        System.out.println(countBinarySubstrings.countBinarySubstrings("00110011"));
        System.out.println(countBinarySubstrings.countBinarySubstrings("10101"));
    }

}
