package org.example.no100;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.Objects;

public class SameTree extends TreeNodeBase   {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (Objects.isNull(p) && Objects.isNull(q)) {
            return true;
        } else if (Objects.isNull(p)) {
            return false;
        } else if (Objects.isNull(q)) {
            return false;
        } else {
            if (p.val != q.val) {
                return false;
            } else {
                return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode p = generateTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        TreeNode q = generateTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        SameTree sameTree = new SameTree();
        System.out.println(sameTree.isSameTree(p, q));
    }

}
