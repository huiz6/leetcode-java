package org.example.no268;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        int missing = 0;
        for(int i = 0; i < nums.length; i++) {
            missing ^= i;
            missing ^= nums[i];
        }
        return missing ^ nums.length;
    }

    public static void main(String[] args) {

    }

}
