package org.example.no3;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[128];
        int maxLength = 0, l = 1;
        for (int r = 1; r <= s.length(); r++) {
            char c = s.charAt(r - 1);
            if (arr[c] > 0) {
                l = Integer.max(arr[c] + 1, l);
            }
            arr[c] = r;
            maxLength = Integer.max(maxLength, r - l + 1);

        }
        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters characters = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(characters.lengthOfLongestSubstring(" "));
        System.out.println(characters.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(characters.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(characters.lengthOfLongestSubstring("bbbbb"));
        System.out.println(characters.lengthOfLongestSubstring("pwwkew"));
        System.out.println(characters.lengthOfLongestSubstring("aab"));
    }
}
