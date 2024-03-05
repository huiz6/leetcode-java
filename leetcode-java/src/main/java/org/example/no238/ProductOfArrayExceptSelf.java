package org.example.no238;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int numLength = nums.length;
        int[] left = new int[numLength];
        left[0] = 1;
        int[] right = new int[numLength];
        right[numLength - 1] = 1;
        for (int i = 1; i < numLength; i++) {
            left[i] = left[i - 1] * nums[i - 1];
            right[numLength - 1 - i] = right[numLength - i] * nums[numLength - i];
        }
        for (int i = 0; i < numLength; i++) {
            left[i] = left[i] * right[i];
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 1, 0, -3, 3};
        int[] result = new ProductOfArrayExceptSelf().productExceptSelf(nums);
        System.out.println(Arrays.toString(result));
    }

}
