package org.example.no100;

import org.example.base.TreeNodeBase.TreeNode;

import java.util.Objects;

public class SameTree {

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

    }

}
