package org.example.no205;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Integer> sCharIndexMap = new HashMap<>();
        Map<Character, Integer> tCharIndexMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i), tChar = t.charAt(i);
            if (!sCharIndexMap.getOrDefault(sChar, -1).equals(tCharIndexMap.getOrDefault(tChar, -1))) {
                return false;
            }
            sCharIndexMap.put(sChar, i);
            tCharIndexMap.put(tChar, i);
        }
        return true;
    }

    public static void main(String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
        System.out.println(isomorphicStrings.isIsomorphic("badc", "baba"));
    }

}
