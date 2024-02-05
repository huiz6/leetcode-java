package org.example.no665;

public class NonDecreasingArray {

    public boolean checkPossibility(int[] nums) {
        int decreaseNum = 0;
        int breakPoint = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] < nums[i]) {
                decreaseNum++;
                breakPoint = i + 1;
            }
            if (decreaseNum >= 2) {
                return false;
            }
        }
        if (breakPoint == -1) {
            return true;
        } else {
            if (breakPoint == 1 || nums.length - breakPoint == 1) {
                return true;
            } else {
                return nums[breakPoint] >= nums[breakPoint - 2] || nums[breakPoint + 1] > nums[breakPoint - 1];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        System.out.println(new NonDecreasingArray().checkPossibility(nums));
    }
}
