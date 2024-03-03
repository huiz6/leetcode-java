package org.example.no67;

public class AddBinary {

    public String addBinary(String a, String b) {
        if (a.length() < b.length()) {
            String tmp = a;
            a = b;
            b = tmp;
        }

        boolean carry = false;
        StringBuilder resultBuilder = new StringBuilder();
        for (int indexA = a.length() - 1; indexA >= 0; indexA--) {
            int indexB = indexA - (a.length() - b.length());
            int aBitNum = a.charAt(indexA) - '0';
            int bBitNum = indexB >= 0 ? b.charAt(indexB) - '0' : 0;
            int sum = aBitNum + bBitNum + (carry ? 1 : 0);
            carry = sum >= 2;
            resultBuilder.insert(0, sum % 2);
        }
        if (carry) {
            resultBuilder.insert(0, 1);
        }
        return resultBuilder.toString();
    }

    public static void main(String[] args) {
        String a = "11", b = "111";
        AddBinary addBinary = new AddBinary();
        System.out.println(addBinary.addBinary(a, b));
    }

}
