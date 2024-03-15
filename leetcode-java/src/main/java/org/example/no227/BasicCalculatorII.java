package org.example.no227;

import java.util.Stack;

public class BasicCalculatorII {

    public int calculate(String s) {
        Stack<String> stack1 = new Stack<>(), stack2 = new Stack<>();
        int pre = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') {
                stack1.push(s.substring(pre, i).trim());
                stack1.push(s.substring(i, i + 1));
                pre = i + 1;
            }
        }
        stack1.push(s.substring(pre).trim());

        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        while (!stack2.isEmpty()) {
            String s1 = stack2.pop();
            if (s1.equals("*")) {
                stack1.push(
                        String.valueOf(Integer.parseInt(stack1.pop()) * Integer.parseInt(stack2.pop()))
                );
            } else if (s1.equals("/")) {
                stack1.push(
                        String.valueOf(Integer.parseInt(stack1.pop()) / Integer.parseInt(stack2.pop()))
                );
            } else {
                stack1.push(s1);
            }
        }

        while(!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        int result = 0;
        boolean plus = true;
        while (!stack2.isEmpty()) {
            String s2 = stack2.pop();
            if (s2.equals("+")) {
                plus = true;
            } else if (s2.equals("-")) {
                plus = false;
            } else {
                if (plus) {
                    result += Integer.parseInt(s2);
                } else {
                    result -= Integer.parseInt(s2);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        BasicCalculatorII basicCalculatorII = new BasicCalculatorII();
        System.out.println(basicCalculatorII.calculate("3+2*2"));
        System.out.println(basicCalculatorII.calculate(" 3/2 "));
        System.out.println(basicCalculatorII.calculate("3+5 / 2"));
        System.out.println(basicCalculatorII.calculate("14/3*2"));
        System.out.println(basicCalculatorII.calculate("0-2147483647"));
    }

}
