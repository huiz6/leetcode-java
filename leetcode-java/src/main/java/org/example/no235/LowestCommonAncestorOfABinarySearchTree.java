package org.example.no235;

import org.example.base.TreeNodeBase;

public class LowestCommonAncestorOfABinarySearchTree extends TreeNodeBase {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val >= p.val && root.val <= q.val) || (root.val <= p.val && root.val >= q.val)) {
            return root;
        } else if (root.val > p.val && root.val > q.val) {
            return this.lowestCommonAncestor(root.left, p, q);
        } else {
            return this.lowestCommonAncestor(root.right, p, q);
        }
    }

    public static void main(String[] args) {

    }

}
