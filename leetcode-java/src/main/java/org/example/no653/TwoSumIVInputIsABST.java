package org.example.no653;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class TwoSumIVInputIsABST extends TreeNodeBase {

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return this.findTarget(root, set, k);
    }

    private boolean findTarget(TreeNode node, Set<Integer> set, int k) {
        if (Objects.isNull(node)) {
            return false;
        }
        if (set.contains(k - node.val)) {
            return true;
        }
        set.add(node.val);
        return this.findTarget(node.left, set, k) || this.findTarget(node.right, set, k);
    }

    public static void main(String[] args) {
        TwoSumIVInputIsABST twoSumIVInputIsABST = new TwoSumIVInputIsABST();
        TreeNode root = generateTree(Arrays.asList(5, 3, 6, 2, 4, null, 7));
        System.out.println(twoSumIVInputIsABST.findTarget(root, 9));
        System.out.println(twoSumIVInputIsABST.findTarget(root, 28));
    }

}
