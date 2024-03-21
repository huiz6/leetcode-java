package org.example.no99;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RecoverBinarySearchTree extends TreeNodeBase {

    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        TreeNode[] mistakeArray = new TreeNode[]{null, null};
        this.inorderTraversal(root, mistakeArray, pre);
        if (Objects.nonNull(mistakeArray[0]) && Objects.nonNull(mistakeArray[1])) {
            int tmp = mistakeArray[0].val;
            mistakeArray[0].val = mistakeArray[1].val;
            mistakeArray[1].val = tmp;
        }
    }

    private void inorderTraversal(TreeNode node, TreeNode[] mistakeArray, TreeNode pre) {
        if (Objects.isNull(node)) {
            return;
        }

        if (Objects.nonNull(node.left)) {
            this.inorderTraversal(node.left, mistakeArray, pre);
        }

        if (Objects.nonNull(pre) && pre.val > node.val) {
            if (Objects.isNull(mistakeArray[0])) {
                mistakeArray[0] = pre;
                mistakeArray[1] = node;
            } else {
                mistakeArray[1] = node;
            }
        }
        pre = node;

        if (Objects.nonNull(node.right)) {
            this.inorderTraversal(node.right, mistakeArray, pre);
        }
    }

    public static void main(String[] args) {
        TreeNode root = generateTree(Arrays.asList(1, 3, null, null, 2));
        RecoverBinarySearchTree recoverBinarySearchTree = new RecoverBinarySearchTree();
        recoverBinarySearchTree.recoverTree(root);
        List<Integer> bfsList = bfs(root);
        System.out.println(bfsList);
    }

}
