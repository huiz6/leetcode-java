package org.example.base;

import java.util.ArrayList;
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

        @Override
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof TreeNode)) {
                return false;
            }

            TreeNode node = (TreeNode) o;
            return this.val == node.val;
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

    public static List<Integer> bfs(TreeNode root) {
        List<Integer> bfsList = new ArrayList<>();
        if (Objects.isNull(root)) {
            return bfsList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.poll();
                bfsList.add(node.val);
                if (Objects.nonNull(node.left)) {
                    queue.add(node.left);
                }
                if (Objects.nonNull(node.right)) {
                    queue.add(node.right);
                }
            }
        }
        return bfsList;
    }

    public static List<Integer> bfsWithNull(TreeNode root) {
        List<Integer> bfsList = new ArrayList<>();
        if (Objects.isNull(root)) {
            return bfsList;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> layerQueue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            boolean layerNotNull = false;
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                layerNotNull |= Objects.nonNull(node);
                layerQueue.add(node);
            }
            if (!layerNotNull) {
                break;
            }
            while (!layerQueue.isEmpty()){
                TreeNode node = layerQueue.poll();
                bfsList.add(Objects.isNull(node) ? null : node.val);
                queue.add(Objects.isNull(node) ? null : node.left);
                queue.add(Objects.isNull(node) ? null : node.right);
            }
        }
        return bfsList;
    }

    public static void main(String[] args) {
        List<Integer> arrayList = Arrays.asList(0, 1, null, 3, 4, null, null, 7);
        TreeNode root = generateTree(arrayList);

        System.out.println(bfs(root));
        System.out.println(bfsWithNull(root));
    }

}
