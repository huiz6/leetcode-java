package org.example.no540;

public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int l = 0, r = nums.length - 1, mid, singleNum = nums[0];
        while (l <= r) {
            if (l == r) {
                singleNum = nums[l];
                break;
            }
            mid = l + (r - l) / 2;
            if (mid % 2 == 0) {
                if (nums[mid] == nums[mid + 1]) {
                    l = mid;
                } else if (nums[mid] == nums[mid - 1]) {
                    r = mid;
                } else {
                    singleNum = nums[mid];
                    break;
                }
            } else {
                if (nums[mid] == nums[mid + 1]) {
                    r = mid - 1;
                } else if (nums[mid] == nums[mid - 1]) {
                    l = mid + 1;
                } else {
                    singleNum = nums[mid];
                    break;
                }
            }
        }
        return singleNum;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 7, 7, 8};
        System.out.println(new SingleElementInASortedArray().singleNonDuplicate(nums));
    }

}
