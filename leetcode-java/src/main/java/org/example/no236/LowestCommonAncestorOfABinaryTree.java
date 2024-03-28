package org.example.no236;

import org.example.base.TreeNodeBase;

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

    }

}
