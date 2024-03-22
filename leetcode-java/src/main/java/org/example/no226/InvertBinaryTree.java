package org.example.no226;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class InvertBinaryTree extends TreeNodeBase {

    public TreeNode invertTree(TreeNode root) {
        if (Objects.isNull(root)) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = this.invertTree(root.right);
        root.right = this.invertTree(tmp);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = generateTree(Arrays.asList(4, 2, 7, 1, 3, 6, 9));
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode invertRoot = invertBinaryTree.invertTree(root);
        List<Integer> bfsList = bfs(invertRoot);
        System.out.println(bfsList);
    }

}
