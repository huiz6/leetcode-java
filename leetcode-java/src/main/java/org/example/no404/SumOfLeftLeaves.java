package org.example.no404;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class SumOfLeftLeaves extends TreeNodeBase {

    public int sumOfLeftLeaves(TreeNode root) {
        AtomicInteger atomicSum = new AtomicInteger(0);
        this.inorderTraversal(root, atomicSum);
        return atomicSum.get();
    }

    private void inorderTraversal(TreeNode node, AtomicInteger atomicSum) {
        if (Objects.isNull(node)) {
            return;
        }
        this.inorderTraversal(node.left, atomicSum);
        if (Objects.nonNull(node.left) && Objects.isNull(node.left.left) && Objects.isNull(node.left.right)) {
            atomicSum.set(atomicSum.get() + node.left.val);
        }
        this.inorderTraversal(node.right, atomicSum);
    }

    public static void main(String[] args) {
        TreeNode root = generateTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        System.out.println(sumOfLeftLeaves.sumOfLeftLeaves(root));
    }

}
