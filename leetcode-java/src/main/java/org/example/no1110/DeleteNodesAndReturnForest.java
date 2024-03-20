package org.example.no1110;

import org.example.base.TreeNodeBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class DeleteNodesAndReturnForest extends TreeNodeBase {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDeleteSet = Arrays.stream(to_delete)
                .boxed()
                .collect(Collectors.toSet());
        List<TreeNode> forest = new ArrayList<>();
        TreeNode node = this.helper(root, toDeleteSet, forest);
        if (Objects.nonNull(node)) {
            forest.add(node);
        }
        return forest;
    }

    private TreeNode helper(TreeNode node, Set<Integer> toDeleteSet, List<TreeNode> forest) {
        if (Objects.isNull(node)) {
            return node;
        }
        node.left = this.helper(node.left, toDeleteSet, forest);
        node.right = this.helper(node.right, toDeleteSet, forest);
        if (toDeleteSet.contains(node.val)) {
            if (Objects.nonNull(node.left)) {
                forest.add(node.left);
            }
            if (Objects.nonNull(node.right)) {
                forest.add(node.right);
            }
            node = null;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = generateTree(Arrays.asList(1, 2, 3, 4, 5, 6, 7));
        DeleteNodesAndReturnForest deleteNodesAndReturnForest = new DeleteNodesAndReturnForest();
        int[] toDelete = new int[]{3, 5};
        List<TreeNode> forest = deleteNodesAndReturnForest.delNodes(root, toDelete);
        for (TreeNode eachRoot : forest) {
            System.out.println(eachRoot.val);
        }
    }

}
