package org.example.no572;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.Objects;

public class SubtreeOfAnotherTree extends TreeNodeBase {

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (Objects.isNull(root) && Objects.isNull(subRoot)) {
            return true;
        } else if (Objects.isNull(root) || Objects.isNull(subRoot)) {
            return false;
        } else {
            if (root.val != subRoot.val) {
                return this.isSubtree(root.left, subRoot) || this.isSubtree(root.right, subRoot);
            } else {
                return this.isSame(root, subRoot) || this.isSubtree(root.left, subRoot) || this.isSubtree(root.right, subRoot);
            }
        }
    }

    private boolean isSame(TreeNode node1, TreeNode node2) {
        if (Objects.isNull(node1) && Objects.isNull(node2)) {
            return true;
        } else if (Objects.isNull(node1) || Objects.isNull(node2)) {
            return false;
        } else {
            return node1.val == node2.val && this.isSame(node1.left, node2.left) && this.isSame(node1.right, node2.right);
        }
    }

    public static void main(String[] args) {
        TreeNode roo1 = generateTree(Arrays.asList(3, 4, 5, 1, null, 2));
        TreeNode roo2 = generateTree(Arrays.asList(3, 1, 2));
        SubtreeOfAnotherTree subtreeOfAnotherTree = new SubtreeOfAnotherTree();
        System.out.println(subtreeOfAnotherTree.isSubtree(roo1, roo2));
    }
}
