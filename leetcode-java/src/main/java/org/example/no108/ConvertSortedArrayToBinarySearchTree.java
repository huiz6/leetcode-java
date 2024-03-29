package org.example.no108;

import org.example.base.TreeNodeBase;

public class ConvertSortedArrayToBinarySearchTree extends TreeNodeBase {

    public TreeNode sortedArrayToBST(int[] nums) {
        return this.sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        if (left != right) {
            node.left = this.sortedArrayToBST(nums, left, mid - 1);
            node.right = this.sortedArrayToBST(nums, mid + 1, right);
        }
        return node;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();
        int[] nums1 = new int[]{1, 3};
        System.out.println(bfsWithNull(convertSortedArrayToBinarySearchTree.sortedArrayToBST(nums1)));
        int[] nums2 = new int[]{-10, -3, 0, 5, 9};
        System.out.println(bfsWithNull(convertSortedArrayToBinarySearchTree.sortedArrayToBST(nums2)));
    }

}
