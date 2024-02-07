package org.example.no88;


import java.util.Arrays;

public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        int[] result = new int[m + n];
        while (i != m || j != n) {
            if (i == m) {
                while (j < n) {
                    result[i + j] = nums2[j];
                    j++;
                }
                break;
            }
            if (j == n) {
                while (i < m) {
                    result[i + j] = nums1[i];
                    i++;
                }
                break;
            }
            if (nums1[i] > nums2[j]) {
                result[i + j] = nums2[j];
                j++;
            } else {
                result[i + j] = nums1[i];
                i++;
            }
        }
        System.arraycopy(result, 0, nums1, 0, m + n);
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (nums1[i - 1] > nums2[j - 1]) {
                nums1[i + j - 1] = nums1[i - 1];
                i--;
            } else {
                nums1[i + j - 1] = nums2[j - 1];
                j--;
            }
        }
        while (j > 0) {
            nums1[i + j - 1] = nums2[j - 1];
            j--;
        }
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {4, 5, 6};
        int n = 3;
        new MergeSortedArray().merge2(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

}
