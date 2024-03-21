package org.example.no669;

import org.example.base.TreeNodeBase;

import java.util.Objects;

public class TrimABinarySearchTree extends TreeNodeBase {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (Objects.isNull(root)) {
            return null;
        }

        if (root.val < low) {
            return this.trimBST(root.right, low, high);
        }

        if (root.val > high) {
            return this.trimBST(root.left, low, high);
        }

        root.left = this.trimBST(root.left, low, high);
        root.right = this.trimBST(root.right, low, high);
        return root;
    }

    public static void main(String[] args) {

    }

}
