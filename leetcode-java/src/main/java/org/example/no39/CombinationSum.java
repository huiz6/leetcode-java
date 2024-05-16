package org.example.no39;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        this.backTracing(candidates, target, 0, new ArrayList<>(), resultList);
        return resultList;
    }

    private void backTracing(
            int[] candidates, int remain, int start, List<Integer> tempList, List<List<Integer>> resultList
    ) {
        if (remain < 0) {
            return;
        }
        if (remain == 0) {
            resultList.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                this.backTracing(candidates, remain - candidates[i], i, tempList, resultList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(candidates, target));
    }

}
