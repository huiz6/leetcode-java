package org.example.no513;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class FindBottomLeftTreeValue extends TreeNodeBase {

    public int findBottomLeftValue(TreeNode root) {
        List<Integer> resList = Arrays.asList(0, root.val);
        this.traversal(root, 0, resList);
        return resList.get(1);
    }

    private void traversal(TreeNode node, int layer, List<Integer> resList) {
        if (Objects.isNull(node)) {
            return;
        }

        if (layer > resList.get(0)) {
            resList.set(0, layer);
            resList.set(1, node.val);
        }
        this.traversal(node.left, layer + 1, resList);
        this.traversal(node.right, layer + 1, resList);
    }

    public static void main(String[] args) {
        TreeNode root1 = generateTree(Arrays.asList(2, 1, 3));
        TreeNode root2 = generateTree(Arrays.asList(1, 2, 3, 4, null, 5, 6, null, null, null, null, 7));
        FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();
//        System.out.println(findBottomLeftTreeValue.findBottomLeftValue(root1));
        System.out.println(findBottomLeftTreeValue.findBottomLeftValue(root2));
    }

}
