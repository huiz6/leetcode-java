package org.example.no75;

import java.util.Arrays;

public class SortColors {

    public void sortColors(int[] nums) {
        int[] bucket = new int[]{0, 0, 0};
        for (int num : nums) {
            bucket[num]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            for (int j = 0; j < bucket[i]; j++) {
                nums[index++] = i;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        new SortColors().sortColors(nums);
    }
}
