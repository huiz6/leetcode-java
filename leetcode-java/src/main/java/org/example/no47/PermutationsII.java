package org.example.no47;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        int length = nums.length;
        boolean[] indexUsed = new boolean[length];
        Set<Integer> usedSet = new HashSet<>();
        this.dfs(nums, length, indexUsed, usedSet, deque, resList);
        return resList;
    }

    private void dfs(int[] nums, int length, boolean[] indexUsed, Set<Integer> usedSet, Deque<Integer> deque, List<List<Integer>> resList) {
        if (deque.size() == length) {
            resList.add(new ArrayList<>(deque));
            return;
        }
        for (int i = 0; i < length; i++) {
            if (indexUsed[i]) {
                continue;
            }
            if (i > 0 && indexUsed[i - 1] && nums[i - 1] == nums[i]) {
                continue;
            }
            deque.addLast(nums[i]);
            usedSet.add(nums[i]);
            indexUsed[i] = true;
            this.dfs(nums, length, indexUsed, usedSet, deque, resList);
            deque.removeLast();
            usedSet.remove(nums[i]);
            indexUsed[i] = false;
        }

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        List<List<Integer>> resList = new PermutationsII().permuteUnique(nums);
        for (List<Integer> res : resList) {
            System.out.println(res.toString());
        }
    }

}
