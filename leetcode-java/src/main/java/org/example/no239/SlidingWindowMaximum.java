package org.example.no239;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int numsLength = nums.length;
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> descDeque = new ArrayDeque<>();
        for (int i = 0; i < numsLength; i++) {
            if (i >= k) {
                if (!descDeque.isEmpty() && descDeque.peekFirst() == nums[i - k]) {
                    descDeque.pollFirst();
                }
            }

            while (!descDeque.isEmpty() && descDeque.peekLast() < nums[i]) {
                descDeque.pollLast();
            }

            descDeque.addLast(nums[i]);

            if (i >= k - 1) {
                result[i - k + 1] = descDeque.peekFirst();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] result = new SlidingWindowMaximum().maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));
    }

}
