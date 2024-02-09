package org.example.no347;

import java.util.Arrays;

public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            max = Integer.max(num, max);
            min = Integer.min(num, min);
        }

        int[][] bucket = new int[max - min + 1][2];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = new int[]{i, 0};
        }
        for (int num : nums) {
            bucket[num - min][1]++;
        }
        Arrays.sort(bucket, (o1, o2) -> -Integer.compare(o1[1], o2[1]));
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = bucket[i][0] + min;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1, -1, -1, 2, 2, 3};
        int k = 2;
        int[] result = new TopKFrequentElements().topKFrequent(nums, k);
        System.out.println(Arrays.toString(result));
    }

}
