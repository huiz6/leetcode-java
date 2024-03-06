package org.example.no448;

import java.util.ArrayList;
import java.util.List;

public class FindAllNumbersDisappearedInAnArray2 {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                resultList.add(i);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> resultList = new FindAllNumbersDisappearedInAnArray2().findDisappearedNumbers(nums);
        System.out.println(resultList.toString());
    }

}
