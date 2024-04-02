package org.example.no274;

import java.util.Arrays;

public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int citationsLength = citations.length;
        int h = 0;
        for (int i = 0; i < citationsLength; i++) {
            int count = citationsLength - i;
            if (citations[i] >= count) {
                h = Math.max(h, count);
            }
        }
        return h;
    }

    public static void main(String[] args) {
        HIndex hIndex = new HIndex();
//        int[] citations = new int[]{3, 0, 6, 1, 5};
        int[] citations = new int[]{100};
        System.out.println(hIndex.hIndex(citations));
    }

}
