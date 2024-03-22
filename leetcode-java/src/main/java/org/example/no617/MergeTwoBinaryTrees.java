package org.example.no617;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.Objects;

public class MergeTwoBinaryTrees extends TreeNodeBase {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode node = null;
        if (Objects.nonNull(root1) && Objects.isNull(root2)) {
            node = new TreeNode(root1.val);
            node.left = this.mergeTrees(root1.left, null);
            node.right = this.mergeTrees(root1.right, null);
        } else if (Objects.isNull(root1) && Objects.nonNull(root2)) {
            node = new TreeNode(root2.val);
            node.left = this.mergeTrees(root2.left, null);
            node.right = this.mergeTrees(root2.right, null);
        } else if (Objects.nonNull(root1)) {
            node = new TreeNode(root1.val + root2.val);
            node.left = this.mergeTrees(root1.left, root2.left);
            node.right = this.mergeTrees(root1.right, root2.right);
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root1 = generateTree(Arrays.asList(1, 3, 2, 5));
        TreeNode root2 = generateTree(Arrays.asList(2, 1, 3, null, 4, null, 7));
        MergeTwoBinaryTrees mergeTwoBinaryTrees = new MergeTwoBinaryTrees();
        TreeNode mergeRoot = mergeTwoBinaryTrees.mergeTrees(root1, root2);
        System.out.println(bfsWithNull(mergeRoot));
    }

}
