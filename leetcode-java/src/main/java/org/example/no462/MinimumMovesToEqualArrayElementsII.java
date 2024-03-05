package org.example.no462;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElementsII {

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        double median;
        if (nums.length % 2 == 0)
            median = ((double) nums[nums.length / 2] + (double) nums[nums.length / 2 - 1]) / 2;
        else
            median = (double) nums[nums.length / 2];

        int medianInt = (int) Math.round(median);

        return Arrays.stream(nums).map(o -> Math.abs(o - medianInt)).sum();
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 0, 0, 8, 6};
        System.out.println(new MinimumMovesToEqualArrayElementsII().minMoves2(nums));
    }

}
