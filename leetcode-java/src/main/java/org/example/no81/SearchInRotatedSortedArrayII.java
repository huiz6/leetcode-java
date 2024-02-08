package org.example.no81;

public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[r]) {
                l++;
            } else {
                if (nums[mid] <= nums[r]) {
                    if (target > nums[mid] && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                } else {
                    if (target >= nums[l] && target < nums[mid]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 5, 6, 0, 0, 1, 2};
        int target = 4;
        System.out.println(new SearchInRotatedSortedArrayII().search(nums, target));
    }

}
