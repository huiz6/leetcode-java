package org.example.no105;

import org.example.base.TreeNodeBase;

import java.util.List;

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
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        ConstructBinaryTreeFromPreorderAndInorderTraversal constructBinaryTree = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode root = constructBinaryTree.buildTree(preorder, inorder);
        List<Integer> bfsList = bfs(root);
        System.out.println(bfsList);
    }

}
