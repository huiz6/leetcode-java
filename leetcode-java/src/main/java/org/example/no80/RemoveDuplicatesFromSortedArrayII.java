package org.example.no80;

public class RemoveDuplicatesFromSortedArrayII {

    public int removeDuplicates(int[] nums) {
        int numsLength = nums.length, cur = nums[0], num = 1, gap = 0;

        for (int index = 1; index + gap < numsLength; index++) {
            if (nums[index + gap] == cur) {
                num++;
            } else {
                cur = nums[index + gap];
                num = 1;
            }

            if (num > 2) {
                while (index + gap < numsLength && nums[index + gap] == cur) {
                    gap++;
                }

                if (index + gap < numsLength) {
                    cur = nums[index + gap];
                    num = 1;
                }
            }

            if (index + gap < numsLength) {
                nums[index] = nums[index + gap];
            }
        }
        return numsLength - gap;
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedArrayII removeDuplicatesFromSortedArrayII = new RemoveDuplicatesFromSortedArrayII();

        int[] nums = new int[]{0, 0, 1, 1, 1, 1, 2, 2, 2, 4};
        int k = removeDuplicatesFromSortedArrayII.removeDuplicates(nums);
        System.out.println(k);
        for (int i = 0; i < k; i++) {
            System.out.print(nums[i]);
            System.out.print(" ");
        }
    }

}
