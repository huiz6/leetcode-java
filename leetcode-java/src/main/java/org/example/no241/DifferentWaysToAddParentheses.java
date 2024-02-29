package org.example.no241;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {

    private final Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (map.containsKey(expression)) {
            return map.get(expression);
        }
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
        map.put(expression, resultList);
        return resultList;
    }

    public static void main(String[] args) {
        String expression = "2*3-4*5";
        List<Integer> resultList = new DifferentWaysToAddParentheses().diffWaysToCompute(expression);
        System.out.println(resultList.toString());
    }

}
