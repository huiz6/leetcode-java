package org.example.no168;

public class ExcelSheetColumnTitle {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();

        while (columnNumber != 0) {
            int remainder = columnNumber % 26;
            columnNumber /= 26;
            if (remainder == 0) {
                remainder = 26;
                columnNumber -= 1;
            }
            sb.insert(0, (char) ('A' - 1 + remainder));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(701));
    }

}
