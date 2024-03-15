package org.example.no647;

public class PalindromicSubstrings {

    public int countSubstrings(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            count += this.extendCountSubstrings(s, i, i);
            count += this.extendCountSubstrings(s, i, i + 1);
        }
        return count;
    }

    private int extendCountSubstrings(String s, int l, int r) {
        int count = 0;
        while (l >= 0 && r <s.length()) {
            if (s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
                count++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        System.out.println(palindromicSubstrings.countSubstrings("abc"));
        System.out.println(palindromicSubstrings.countSubstrings("aaa"));
    }

}
