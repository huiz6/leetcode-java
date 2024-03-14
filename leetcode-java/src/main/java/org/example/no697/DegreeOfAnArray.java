package org.example.no697;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                indexMap.get(nums[i]).add(i);
            } else {
                List<Integer> indexList = new ArrayList<>();
                indexList.add(i);
                indexMap.put(nums[i], indexList);
            }
        }
        int maxDegree = Integer.MIN_VALUE;
        int shortest = Integer.MAX_VALUE;
        for (int key : indexMap.keySet()) {
            List<Integer> indexList = indexMap.get(key);
            int gap = indexList.get(indexList.size() - 1) - indexList.get(0) + 1;
            if (indexList.size() > maxDegree) {
                maxDegree = indexList.size();
                shortest = gap;
            } else if (indexList.size() == maxDegree) {
                shortest = Integer.min(shortest, gap);
            }
        }
        return shortest;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 3, 1};
        System.out.println(new DegreeOfAnArray().findShortestSubArray(nums));
    }

}
