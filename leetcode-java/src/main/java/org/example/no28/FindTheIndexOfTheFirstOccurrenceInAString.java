package org.example.no28;

public class FindTheIndexOfTheFirstOccurrenceInAString {

    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int[] partialMatchArray = this.generatePartialMatchArray(needle);
        int haystackPointer = 0, matchLength = 0;
        while (haystackPointer <= haystack.length() - needle.length()) {
//            String haystackSub = haystack.substring(haystackPointer, haystackPointer + matchLength + 1);
//            String needleSub = needle.substring(0, matchLength + 1);

            char h = haystack.charAt(haystackPointer + matchLength);
            char n = needle.charAt(matchLength);
            if (h == n) {
                matchLength++;
            } else {
                if (matchLength == 0) {
                    haystackPointer++;
                } else {
                    haystackPointer += matchLength - partialMatchArray[matchLength - 1];
                    matchLength = partialMatchArray[matchLength - 1];
                }
            }
            if (matchLength == needle.length()) {
                return haystackPointer;
            }
        }
        return -1;
    }

    private int[] generatePartialMatchArray(String needle) {
        int[] partialMatchArray = new int[needle.length()];
        for (int i = 0; i < needle.length(); i++) {
            String subString = needle.substring(0, i + 1);
            int match = 0, step = 0;
            while (step < i) {
                String prefix = subString.substring(0, step + 1);
                String suffix = subString.substring(i - step);
                if (prefix.equals(suffix)) {
                    match = prefix.length();
                }
                step++;
            }
            partialMatchArray[i] = match;
        }
        return partialMatchArray;

    }

    public static void main(String[] args) {
        FindTheIndexOfTheFirstOccurrenceInAString findTheIndexOfTheFirstOccurrenceInAString = new FindTheIndexOfTheFirstOccurrenceInAString();
        System.out.println(findTheIndexOfTheFirstOccurrenceInAString.strStr("a", "a"));
        System.out.println(findTheIndexOfTheFirstOccurrenceInAString.strStr("mississippi", "issippi"));
        System.out.println(findTheIndexOfTheFirstOccurrenceInAString.strStr("BBC ABCDAB ABCDABCDABDE", "ABCDABD"));
        System.out.println(findTheIndexOfTheFirstOccurrenceInAString.strStr("sadbutsad", "sad"));
        System.out.println(findTheIndexOfTheFirstOccurrenceInAString.strStr("leetcode", "leeto"));
    }

}
