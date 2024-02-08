package org.example.no524;

import java.util.ArrayList;
import java.util.List;

public class LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> dictionary) {
        String longestWord = "";
        for (String dic : dictionary) {
            int i = 0;
            int j = 0;
            while (i < s.length() && j < dic.length()) {
                if (s.charAt(i) != dic.charAt(j)) {
                    i++;
                } else {
                    i++;
                    j++;
                }
            }
            if (j == dic.length()) {
                if (longestWord.length() < dic.length()) {
                    longestWord = dic;
                } else if (longestWord.length() == dic.length()) {
                    if (this.compareLexicographicalOrder(longestWord, dic) > 0) {
                        longestWord = dic;

                    }
                }
            }
        }
        return longestWord;
    }

    private int compareLexicographicalOrder(String s1, String s2) {
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return Character.compare(s1.charAt(i), s2.charAt(i));
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String s = "bab";
        List<String> dictionary = new ArrayList<String>() {{
            add("ba");
            add("ab");
            add("a");
            add("b");
        }};
        System.out.println(new LongestWordInDictionaryThroughDeleting().findLongestWord(s, dictionary));
    }

}
