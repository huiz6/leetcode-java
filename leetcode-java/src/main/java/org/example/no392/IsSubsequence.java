package org.example.no392;

public class IsSubsequence {

    public boolean isSubsequence(String s, String t) {
        int tLength = t.length(), sLength = s.length(), tIndex = 0, sIndex = 0;
        while (sIndex < sLength && tIndex < tLength) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
                sIndex++;
            } else {
                tIndex++;
            }
        }
        return sIndex == sLength;
    }

    public static void main(String[] args) {
        IsSubsequence isSubsequence = new IsSubsequence();
        System.out.println(isSubsequence.isSubsequence("abc", "ahbgdc"));
        System.out.println(isSubsequence.isSubsequence("axc", "ahbgdc"));
    }

}
