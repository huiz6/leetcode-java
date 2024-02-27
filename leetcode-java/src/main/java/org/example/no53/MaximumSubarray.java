package org.example.no53;

public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (i == 0) {
                dp[i] = nums[i];
            } else {
                if (dp[i - 1] < 0) {
                    dp[i] = nums[i];
                } else {
                    dp[i] = dp[i - 1] + nums[i];
                }
            }
            max = Integer.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1};
        System.out.println(new MaximumSubarray().maxSubArray(nums));
    }

}
