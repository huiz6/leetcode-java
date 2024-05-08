package org.example.no17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    private final Map<String, List<String>> NUMBER_CHARACTER_MAP = new HashMap<String, List<String>>() {{
        put("2", Arrays.asList("a", "b", "c"));
        put("3", Arrays.asList("d", "e", "f"));
        put("4", Arrays.asList("g", "h", "i"));
        put("5", Arrays.asList("j", "k", "l"));
        put("6", Arrays.asList("m", "n", "o"));
        put("7", Arrays.asList("p", "q", "r", "s"));
        put("8", Arrays.asList("t", "u", "v"));
        put("9", Arrays.asList("w", "x", "y", "z"));
    }};

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        int digitsLength = digits.length();
        if (digitsLength != 0) {
            this.backTracing(0, digitsLength, "", digits, result);
        }
        return result;
    }

    private void backTracing(int index, int digitsLength, String combination, String digits, List<String> result) {
        if (index == digitsLength) {
            result.add(combination);
            return;
        }
        List<String> letterList = NUMBER_CHARACTER_MAP.get(digits.substring(index, index + 1));
        for (String letter : letterList) {
            combination += letter;
            backTracing(index + 1, digitsLength, combination, digits, result);
            combination = combination.substring(0, combination.length() - 1);
        }
    }

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber letterCombinationsOfAPhoneNumber = new LetterCombinationsOfAPhoneNumber();
        List<String> resultList = letterCombinationsOfAPhoneNumber.letterCombinations("");
        System.out.println(resultList);
    }

}
