package org.example.no889;

import org.example.base.TreeNodeBase;

public class ConstructBinaryTreeFromPreorderAndPostorderTraversal extends TreeNodeBase {

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int length = preorder.length;
        if (length == 0) {
            return null;
        }
        if (length == 1) {
            return new TreeNode(preorder[0]);
        }
        TreeNode root = new TreeNode(preorder[0]);
        int leftRoot = preorder[1];
        int postOrderIndex = 0;
        for (; postOrderIndex < length; postOrderIndex++) {
            if (postorder[postOrderIndex] == leftRoot) {
                break;
            }
        }
        int leftLength = postOrderIndex + 1;
        int[] leftPreOrder = new int[leftLength];
        int[] leftPostOrder = new int[leftLength];
        int[] rightPreOrder = new int[length - leftLength - 1];
        int[] rightPostOrder = new int[length - leftLength - 1];
        for (int i = 0; i < length; i++) {
            if (i < leftLength + 1 && i > 0) {
                leftPreOrder[i - 1] = preorder[i];
            }
            if (i < leftLength) {
                leftPostOrder[i] = postorder[i];
            }
            if (i >= leftLength + 1) {
                rightPreOrder[i - leftLength - 1] = preorder[i];
            }
            if (i >= leftLength && i < length - 1) {
                rightPostOrder[i - leftLength] = postorder[i];
            }
        }
        root.left = this.constructFromPrePost(leftPreOrder, leftPostOrder);
        root.right = this.constructFromPrePost(rightPreOrder, rightPostOrder);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndPostorderTraversal constructTree = new ConstructBinaryTreeFromPreorderAndPostorderTraversal();
        int[] preorder = new int[]{1, 2, 4, 5, 3, 6, 7};
        int[] postorder = new int[]{4, 5, 2, 6, 7, 3, 1};
        TreeNode root = constructTree.constructFromPrePost(preorder, postorder);
        System.out.println(bfsWithNull(root));
    }

}
