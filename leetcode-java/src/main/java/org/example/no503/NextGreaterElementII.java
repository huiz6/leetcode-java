package org.example.no503;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {

    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int numLength = nums.length;
        int[] ans = new int[numLength];
        Arrays.fill(ans, Integer.MIN_VALUE);
        for (int i = 0; i < numLength * 2; i++) {
            int index = i % numLength;
            while (!stack.isEmpty()) {
                int preIndex = stack.peek();
                if (nums[index] <= nums[preIndex]) {
                    break;
                }
                ans[preIndex] = nums[index];
                stack.pop();
            }
            if (ans[index] == Integer.MIN_VALUE) {
                stack.push(index);
            }
        }
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 1, 1};
        int[] ans = new NextGreaterElementII().nextGreaterElements(nums);
        System.out.println(Arrays.toString(ans));
    }
}
