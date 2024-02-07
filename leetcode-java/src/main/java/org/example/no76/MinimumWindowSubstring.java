package org.example.no76;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        int i = 0, j = 1;
        String minSubString = "";
        Map<Character, Integer> sCharMap = this.convert(s.substring(i, j));
        Map<Character, Integer> tCharMap = this.convert(t);
        while (i < s.length() && j <= s.length()) {
            String subString = s.substring(i, j);
            if (this.contains(sCharMap, tCharMap)) {
                if (minSubString.isEmpty() || subString.length() < minSubString.length()) {
                    minSubString = subString;
                } else {
                    sCharMap.put(s.charAt(i), sCharMap.get(s.charAt(i)) - 1);
                    i++;
                }
            } else {
                if (j < s.length()) {
                    j++;
                    char c = s.charAt(j - 1);
                    if (sCharMap.containsKey(c)) {
                        sCharMap.put(c, sCharMap.get(c) + 1);
                    } else {
                        sCharMap.put(c, 1);
                    }
                } else {
                    break;
                }
            }

        }
        return minSubString;
    }

    public boolean contains(Map<Character, Integer> sCharMap, Map<Character, Integer> tCharMap) {
        for (Character c : tCharMap.keySet()) {
            if (!sCharMap.containsKey(c)) {
                return false;
            } else {
                if (sCharMap.get(c) < tCharMap.get(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public Map<Character, Integer> convert(String s) {
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!charCountMap.containsKey(c)) {
                charCountMap.put(c, 1);
            } else {
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
        }
        return charCountMap;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(new MinimumWindowSubstring().minWindow(s, t));
    }

}
