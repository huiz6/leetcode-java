package org.example.no257;

import org.example.base.TreeNodeBase;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryTreePaths extends TreeNodeBase {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> path = new ArrayList<>();
        List<String> allPathList = new ArrayList<>();
        this.dfs(root, path, allPathList);
        return allPathList;
    }

    private void dfs(TreeNode node, List<String> path, List<String> allPathList) {
        path.add(String.valueOf(node.val));
        if (Objects.isNull(node.left) && Objects.isNull(node.right)) {
            allPathList.add(String.join("->", path));
            return;
        }
        if (Objects.nonNull(node.left)) {
            this.dfs(node.left, path, allPathList);
            path.remove(path.size() - 1);
        }
        if (Objects.nonNull(node.right)) {
            this.dfs(node.right, path, allPathList);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        List<String> resultList = new BinaryTreePaths().binaryTreePaths(node1);
        System.out.println(resultList.toString());

    }

}
