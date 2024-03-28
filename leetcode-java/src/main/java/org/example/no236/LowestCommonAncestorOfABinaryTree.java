package org.example.no236;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.Objects;

public class LowestCommonAncestorOfABinaryTree extends TreeNodeBase {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (Objects.isNull(root) || p.equals(root) || q.equals(root)) {
            return root;
        }

        TreeNode leftLowestCommonAncestor = this.lowestCommonAncestor(root.left, p, q);
        TreeNode rightLowestCommonAncestor = this.lowestCommonAncestor(root.right, p, q);

        if (Objects.isNull(leftLowestCommonAncestor)) {
            return rightLowestCommonAncestor;
        }
        if (Objects.isNull(rightLowestCommonAncestor)) {
            return leftLowestCommonAncestor;
        }

        return root;
    }

    public static void main(String[] args) {
        TreeNode root = generateTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        LowestCommonAncestorOfABinaryTree lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree();
        TreeNode p1 = new TreeNode(5);
        TreeNode q1 = new TreeNode(1);
        System.out.println(lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(root, p1, q1));

        TreeNode p2 = new TreeNode(6);
        TreeNode q2 = new TreeNode(7);
        System.out.println(lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(root, p2, q2));
    }

}
