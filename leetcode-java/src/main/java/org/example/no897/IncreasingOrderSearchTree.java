package org.example.no897;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.Objects;

public class IncreasingOrderSearchTree extends TreeNodeBase {

    public TreeNode increasingBST(TreeNode root) {
        TreeNode[] nodeArray = new TreeNode[]{null, null};
        this.inorderTraversal(root, nodeArray);
        nodeArray[1].left = null;
        return nodeArray[0];
    }

    private void inorderTraversal(TreeNode node, TreeNode[] nodeArray) {
        if (Objects.isNull(node)) {
            return;
        }
        this.inorderTraversal(node.left, nodeArray);

        if (Objects.isNull(nodeArray[0])) {
            nodeArray[0] = node;
        }

        TreeNode pre = nodeArray[1];
        if (Objects.nonNull(pre)) {
            pre.right = node;
            pre.left = null;
        }
        nodeArray[1] = node;
        this.inorderTraversal(node.right, nodeArray);
    }

    public static void main(String[] args) {
        TreeNode root = generateTree(Arrays.asList(2, 1, 4, null, null, 3));
        IncreasingOrderSearchTree increasingOrderSearchTree = new IncreasingOrderSearchTree();
        TreeNode newRoot = increasingOrderSearchTree.increasingBST(root);
        System.out.println(bfs(newRoot));
    }

}
