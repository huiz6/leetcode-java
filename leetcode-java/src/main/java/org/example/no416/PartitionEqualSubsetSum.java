package org.example.no416;

import java.util.Arrays;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[target + 1][nums.length + 1];
        Arrays.fill(dp[0], true);
        for (int i = 1; i < target + 1; i++) {
            for (int j = 1; j < nums.length + 1; j++) {
                if (i - nums[j - 1] >= 0) {
                    dp[i][j] = dp[i - nums[j - 1]][j - 1] || dp[i][j - 1];
                } else {
                    dp[i][j] = dp[i][j - 1];
                }
            }
        }
        for (int j = 0; j <= nums.length; j++) {
            if (dp[target][j]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 99};
        System.out.println(new PartitionEqualSubsetSum().canPartition(nums));
    }

}
