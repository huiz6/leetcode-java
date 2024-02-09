package org.example.no451;

import java.util.Arrays;

public class SortCharactersByFrequency {

    public String frequencySort(String s) {
        int lower = Integer.MAX_VALUE;
        int upper = Integer.MIN_VALUE;
        for (int i = 0; i < s.length(); i++) {
            lower = Integer.min(lower, s.charAt(i));
            upper = Integer.max(upper, s.charAt(i));
        }
        int[][] bucket = new int[upper - lower + 1][2];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new int[]{i, 0};
        }
        for (int i = 0; i < s.length(); i++) {
            bucket[s.charAt(i) - lower][1]++;
        }
        Arrays.sort(bucket, ((o1, o2) -> -Integer.compare(o1[1], o2[1])));
        StringBuilder result = new StringBuilder();
        for (int[] intArray : bucket) {
            if (intArray[1] == 0) {
                break;
            }
            char c = (char) (intArray[0] + lower);
            for (int j = 0; j < intArray[1]; j++) {
                result.append(c);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String s = "cccaaa";
        System.out.println(new SortCharactersByFrequency().frequencySort(s));
    }

}
