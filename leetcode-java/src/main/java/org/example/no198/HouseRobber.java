package org.example.no198;

public class HouseRobber {

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        if (length == 2) {
            return Integer.max(nums[0], nums[1]);
        }
        int pre2 = nums[0];
        int pre1 = Integer.max(nums[0], nums[1]);
        int cur = 0;
        for (int i = 2; i < length; i++) {
            cur = Integer.max(pre2 + nums[i], pre1);
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1};
        System.out.println(new HouseRobber().rob(nums));
    }

}
