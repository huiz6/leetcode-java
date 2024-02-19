package org.example.no40;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> resList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        this.backTracking(candidates, target, deque, 0, resList);
        return resList;
    }

    private void backTracking(
            int[] candidates, int target, Deque<Integer> deque, int pos, List<List<Integer>> resList
    ) {
        if (target == 0) {
            resList.add(new ArrayList<>(deque));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = pos; i < candidates.length; i++) {
            if (i > pos && candidates[i - 1] == candidates[i]) {
                continue;
            }
            deque.addLast(candidates[i]);
            this.backTracking(candidates, target - candidates[i], deque, i + 1, resList);
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{14, 6, 25, 9, 30, 20, 33, 34, 28, 30, 16, 12, 31, 9, 9, 12, 34, 16, 25, 32, 8, 7, 30, 12, 33, 20, 21, 29, 24, 17, 27, 34, 11, 17, 30, 6, 32, 21, 27, 17, 16, 8, 24, 12, 12, 28, 11, 33, 10, 32, 22, 13, 34, 18, 12};
        int target = 27;
        List<List<Integer>> resList = new CombinationSumII().combinationSum2(candidates, target);
        for (List<Integer> res : resList) {
            System.out.println(res.toString());
        }
    }
}
