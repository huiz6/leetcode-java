package org.example.no209;

public class MinimumSizeSubarraySum {

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, right = 1, sum = nums[0], minLength = Integer.MAX_VALUE;
        while (right <= nums.length) {
            if (sum >= target) {
                minLength = Math.min(minLength, right - left);
                sum -= nums[left++];
            } else {
                if (right == nums.length) {
                    break;
                } else {
                    sum += nums[right++];
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

    public static void main(String[] args) {
        MinimumSizeSubarraySum minimumSizeSubarraySum = new MinimumSizeSubarraySum();
        int target = 10;
        int[] nums = {1, 4, 4};
        System.out.println(minimumSizeSubarraySum.minSubArrayLen(target, nums));
    }

}
