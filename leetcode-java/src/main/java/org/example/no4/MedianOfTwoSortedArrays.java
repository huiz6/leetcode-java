package org.example.no4;

public class MedianOfTwoSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mid1 = (nums1.length + nums2.length + 1) / 2;
        int mid2 = (nums1.length + nums2.length + 2) / 2;
        return (getKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, mid1) +
        getKth(nums1, 0, nums1.length - 1, nums2, 0, nums2.length - 1, mid2)) * 0.5;
    }

    private int getKth(int[] nums1, int l1, int r1, int[] nums2, int l2, int r2, int k) {
        int len1 = r1 - l1 + 1;
        int len2 = r2 - l2 + 1;
        if (len1 > len2) {
            return getKth(nums2, l2, r2, nums1, l1, r1, k);
        }
        if (len1 == 0) {
            return nums2[l2 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[l1], nums2[l2]);
        }
        int i = l1 + Math.min(len1, k / 2) - 1;
        int j = l2 + Math.min(len2, k / 2) - 1;
        if (nums1[i] > nums2[j]) {
            return getKth(nums1, l1, r1, nums2, j + 1, r2, k - (j - l2 + 1));
        } else {
            return getKth(nums1, i + 1, r1, nums2, l2, r2, k - (i - l1 + 1));
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2};
        int[] nums2 = new int[]{3, 4};
        System.out.println(new MedianOfTwoSortedArrays().findMedianSortedArrays(nums1, nums2));
    }

}
