package org.example.no274;

public class HIndex2 {

    public int hIndex(int[] citations) {
        int citationsLength = citations.length;
        int[] bucket = new int[citationsLength + 1];
        for (int citation : citations) {
            if (citation > citationsLength) {
                bucket[citationsLength]++;
            } else {
                bucket[citation]++;
            }
        }

        int count = 0;
        for (int i = citationsLength; i >= 0; i--) {
            count += bucket[i];
            if (count >= i) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        HIndex2 hIndex = new HIndex2();
        int[] citations = new int[]{1, 3, 1};
//        int[] citations = new int[]{100};
        System.out.println(hIndex.hIndex(citations));
    }

}
