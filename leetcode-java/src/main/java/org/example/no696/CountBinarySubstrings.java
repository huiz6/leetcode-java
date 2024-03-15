package org.example.no696;

public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                count += this.extendCountBinarySubstrings(s, i, i + 1);
            }
        }
        return count;
    }

    private int extendCountBinarySubstrings(String s, int left, int right) {
        int count = 1;
        while (left > 0 && right < s.length() - 1) {
            if (s.charAt(left - 1) == s.charAt(left) && s.charAt(right) == s.charAt(right + 1)) {
                count++;
                left--;
                right++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();
        System.out.println(countBinarySubstrings.countBinarySubstrings("00110011"));
        System.out.println(countBinarySubstrings.countBinarySubstrings("10101"));
    }

}
