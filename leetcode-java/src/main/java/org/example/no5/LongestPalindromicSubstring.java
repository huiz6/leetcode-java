package org.example.no5;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String longestPalindrome = "";
        for (int i = 0; i < s.length(); i++) {
            String oddSubString = this.subFind(s, i, i);
            if (longestPalindrome.length() < oddSubString.length()) {
                longestPalindrome = oddSubString;
            }

            String evenSubString = this.subFind(s, i, i + 1);
            if (longestPalindrome.length() < evenSubString.length()) {
                longestPalindrome = evenSubString;
            }
        }
        return longestPalindrome;
    }

    private String subFind(String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return s.substring(l + 1, r);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
    }

}
