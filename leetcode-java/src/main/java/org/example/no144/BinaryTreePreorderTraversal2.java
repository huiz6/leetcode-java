package org.example.no144;

import org.example.base.TreeNodeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class BinaryTreePreorderTraversal2 extends TreeNodeBase {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> traversalList = new ArrayList<>();
        if (Objects.isNull(root)) {
            return traversalList;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            traversalList.add(node.val);
            if (Objects.nonNull(node.right)) {
                stack.push(node.right);
            }
            if (Objects.nonNull(node.left)) {
                stack.push(node.left);
            }
        }
        return traversalList;
    }

    public static void main(String[] args) {
        TreeNode root = generateTree(Arrays.asList(3, 1, 2));
        List<Integer> traversalList = new BinaryTreePreorderTraversal2().preorderTraversal(root);
        System.out.println(traversalList);
    }
}
