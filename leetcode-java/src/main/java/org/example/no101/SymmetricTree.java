package org.example.no101;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SymmetricTree extends TreeNodeBase {

    public boolean isSymmetric(TreeNode root) {
        return this.isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (Objects.isNull(left) && Objects.isNull(right)) {
            return true;
        } else if (Objects.isNull(left) || Objects.isNull(right)) {
            return false;
        } else {
            if (left.val == right.val) {
                return this.isSymmetric(left.left, right.right) && this.isSymmetric(left.right, right.left);
            } else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> treeArray = Arrays.asList(1, 2, 2, 2, 3, 3, 2, 4, 1, null, null, null, null, 1, 4);
        TreeNode root = generateTree(treeArray);
        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(root));
    }

}
