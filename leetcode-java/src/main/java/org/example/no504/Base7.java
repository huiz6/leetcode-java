package org.example.no504;

import java.util.Stack;

public class Base7 {

    public String convertToBase7(int num) {
        boolean positive = num >= 0;
        int k = 0;
        num = Math.abs(num);
        Stack<Integer> kPowStack = new Stack<>();
        while (true) {
            int pow = (int) Math.pow(7, k);
            if (pow > num) {
                break;
            }
            kPowStack.push(pow);
            k++;
        }
        StringBuilder resultBuilder = new StringBuilder();
        if (!positive) {
            resultBuilder.append("-");
        }
        while (!kPowStack.isEmpty()) {
            int pow = kPowStack.pop();
            resultBuilder.append(num / pow);
            num = num % pow;
        }
        if (resultBuilder.length() == 0) {
            resultBuilder.append("0");
        }
        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Base7().convertToBase7(0));
    }

}
