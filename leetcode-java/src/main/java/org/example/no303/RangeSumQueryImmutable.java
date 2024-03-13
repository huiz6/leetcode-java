package org.example.no303;

public class RangeSumQueryImmutable {

    private final int[] nums;
    private final int[] sums;

    public RangeSumQueryImmutable(int[] nums) {
        this.nums = nums;
        this.sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return this.sums[right];
        } else {
            return this.sums[right] - this.sums[left - 1];
        }
    }

    public static void main(String[] args) {

    }

}
