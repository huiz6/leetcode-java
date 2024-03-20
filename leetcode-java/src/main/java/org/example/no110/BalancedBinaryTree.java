package org.example.no110;

import org.example.base.TreeNodeBase;

import java.util.Objects;

public class BalancedBinaryTree extends TreeNodeBase {

    public boolean isBalanced(TreeNode root) {
        return this.helper(root) != -1;
    }

    private int helper(TreeNode node) {
        if (Objects.isNull(node)) {
            return 0;
        }
        int left = this.helper(node.left);
        int right = this.helper(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

    }

}
