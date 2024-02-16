package org.example.no46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Permutations2 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> resList = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];
        this.dfs(nums, 0, len, path, used, resList);
        return resList;
    }

    private void dfs(int[] nums, int depth, int len, Deque<Integer> path, boolean[] used, List<List<Integer>> resList) {
        if (depth == len) {
            resList.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i <= len - 1; i++) {
            if (!used[i]) {
                used[i] = true;
                path.addLast(nums[i]);
                this.dfs(nums, depth + 1, len, path, used, resList);
                path.removeLast();
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6};
        List<List<Integer>> resultList = new Permutations2().permute(nums);
        for (List<Integer> list : resultList) {
            System.out.println(list.toString());
        }
    }

}
