package org.example.no144;

import org.example.base.TreeNodeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class BinaryTreePreorderTraversal extends TreeNodeBase {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversalList = new ArrayList<>();
        if (Objects.isNull(root)) {
            return traversalList;
        }
        this.preorderTraversal(root, traversalList);
        return traversalList;
    }

    private void preorderTraversal(TreeNode root, List<Integer> traversalList) {
        traversalList.add(root.val);
        if (Objects.nonNull(root.left)) {
            this.preorderTraversal(root.left, traversalList);
        }
        if (Objects.nonNull(root.right)) {
            this.preorderTraversal(root.right, traversalList);
        }
    }

    public static void main(String[] args) {
        TreeNode root = generateTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        List<Integer> traversalList = new BinaryTreePreorderTraversal().preorderTraversal(root);
        System.out.println(traversalList);
    }
}
