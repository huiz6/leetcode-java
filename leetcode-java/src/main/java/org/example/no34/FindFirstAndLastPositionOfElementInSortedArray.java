package org.example.no34;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int[] index = new int[]{-1, -1};
        while (i < nums.length) {
            if (nums[i] < target) {
                i++;
            } else if (nums[i] == target) {
                index[0] = i;
                break;
            } else {
                break;
            }
        }
        while (j >= 0) {
            if (nums[j] > target) {
                j--;
            } else if (nums[j] == target) {
                index[1] = j;
                break;
            } else {
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int target = 9;
        System.out.println(Arrays.toString(new FindFirstAndLastPositionOfElementInSortedArray().searchRange(nums, target)));
    }

}
