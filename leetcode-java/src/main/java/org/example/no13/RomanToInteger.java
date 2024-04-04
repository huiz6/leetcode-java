package org.example.no13;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("I", 1);
            put("IV", 4);
            put("V", 5);
            put("IX", 9);
            put("X", 10);
            put("XL", 40);
            put("L", 50);
            put("XC", 90);
            put("C", 100);
            put("CD", 400);
            put("D", 500);
            put("CM", 900);
            put("M", 1000);
        }};

        int num = 0;
        for (int i = 1; i <= s.length(); i++) {
            String c1 = s.substring(i - 1, i);
            if (i != s.length()) {
                String c2 = s.substring(i, i + 1);
                if (map.get(c1) < map.get(c2)) {
                    num += map.get(s.substring(i - 1, i + 1));
                    i++;
                } else {
                    num += map.get(c1);
                }
            } else {
                num += map.get(c1);
            }
        }
        return num;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        String s1 = "III";
        String s2 = "LVIII";
        String s3 = "MCMXCIV";
        System.out.println(romanToInteger.romanToInt(s1));
        System.out.println(romanToInteger.romanToInt(s2));
        System.out.println(romanToInteger.romanToInt(s3));

    }
}
