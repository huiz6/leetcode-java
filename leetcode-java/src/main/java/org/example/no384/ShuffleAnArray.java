package org.example.no384;

import java.util.Arrays;

public class ShuffleAnArray {

    private final int[] origin;

    public ShuffleAnArray(int[] nums) {
        origin = nums;
    }

    public int[] reset() {
        return origin;
    }

    public int[] shuffle() {
        int[] shuffle = Arrays.copyOf(origin, origin.length);
        for (int i = shuffle.length - 1; i >= 0; i--) {
            int randomIndex = (int) (shuffle.length * Math.random());
            int tmp = shuffle[i];
            shuffle[i] = shuffle[randomIndex];
            shuffle[randomIndex] = tmp;
        }
        return shuffle;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1, 2, 3};
        ShuffleAnArray shuffleAnArray = new ShuffleAnArray(nums);
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println(Arrays.toString(shuffleAnArray.shuffle()));
        System.out.println(Arrays.toString(shuffleAnArray.reset()));
    }

}
