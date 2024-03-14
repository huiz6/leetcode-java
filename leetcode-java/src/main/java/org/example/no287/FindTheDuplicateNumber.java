package org.example.no287;

public class FindTheDuplicateNumber {

    public int findDuplicate(int[] nums) {
        boolean[] arr = new boolean[nums.length];
        for (int num: nums) {
            if (arr[num]) {
                return num;
            }
            arr[num] = true;
        }
        return -1;
    }

    public static void main(String[] args) {

    }

}
