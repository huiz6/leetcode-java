package org.example.no137;

public class SingleNumberII {

    public int singleNumber(int[] nums) {
        int[] arr = new int[32];
        int bit = 1;
        for (int i = 0; i < 32; i++) {
            for (int num : nums) {
                arr[i] += ((num & bit) >> i);
            }
            bit <<= 1;
        }

        for (int i = 0; i < 32; i++) {
            arr[i] %= 3;
        }

        int num = 0;
        bit = 1;
        for (int i = 0; i < 32; i++) {
            num += arr[i] * bit;
            bit <<= 1;
        }
        return num;
    }

    public static void main(String[] args) {
        SingleNumberII singleNumberII = new SingleNumberII();
        int[] nums = {2, 2, 3, 2, 3, 3, 6};
        System.out.println(singleNumberII.singleNumber(nums));
    }

}
