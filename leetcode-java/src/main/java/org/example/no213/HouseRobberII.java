package org.example.no213;

public class HouseRobberII {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Integer.max(nums[0], nums[1]);
        }
        return Integer.max(this.subRob(nums, 0, length - 2), this.subRob(nums, 1, length - 1));
    }

    private int subRob(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n == 2) {
            return Integer.max(nums[start], nums[start + 1]);
        }
        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Integer.max(nums[start], nums[start + 1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Integer.max(dp[i - 1], dp[i - 2] + nums[start + i]);
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};
        System.out.println(new HouseRobberII().rob(nums));
    }

}
