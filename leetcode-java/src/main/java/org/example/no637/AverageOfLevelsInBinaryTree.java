package org.example.no637;

import org.example.base.TreeNodeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class AverageOfLevelsInBinaryTree extends TreeNodeBase {

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> levelAverageList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            double layerSum = 0;
            for (int i = 0; i < layerSize; i++) {
                TreeNode node = queue.poll();
                if (Objects.nonNull(node)) {
                    layerSum += node.val;
                    if (Objects.nonNull(node.left)) {
                        queue.add(node.left);
                    }
                    if (Objects.nonNull(node.right)) {
                        queue.add(node.right);
                    }
                }
            }
            levelAverageList.add(layerSum / layerSize);
        }
        return levelAverageList;
    }

    public static void main(String[] args) {
        AverageOfLevelsInBinaryTree averageOfLevelsInBinaryTree = new AverageOfLevelsInBinaryTree();
        TreeNode root1 = generateTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
        List<Double> levelAverageList1 = averageOfLevelsInBinaryTree.averageOfLevels(root1);
        System.out.println(levelAverageList1.toString());

        TreeNode root2 = generateTree(Arrays.asList(3, 9, 20, 15, 7));
        List<Double> levelAverageList2 = averageOfLevelsInBinaryTree.averageOfLevels(root2);
        System.out.println(levelAverageList2.toString());
    }

}
