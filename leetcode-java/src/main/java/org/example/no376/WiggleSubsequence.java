package org.example.no376;

public class WiggleSubsequence {

    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return length;
        }
        if (length == 2) {
            return nums[0] == nums[1] ? 1 : 2;
        }
        int result = nums[0] == nums[1] ? 1 : 2;
        for (int i = 2; i < length; i++) {
            if ((nums[i] - nums[i - 1]) * (nums[i - 1] - nums[i - 2]) < 0) {
                result++;
            } else if (nums[i - 1] == nums[i - 2] && nums[i] != nums[i - 1]) {
                int k = i - 3;
                while(k >= 0) {
                    if(nums[k] == nums[k + 1]) {
                        k--;
                    } else {
                        break;
                    }
                }
                if (k < 0 || (nums[i] - nums[i - 1]) * (nums[i - 1] - nums[k]) < 0) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 3, 3, 4, 5, 5, 5};
        System.out.println(new WiggleSubsequence().wiggleMaxLength(nums));
    }

}
