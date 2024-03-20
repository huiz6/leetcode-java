package org.example.base;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class TreeNodeBase {

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode() {
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static TreeNode generateTree(List<Integer> arrayList) {
        if (arrayList.isEmpty()) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(arrayList.get(0));
        queue.add(root);
        int index = 1;
        int layer = 1;
        boolean left = true;
        TreeNode father = null;
        while (index < arrayList.size()) {
            if (index < Math.pow(2, layer + 1) - 1) {
                if (left) {
                    father = queue.poll();
                }
                Integer val = arrayList.get(index++);
                TreeNode leaf = Objects.nonNull(val) ? new TreeNode(val) : null;
                if (Objects.nonNull(father)) {
                    if (left) {
                        father.left = leaf;
                    } else {
                        father.right = leaf;
                    }
                }
                left = !left;
                queue.add(leaf);
            } else {
                layer++;
            }
        }
        return root;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(0, 1, null, 3, 4, null, null, 7);
        TreeNode root = generateTree(arrayList);
        System.out.println(root);
    }

}
