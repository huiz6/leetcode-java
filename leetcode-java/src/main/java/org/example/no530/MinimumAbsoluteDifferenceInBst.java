package org.example.no530;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.Objects;

public class MinimumAbsoluteDifferenceInBst extends TreeNodeBase {

    private int minimumAbsoluteDifference;
    private Integer preValue;

    public int getMinimumDifference(TreeNode root) {
        this.minimumAbsoluteDifference = Integer.MAX_VALUE;
        this.preValue = null;
        this.preorderTraversal(root);
        return this.minimumAbsoluteDifference;
    }

    private void preorderTraversal(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }
        this.preorderTraversal(node.left);
        if (Objects.nonNull(this.preValue)) {
            this.minimumAbsoluteDifference = Math.min(this.minimumAbsoluteDifference, node.val - this.preValue);
        }
        this.preValue = node.val;
        this.preorderTraversal(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = generateTree(Arrays.asList(4, 2, 6, 1, 3));
        MinimumAbsoluteDifferenceInBst minimumAbsoluteDifferenceInBst = new MinimumAbsoluteDifferenceInBst();
        System.out.println(minimumAbsoluteDifferenceInBst.getMinimumDifference(root));
    }

}
