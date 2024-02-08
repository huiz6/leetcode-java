package org.example.no680;

public class ValidPalindromeII {

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return this.validPalindromeSub(s.substring(i + 1, j + 1)) || this.validPalindromeSub(s.substring(i, j));
            }
        }
        return true;
    }

    private boolean validPalindromeSub(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindromeII().validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
        System.out.println(new ValidPalindromeII().validPalindrome("abc"));
//        System.out.println(new ValidPalindromeII().validPalindrome("abc"));
    }

}
