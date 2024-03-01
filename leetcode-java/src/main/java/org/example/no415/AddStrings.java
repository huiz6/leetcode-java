package org.example.no415;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        if (num1.length() < num2.length()) {
            String tmp = num1;
            num1 = num2;
            num2 = tmp;
        }

        StringBuilder result = new StringBuilder();
        boolean carry = false;
        for (int index1 = num1.length(); index1 > 0; index1--) {
            int index2 = num2.length() - (num1.length() - index1);
            int bit1 = num1.charAt(index1 - 1) - '0';
            int bit2 = index2 < 1 ? 0 : num2.charAt(index2 - 1) - '0';
            int sum = bit1 + bit2 + (carry ? 1 : 0);
            if (sum > 9) {
                result.insert(0, sum % 10);
                carry = true;
            } else {
                result.insert(0, sum);
                carry = false;
            }
        }
        if (carry) {
            result.insert(0, 1);
        }
        return result.toString();

    }

    public static void main(String[] args) {
        String num1 = "5";
        String num2 = "5";
        System.out.println(new AddStrings().addStrings(num1, num2));
    }

}
