package org.example.no494;

import java.util.Arrays;

public class TargetSum2 {

    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (sum < Math.abs(target)) {
            return 0;
        }
        if ((sum + target) % 2 != 0) {
            return 0;
        }
        int sumP = (sum + target) / 2;
        int[][] dp = new int[nums.length + 1][sumP + 1];

        for (int i = 0; i < nums.length + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < nums.length + 1; i++) {
            for (int j = 0; j <= sumP; j++) {
                if (j < nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                }
            }
        }
        return dp[nums.length][sumP];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1};
        int target = 0;
        System.out.println(new TargetSum2().findTargetSumWays(nums, target));
    }

}
