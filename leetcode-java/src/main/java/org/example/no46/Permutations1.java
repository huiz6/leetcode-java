package org.example.no46;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations1 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        this.backTracking(nums, 0, resultList);
        return resultList;
    }

    private void backTracking(int[] nums, int level, List<List<Integer>> resultList) {
        if (level == nums.length - 1) {
            resultList.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        for (int i = level; i < nums.length; i++) {
            try {
                this.swap(nums, i, level);
                this.backTracking(nums, level + 1, resultList);
                this.swap(nums, i, level);
            } catch (Exception e) {
                System.out.printf("i: %d, level: %d, occur exception.%n", i, level);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) throws Exception {
        if (index1 >= nums.length || index1 < 0 || index2 >= nums.length || index2 < 0) {
            throw new Exception("index out of bound!");
        }
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        List<List<Integer>> resultList = new Permutations1().permute(nums);
        for (List<Integer> list : resultList) {
            System.out.println(list.toString());
        }
    }

}
