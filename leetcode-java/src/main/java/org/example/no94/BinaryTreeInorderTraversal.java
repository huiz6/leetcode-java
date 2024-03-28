package org.example.no94;

import org.example.base.TreeNodeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class BinaryTreeInorderTraversal extends TreeNodeBase {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversalList = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (Objects.nonNull(cur) || !stack.isEmpty()) {
            while (Objects.nonNull(cur)) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            traversalList.add(cur.val);
            cur = cur.right;
        }

        return traversalList;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        TreeNode root = generateTree(Arrays.asList(1, null, 2, null, null, 3));
        System.out.println(binaryTreeInorderTraversal.inorderTraversal(root));
    }

}
