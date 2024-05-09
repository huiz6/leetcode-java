package org.example.no56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing(o -> o[0]));
        List<int[]> resultList = new ArrayList<>();
        int[] interval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (interval[1] >= intervals[i][0]) {
                interval = new int[]{interval[0], Math.max(interval[1], intervals[i][1])};
            } else {
                resultList.add(interval);
                interval = intervals[i];
            }
        }
        resultList.add(interval);
        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        int[] interval1 = {1, 3};
        int[] interval2 = {2, 6};
        int[] interval3 = {8, 10};
        int[] interval4 = {15, 18};
        int[][] intervals = {interval1, interval2, interval3, interval4};
        MergeIntervals mergeIntervals = new MergeIntervals();
        int[][] mergedIntervals = mergeIntervals.merge(intervals);
        for(int[] interval: mergedIntervals){
            System.out.println(Arrays.toString(interval));
        }
    }

}
