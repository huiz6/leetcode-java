package org.example.no167;

import java.util.Arrays;

public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (true) {
            if (numbers[i ] + numbers[j] > target) {
                j--;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                return new int[]{i + 1, j + 1};
            }
        }
    }

    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(new TwoSumII().twoSum(numbers, target)));
    }

}
