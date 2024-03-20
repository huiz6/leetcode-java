package org.example.no543;

import org.example.base.TreeNodeBase;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class DiameterOfBinaryTree extends TreeNodeBase {

    public int diameterOfBinaryTree(TreeNode root) {
        AtomicInteger diameter = new AtomicInteger(0);
        this.helper(root, diameter);
        return diameter.get();
    }

    private int helper(TreeNode node, AtomicInteger diameter) {
        if (Objects.isNull(node)) {
            return 0;
        }
        int left = this.helper(node.left, diameter);
        int right = this.helper(node.right, diameter);
        diameter.set(Math.max(diameter.get(), left + right));
        return Math.max(left, right) + 1;
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
        DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();
        System.out.println(diameterOfBinaryTree.diameterOfBinaryTree(root));
    }

}
