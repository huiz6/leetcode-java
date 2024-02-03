package org.example.no435;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 1) {
            return 0;
        }
        Arrays.sort(intervals, Comparator.comparing(interval -> interval[1]));
//        for (int i = 0; i < intervals.length; i++) {
//            System.out.println(Arrays.toString(intervals[i]));
//        }
        int i = 0;
        int j = i + 1;
        int eraseCount = 0;
        while (i < intervals.length - 1 && j < intervals.length) {
            if (intervals[j][0] < intervals[i][1]) {
//                System.out.println(Arrays.toString(intervals[j]));
                eraseCount++;
            } else {
                i = j;
            }
            j++;
        }
        return eraseCount;
    }

    public static void main(String[] args) {
        NonOverlappingIntervals nonOverlappingIntervals = new NonOverlappingIntervals();
        int[] interval1 = {1, 2};
        int[] interval2 = {2, 3};
        int[] interval3 = {3, 4};
        int[] interval4 = {1, 3};
        int[][] intervals = {interval1, interval2, interval3, interval4};
        int result = nonOverlappingIntervals.eraseOverlapIntervals(intervals);
        System.out.println(result);
    }


}
