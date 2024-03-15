package org.example.no409;

public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] charCount = new int['z' - 'A' + 1];
        for (char c : s.toCharArray()) {
            charCount[c - 'A']++;
        }
        boolean odd = false;
        int longest = 0;
        for (int count : charCount) {
            if (count % 2 == 1) {
                if (!odd) {
                    longest += count;
                    odd = true;
                } else {
                    longest += count - 1;
                }
            } else {
                longest += count;
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
    }

}
