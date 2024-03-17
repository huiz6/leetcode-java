package org.example.no5;

public class LongestPalindromicSubstring2 {

    public String longestPalindrome(String s) {
        int sLength = s.length();
        boolean[][] dp = new boolean[sLength][sLength + 1];
        int maxL = 0, maxR = 0;
        for (int l = 0; l < sLength; l++) {
            for (int r = l; r < sLength + 1; r++) {
                if (l == r || l + 1 == r) {
                    dp[l][r] = true;
                }
            }
        }
        for (int l = sLength - 1; l >= 0; l--) {
            for (int r = l; r < sLength + 1; r++) {
                if (l != r && l + 1 != r) {
                    if (s.charAt(l) == s.charAt(r - 1)) {
                        dp[l][r] = dp[l + 1][r - 1];
                    } else {
                        dp[l][r] = false;
                    }
                }
                if (dp[l][r] && r - l > maxR - maxL) {
                    maxL = l;
                    maxR = r;
                }
            }
        }
        return s.substring(maxL, maxR);
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring2 longestPalindromicSubstring = new LongestPalindromicSubstring2();
        System.out.println(longestPalindromicSubstring.longestPalindrome("aaaa"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("babad"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
    }

}
