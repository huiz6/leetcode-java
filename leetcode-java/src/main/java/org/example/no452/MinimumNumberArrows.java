package org.example.no452;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberArrows {

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparing(point -> point[0]));
        int i = 0;
        int begin = points[0][0];
        int end = points[0][1];
        int shotNumber = 1;
        while (true) {
            if (i + 1 == points.length) {
                break;
            }
            begin = Integer.max(begin, points[i + 1][0]);
            end = Integer.min(end, points[i + 1][1]);
            if (end < begin) {
                begin = points[i + 1][0];
                end = points[i + 1][1];
                shotNumber++;
            }
            i++;
        }
        return shotNumber;
    }

    public static void main(String[] args) {
        int[] point1 = {1, 2};
        int[] point2 = {2, 3};
        int[] point3 = {3, 4};
        int[] point4 = {4, 5};
        int[] point5 = {7, 12};
        int[][] points = {point1};
        System.out.println(new MinimumNumberArrows().findMinArrowShots(points));

    }

}
