package org.example.no2575;

import java.util.Arrays;

public class FindTheDivisibilityArrayOfAString {

    public int[] divisibilityArray(String word, int m) {
        int[] div = new int[word.length()];
        long mode = 0;
        for (int k = 0; k < word.length(); k++) {
            mode = (mode * 10 + (word.charAt(k) - '0')) % m;
            div[k] = mode == 0 ? 1 : 0;
        }
        return div;
    }

    public static void main(String[] args) {
        String word = "100000000010000000003019999999961000000000";
        int m = 1000000000;
        int[] div = new FindTheDivisibilityArrayOfAString().divisibilityArray(word, m);
        System.out.println(Arrays.toString(div));
    }

}
