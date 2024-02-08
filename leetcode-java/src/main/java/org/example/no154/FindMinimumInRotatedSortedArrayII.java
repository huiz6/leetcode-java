package org.example.no154;

public class FindMinimumInRotatedSortedArrayII {

    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1, mid;
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            if (l == r) {
                min = Math.min(min, nums[l]);
            }
            mid = l + (r - l) / 2;
            if (nums[mid] == nums[r]) {
                r--;
            } else if (nums[mid] < nums[r]) {
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            } else {
                min = Math.min(min, nums[l]);
                l = mid + 1;
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 1, 3};
        System.out.println(new FindMinimumInRotatedSortedArrayII().findMin(nums));
    }

}
