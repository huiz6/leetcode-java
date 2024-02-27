package org.example.no646;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumLengthOfPairChain {

    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));
        int length = pairs.length;
        int[] dp = new int[length];
        dp[0] = 1;
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[i][0] > pairs[j][1]) {
                    dp[i] = Integer.max(dp[i], dp[j] + 1);
                } else {
                    dp[i] = Integer.max(dp[i], dp[j]);
                }
            }
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {
        int[] interval1 = new int[]{1, 2};
        int[] interval2 = new int[]{2, 3};
        int[] interval3 = new int[]{3, 4};
        int[][] pairs = new int[][]{interval1, interval3,interval2};
        System.out.println(new MaximumLengthOfPairChain().findLongestChain(pairs));
    }

}
