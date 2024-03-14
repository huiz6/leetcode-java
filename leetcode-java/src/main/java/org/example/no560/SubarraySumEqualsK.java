package org.example.no560;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            if (preSumMap.containsKey(preSum - k)) {
                count += preSumMap.get(preSum - k);
            }
            preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int k = 3;
        System.out.println(new SubarraySumEqualsK().subarraySum(nums, k));
    }

}
