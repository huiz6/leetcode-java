package org.example.no450;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.Objects;

public class DeleteNodeInABST extends TreeNodeBase {

    public TreeNode deleteNode(TreeNode root, int key) {
        if (Objects.isNull(root)) {
            return null;
        }
        if (root.val > key) {
            root.left = this.deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = this.deleteNode(root.right, key);
        } else {
            if (Objects.nonNull(root.left)) {
                int max = this.getMaxAndDelete(root.left);
                if (max == root.left.val) {
                    root.left = root.left.left;
                }
                root.val = max;

            } else if (Objects.nonNull(root.right)) {
                int min = this.getMinAndDelete(root.right);
                if (min == root.right.val) {
                    root.right = root.right.right;
                }
                root.val = min;
            } else {
                root = null;
            }
        }
        return root;
    }

    private int getMaxAndDelete(TreeNode node) {
        if (Objects.isNull(node.right)) {
            return node.val;
        }
        if (Objects.isNull(node.right.right)) {
            int max = node.right.val;
            node.right = node.right.left;
            return max;
        } else {
            return this.getMaxAndDelete(node.right);
        }
    }


    private int getMinAndDelete(TreeNode node) {
        if (Objects.isNull(node.left)) {
            return node.val;
        }
        if (Objects.isNull(node.left.left)) {
            int min = node.left.val;
            node.left = node.left.right;
            return min;
        } else {
            return this.getMinAndDelete(node.left);
        }
    }

    public static void main(String[] args) {
        DeleteNodeInABST deleteNodeInABST = new DeleteNodeInABST();
        TreeNode root = generateTree(Arrays.asList(5, 3, 6, 2, null, null, 7));
        root = deleteNodeInABST.deleteNode(root, 5);
        System.out.println(bfsWithNull(root));
    }

}
