package org.example.no594;

import java.util.HashMap;
import java.util.Map;

public class LongestHarmoniousSubsequence {

    public int findLHS(int[] nums) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int num : nums) {
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
        }
        int length = 0;
        for (int num : numMap.keySet()) {
            if (numMap.containsKey(num - 1)) {
                length = Integer.max(length, numMap.get(num) + numMap.get(num - 1));
            }
            if (numMap.containsKey(num + 1)) {
                length = Integer.max(length, numMap.get(num) + numMap.get(num + 1));
            }
        }
        return length;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(new LongestHarmoniousSubsequence().findLHS(nums));
    }

}
