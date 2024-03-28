package org.example.no145;

import org.example.base.TreeNodeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Stack;

public class BinaryTreePostorderTraversal2 extends TreeNodeBase {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> traversalList = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while (Objects.nonNull(cur) || !stack.isEmpty()) {
            if (Objects.nonNull(cur)) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode tmp = stack.peek();
                if (Objects.nonNull(tmp.right) && tmp.right != pre) {
                    cur = tmp.right;
                } else {
                    traversalList.add(tmp.val);
                    pre = tmp;
                    stack.pop();
                }
            }
        }
        return traversalList;
    }

    public static void main(String[] args) {
        BinaryTreePostorderTraversal2 binaryTreePostorderTraversal = new BinaryTreePostorderTraversal2();
        TreeNode root = generateTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        System.out.println(binaryTreePostorderTraversal.postorderTraversal(root));
    }
}
