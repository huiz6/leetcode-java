package org.example.no241;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String leftExpression = expression.substring(0, i);
                String rightExpression = expression.substring(i + 1);
                List<Integer> leftResultList = this.diffWaysToCompute(leftExpression);
                List<Integer> rightResultList = this.diffWaysToCompute(rightExpression);
                for (Integer leftResult : leftResultList) {
                    for (Integer rightResult : rightResultList) {
                        switch (c) {
                            case '+':
                                resultList.add(leftResult + rightResult);
                                break;
                            case '-':
                                resultList.add(leftResult - rightResult);
                                break;
                            case '*':
                                resultList.add(leftResult * rightResult);
                                break;
                        }
                    }
                }
            }
        }
        if (resultList.isEmpty()) {
            resultList.add(Integer.parseInt(expression));
        }
        return resultList;
    }

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        List<Integer> resultList = new DifferentWaysToAddParentheses().diffWaysToCompute(expression);
        System.out.println(resultList.toString());
    }

}
