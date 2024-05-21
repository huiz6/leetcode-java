package org.example.no33;

public class SearchInRotatedSortedArray {

    public int search(int[] nums, int target) {
        return this.binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        int middle = (left + right) / 2;
        if (nums[middle] == target) {
            return middle;
        }

        if (left == right) {
            return -1;
        }

        if (nums[left] <= nums[middle]) {
            if (nums[middle] > target && target >= nums[left]) {
                return binarySearch(nums, target, left, middle - 1);
            } else {
                return binarySearch(nums, target, middle + 1, right);
            }
        } else {
            if (nums[middle] < target && target <= nums[right]) {
                return binarySearch(nums, target, middle + 1, right);
            } else {
                return binarySearch(nums, target, left, middle - 1);
            }
        }
    }

    public static void main(String[] args) {
        SearchInRotatedSortedArray searchInRotatedSortedArray = new SearchInRotatedSortedArray();
        int[] nums = new int[]{1, 3};
        int target = 0;
//        System.out.println(searchInRotatedSortedArray.search(nums, 8));
//        System.out.println(searchInRotatedSortedArray.search(nums, 5));
//        System.out.println(searchInRotatedSortedArray.search(nums, 6));
//        System.out.println(searchInRotatedSortedArray.search(nums, 7));
//        System.out.println(searchInRotatedSortedArray.search(nums, 0));
//        System.out.println(searchInRotatedSortedArray.search(nums, 1));
//        System.out.println(searchInRotatedSortedArray.search(nums, 2));
        System.out.println(searchInRotatedSortedArray.search(nums, target));
    }
}
