package org.example.no437;

import org.example.base.TreeNodeBase;

import java.util.Objects;

public class PathSumIII extends TreeNodeBase {

    public int pathSum(TreeNode root, int targetSum) {
        if (Objects.isNull(root)) {
            return 0;
        }
        return this.helper(root, targetSum) + this.pathSum(root.left, targetSum) + this.pathSum(root.right, targetSum);
    }

    private int helper(TreeNode node, long sum) {
        if (Objects.isNull(node)) {
            return 0;
        }
        int count = node.val == sum? 1 : 0;
        count += this.helper(node.left, sum - node.val);
        count += this.helper(node.right, sum - node.val);
        return count;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(3);
//        TreeNode node3 = new TreeNode(3);
//        TreeNode node4 = new TreeNode(-2);
//        TreeNode node5 = new TreeNode(2);
//        TreeNode node6 = new TreeNode(1);
//        TreeNode node7 = new TreeNode(-3);
//        TreeNode node8 = new TreeNode(11);
//        root.left = node1;
//        root.right = node7;
//        node7.right = node8;
//        node1.left = node2;
//        node2.left = node3;
//        node2.right = node4;
//        node1.right = node5;
//        node5.right = node6;

        TreeNode root = new TreeNode(1000000000);
        TreeNode node1 = new TreeNode(1000000000);
        TreeNode node2 = new TreeNode(294967296);
        TreeNode node3 = new TreeNode(1000000000);
        TreeNode node4 = new TreeNode(1000000000);
        TreeNode node5 = new TreeNode(1000000000);
        root.left = node1;
        node1.left = node2;
        node2.left = node3;
        node3.left = node4;
        node4.left = node5;
        PathSumIII pathSumIII = new PathSumIII();
        System.out.println(pathSumIII.pathSum(root, 0));
    }

}
