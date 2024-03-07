package org.example.no769;

public class MaxChunksToMakeSorted {

    public int maxChunksToSorted(int[] arr) {
        int maxChunks = 0;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            maxValue = Integer.max(maxValue, arr[i]);
            if (maxValue == i) {
                maxChunks++;
            }
        }
        return maxChunks;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 3, 4};
        System.out.println(new MaxChunksToMakeSorted().maxChunksToSorted(arr));
    }

}
