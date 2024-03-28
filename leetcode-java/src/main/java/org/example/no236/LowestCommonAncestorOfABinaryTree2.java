package org.example.no236;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

public class LowestCommonAncestorOfABinaryTree2 extends TreeNodeBase {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root, null);
        while (!parentMap.containsKey(p) || !parentMap.containsKey(q)) {
            TreeNode node = stack.pop();
            if (Objects.nonNull(node.left)) {
                stack.push(node.left);
                parentMap.put(node.left, node);
            }

            if (Objects.nonNull(node.right)) {
                stack.push(node.right);
                parentMap.put(node.right, node);
            }
        }

        Set<TreeNode> path = new HashSet<>();
        while (Objects.nonNull(p)) {
            path.add(p);
            p = parentMap.get(p);
        }

        while (Objects.nonNull(q) ) {
            if (path.contains(q)) {
                break;
            }
            q = parentMap.get(q);
        }
        return q;
    }

    public static void main(String[] args) {
        TreeNode root = generateTree(Arrays.asList(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4));
        LowestCommonAncestorOfABinaryTree2 lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree2();
        TreeNode p1 = new TreeNode(5);
        TreeNode q1 = new TreeNode(1);
        System.out.println(lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(root, p1, q1));

        TreeNode p2 = new TreeNode(6);
        TreeNode q2 = new TreeNode(7);
        System.out.println(lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(root, p2, q2));

    }

}
