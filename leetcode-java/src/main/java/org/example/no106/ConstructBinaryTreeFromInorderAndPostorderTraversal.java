package org.example.no106;

import org.example.base.TreeNodeBase;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal extends TreeNodeBase {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int length = inorder.length;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return new TreeNode(postorder[0]);
        }

        int rootVal = postorder[length - 1];
        TreeNode root = new TreeNode(rootVal);
        int inorderIndex = 0;
        for (; inorderIndex < length; inorderIndex++) {
            if (inorder[inorderIndex] == rootVal) {
                break;
            }
        }

        int leftLength = inorderIndex;
        int[] leftInorder = new int[leftLength];
        int[] leftPostorder = new int[leftLength];
        int[] rightInorder = new int[length - leftLength - 1];
        int[] rightPostorder = new int[length - leftLength - 1];
        for (int i = 0; i < length; i++) {
            if (i < leftLength) {
                leftInorder[i] = inorder[i];
                leftPostorder[i] = postorder[i];
            }

            if (i > leftLength) {
                rightInorder[i - leftLength - 1] = inorder[i];
            }

            if (i >= leftLength && i < length - 1) {
                rightPostorder[i - leftLength] = postorder[i];
            }
        }

        root.left = this.buildTree(leftInorder, leftPostorder);
        root.right = this.buildTree(rightInorder, rightPostorder);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        ConstructBinaryTreeFromInorderAndPostorderTraversal constructBinaryTree = new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode root = constructBinaryTree.buildTree(inorder, postorder);
        System.out.println(bfsWithNull(root));
    }

}
