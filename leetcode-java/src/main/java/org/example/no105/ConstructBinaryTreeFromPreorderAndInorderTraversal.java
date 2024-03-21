package org.example.no105;

import org.example.base.TreeNodeBase;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal extends TreeNodeBase {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1 && inorder.length == 1) {
            return root;
        }
        int rootIndex = 0;
        for (; rootIndex < inorder.length; rootIndex++) {
            if (inorder[rootIndex] == preorder[0]) {
                break;
            }
        }
        if (rootIndex - 1 >= 0) {
            int[] leftPreorder = new int[rootIndex];
            int[] leftInorder = new int[rootIndex];
            for (int i = 0; i < leftPreorder.length; i++) {
                leftPreorder[i] = preorder[i + 1];
                leftInorder[i] = inorder[i];
            }
            root.left = this.buildTree(leftPreorder, leftInorder);
        }

        if (rootIndex + 1 < inorder.length) {
            int[] rightPreorder = new int[inorder.length - rootIndex - 1];
            int[] rightInorder = new int[inorder.length - rootIndex - 1];
            for (int i = rootIndex + 1; i < inorder.length; i++) {
                rightPreorder[i - rootIndex - 1] = preorder[i];
                rightInorder[i - rootIndex - 1] = inorder[i];
            }
            root.right = this.buildTree(rightPreorder, rightInorder);
        }
        return root;

    }

    public static void main(String[] args) {

    }

}
