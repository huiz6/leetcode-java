package org.example.no120;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int height = triangle.size();
        int[][] dp = new int[height][height];
        for (int i = 0; i < height; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = triangle.get(0).get(0);
        for (int h = 1; h < height; h++) {
            for (int i = 0; i <= h; i++) {
                if (i == 0) {
                    dp[h][i] = dp[h - 1][i] + triangle.get(h).get(i);
                } else if (i == height - 1) {
                    dp[h][i] = dp[h - 1][i - 1] + triangle.get(h).get(i);
                } else {
                    dp[h][i] = Math.min(dp[h - 1][i - 1], dp[h - 1][i]) + triangle.get(h).get(i);
                }
            }
        }
        return Arrays.stream(dp[height - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        List<List<Integer>> triangle = Arrays.asList(
                Collections.singletonList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        System.out.println(t.minimumTotal(triangle));
    }

}
