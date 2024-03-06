package org.example.no260;

import java.util.Arrays;

public class SingleNumberIII {

    public int[] singleNumber(int[] nums) {
        int allXor = 0;
        for (int num : nums) {
            allXor ^= num;
        }

        int andNum = 1;
        while (allXor != 0) {
            if ((allXor & 1) == 1) {
                break;
            }
            andNum <<= 1;
            allXor >>= 1;
        }
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & andNum) == 0) {
                num1 ^= num;
            } else {
                num2 ^= num;
            }
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 1, 3, 3, 4, 2, 5};
        int[] result = new SingleNumberIII().singleNumber(nums);
        System.out.println(Arrays.toString(result));
    }

}
