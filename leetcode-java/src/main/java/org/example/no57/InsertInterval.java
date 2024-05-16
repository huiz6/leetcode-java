package org.example.no57;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }

        List<int[]> intervalList = new ArrayList<>();
        boolean insertFlag = false;
        for (int[] interval : intervals) {
            if (insertFlag || interval[0] < newInterval[0]) {
                intervalList.add(interval);
            } else {
                intervalList.add(newInterval);
                intervalList.add(interval);
                insertFlag = true;
            }
        }
        if (!insertFlag) {
            intervalList.add(newInterval);
        }

        if (intervalList.size() < 2) {
            return intervalList.toArray(new int[intervalList.size()][]);
        }
        int[] intervalSlow = intervalList.get(0);
        List<int[]> resultList = new ArrayList<>();
        for (int i = 1; i < intervalList.size(); i++) {
            int[] intervalFast = intervalList.get(i);
            if (intervalSlow[1] >= intervalFast[0]) {
                intervalSlow[1] = Math.max(intervalSlow[1], intervalFast[1]);
            } else {
                resultList.add(intervalSlow);
                intervalSlow = intervalFast;
            }
        }
        resultList.add(intervalSlow);
        return resultList.toArray(new int[resultList.size()][]);
    }

    public static void main(String[] args) {
        InsertInterval insertInterval = new InsertInterval();
        int[][] intervals = {{1, 3}, {6, 9}};
        int[] newInterval = {4, 5};
//        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
//        int[] newInterval = {4, 8};
        int[][] result = insertInterval.insert(intervals, newInterval);
        for(int[] interval : result) {
            System.out.println(Arrays.toString(interval));
        }
    }

}
