package org.example.no104;

import org.example.base.TreeNodeBase;

import java.util.Objects;

public class MaximumDepthOfBinaryTree extends TreeNodeBase {

    public int maxDepth(TreeNode root) {
        if (Objects.isNull(root)) {
            return 0;
        } else {
            return 1 + Integer.max(this.maxDepth(root.left), this.maxDepth(root.right));
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        MaximumDepthOfBinaryTree maximumDepthOfBinaryTree = new MaximumDepthOfBinaryTree();
        int maxDepth = maximumDepthOfBinaryTree.maxDepth(root);
        System.out.println(maxDepth);

    }

}
