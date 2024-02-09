package org.example.no215;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {
        return this.findKthLargest(nums, 0, nums.length - 1, k);
    }

    private int findKthLargest(int[] nums, int left, int right, int k) {
        if (right - left == 1) {
            if (k == 1) {
                return Math.max(nums[right], nums[left]);
            } else {
                return Math.min(nums[right], nums[left]);
            }
        }
        int pivot = nums[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && nums[r] < pivot) {
                r--;
            }
            if (l < r) {
                nums[l++] = nums[r];
            }
            while (l < r && nums[l] > pivot) {
                l++;
            }
            if (l < r) {
                nums[r--] = nums[l];
            }
        }
        nums[l] = pivot;
        if (l - left + 1 == k) {
            return pivot;
        } else if (l - left + 1 > k) {
            return this.findKthLargest(nums, left, l - 1, k);
        } else {
            return this.findKthLargest(nums, l + 1, right, k - (l - left + 1));
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,3,3,3,4,3,3,3,3};
        int k = 1;
        System.out.println(new KthLargestElementInAnArray().findKthLargest(nums, k));
    }

}
