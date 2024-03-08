package org.example.no739;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] waitDays = new int[length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty()) {
                int preIndex = stack.peek();
                if (temperatures[i] <= temperatures[preIndex]) {
                    break;
                }
                stack.pop();
                waitDays[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return waitDays;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        int[] waitDays = new DailyTemperatures().dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(waitDays));
    }

}
