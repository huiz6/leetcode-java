package org.example.no318;

import java.util.HashMap;
import java.util.Map;

public class MaximumProductOfWordLengths {

    public int maxProduct(String[] words) {
        Map<Integer, Integer> wordMaskSizeMap = new HashMap<>();
        int maxLength = 0;
        for (String word : words) {
            int wordLength = word.length();
            int mask = 0;
            for (char c : word.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            wordMaskSizeMap.put(mask, Math.max(wordLength, wordMaskSizeMap.getOrDefault(mask, 0)));

            for (int wordMask : wordMaskSizeMap.keySet()) {
                if ((mask & wordMask) == 0) {
                    maxLength = Math.max(maxLength, wordLength * wordMaskSizeMap.get(wordMask));
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(new MaximumProductOfWordLengths().maxProduct(words));
    }

}
