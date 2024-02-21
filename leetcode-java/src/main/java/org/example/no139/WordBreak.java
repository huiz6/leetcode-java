package org.example.no139;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        Set<String> wordSet = new HashSet<>(wordDict);
        for (int i = 0; i < length; i++) {
            boolean flag = false;
            for (int j = i; j >= 0; j--) {
                if (dp[j]) {
                    flag = wordSet.contains(s.substring(j, i + 1));
                }
                if (flag) {
                    break;
                }
            }
            dp[i + 1] = flag;
        }
        return dp[length];
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = new ArrayList<String>() {{
            add("cats");
            add("dog");
            add("sand");
            add("and");
            add("cat");
        }};
        System.out.println(new WordBreak().wordBreak(s, wordDict));
    }

}
