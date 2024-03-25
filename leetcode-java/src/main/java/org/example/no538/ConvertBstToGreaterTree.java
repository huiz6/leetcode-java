package org.example.no538;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.Objects;

public class ConvertBstToGreaterTree extends TreeNodeBase {

    private int sum;

    public TreeNode convertBST(TreeNode root) {
        this.sum = 0;
        this.traversal(root);
        return root;
    }

    private void traversal(TreeNode node) {
        if (Objects.isNull(node)) {
            return;
        }

        this.traversal(node.right);
        node.val = node.val + sum;
        this.sum = node.val;
        this.traversal(node.left);

    }

    public static void main(String[] args) {
        TreeNode root = generateTree(Arrays.asList(4, 1, 6, 0, 2, 5, 7, null, null, null, 3, null, null, null, 8));
        ConvertBstToGreaterTree convertBstToGreaterTree = new ConvertBstToGreaterTree();
        root = convertBstToGreaterTree.convertBST(root);
        System.out.println(bfsWithNull(root));
    }

}
