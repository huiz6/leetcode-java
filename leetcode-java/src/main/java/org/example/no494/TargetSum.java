package org.example.no494;

public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        int length = nums.length;
        return this.dfs(nums, length, 0, 0, target);
    }

    private int dfs(int[] nums, int length, int height, int result, int target) {
        if (height == length) {
            return result == target ? 1 : 0;
        }
        int count = 0;
        result += nums[height];
        height++;
        count += this.dfs(nums, length, height, result, target);
        height--;
        result -= nums[height];

        result -= nums[height];
        height++;
        count += this.dfs(nums, length, height, result, target);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        System.out.println(new TargetSum().findTargetSumWays(nums, target));
    }

}
