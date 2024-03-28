package org.example.no145;

import org.example.base.TreeNodeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class BinaryTreePostorderTraversal extends TreeNodeBase {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversalList = new ArrayList<>();
        Set<TreeNode> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (Objects.nonNull(cur) || !stack.isEmpty()) {
            while (Objects.nonNull(cur) && !set.contains(cur)) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.peek();
            if (Objects.isNull(cur.right) || set.contains(cur)) {
                traversalList.add(cur.val);
                set.add(cur);
                stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                cur = stack.peek();
                cur = cur.right;
            } else {
                set.add(cur);
                cur = cur.right;
            }
        }
        return traversalList;
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal binaryTreePostorderTraversal = new BinaryTreePostorderTraversal();
        TreeNode root = generateTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(binaryTreePostorderTraversal.postorderTraversal(root));
    }
}
