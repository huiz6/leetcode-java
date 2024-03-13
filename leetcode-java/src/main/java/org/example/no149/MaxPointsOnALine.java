package org.example.no149;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MaxPointsOnALine {

    public int maxPoints(int[][] points) {
        int max = 1;
        for (int i = 0; i < points.length - 1; i++) {
            Map<Double, Integer> slopeCountMap = new HashMap<>();
            int sameX = 1;
            for (int j = i + 1; j < points.length; j++) {
                if (points[j][0] == points[i][0]) {
                    sameX++;
                } else {
                    double slope = (double) (points[j][1] - points[i][1]) / (double) (points[j][0] - points[i][0]);
                    if (Math.abs(slope) == 0.0) {
                        slope = 0.0;
                    }
                    slopeCountMap.put(slope, slopeCountMap.getOrDefault(slope, 1) + 1);
                }
            }
            max = Integer.max(sameX, max);
            Optional<Integer> slopeMax = slopeCountMap.values().stream().max(Integer::compare);
            if (slopeMax.isPresent()) {
                max = Integer.max(slopeMax.get(), max);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] point1 = new int[]{2, 3};
        int[] point2 = new int[]{3, 3};
        int[] point3 = new int[]{-5, 3};
        int[] point4 = new int[]{4, 1};
        int[] point5 = new int[]{2, 3};
        int[] point6 = new int[]{1, 4};
        int[][] points = new int[][]{point1, point2, point3};
        System.out.println(new MaxPointsOnALine().maxPoints(points));
    }
}
