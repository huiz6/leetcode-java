package org.example.no300;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    count = Integer.max(count ,dp[j] + 1);
                }
            }
            dp[i] = count;
            max = Integer.max(count, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,7,7,7,7,7,7};
        System.out.println(new LongestIncreasingSubsequence().lengthOfLIS(nums));
    }

}
