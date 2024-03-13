package org.example.no128;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());

        int ans = 0;
        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int count = 0;
                while (numSet.contains(num)) {
                    count++;
                    num += 1;
                }
                ans = Integer.max(ans, count);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(new LongestConsecutiveSequence().longestConsecutive(nums));
    }

}
