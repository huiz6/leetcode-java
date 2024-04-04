package org.example.no12;

public class IntegerToRoman {

    public String intToRoman(int num) {
        int[] valueArray = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbolArray = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder roman = new StringBuilder();
        for (int i = 0; i < valueArray.length; i++) {
            int count = num / valueArray[i];
            for (int j = 0; j < count; j++) {
                roman.append(symbolArray[i]);
            }
            num = num % valueArray[i];
        }
        return roman.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman integerToRoman = new IntegerToRoman();
        int num1 = 3;
        int num2 = 58;
        int num3 = 1994;
        System.out.println(integerToRoman.intToRoman(num1));
        System.out.println(integerToRoman.intToRoman(num2));
        System.out.println(integerToRoman.intToRoman(num3));
    }

}
