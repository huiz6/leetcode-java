package org.example.no242;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sCharMap = new HashMap<>();
        Map<Character, Integer> tCharMap = new HashMap<>();

        for (char c : s.toCharArray()) {
            sCharMap.put(c, sCharMap.getOrDefault(c, 0) + 1);
        }
        for (char c : t.toCharArray()) {
            tCharMap.put(c, tCharMap.getOrDefault(c, 0) + 1);
        }
        return sCharMap.equals(tCharMap);
    }

    public static void main(String[] args) {
        ValidAnagram validAnagram = new ValidAnagram();
        System.out.println(validAnagram.isAnagram("anagram", "nagaram"));
        System.out.println(validAnagram.isAnagram("rat", "car"));
    }

}
