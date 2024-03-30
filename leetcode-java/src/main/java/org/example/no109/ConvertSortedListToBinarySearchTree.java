package org.example.no109;

import org.example.base.TreeNodeBase;

import java.util.Arrays;
import java.util.Objects;

public class ConvertSortedListToBinarySearchTree extends TreeNodeBase {

    public TreeNode sortedListToBST(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode fastPointer = head, slowPointer = head, preSlowPointer = null;
        while (Objects.nonNull(fastPointer.next) && Objects.nonNull(fastPointer.next.next)) {
            fastPointer = fastPointer.next.next;
            preSlowPointer = slowPointer;
            slowPointer = slowPointer.next;
        }
        TreeNode node = new TreeNode(slowPointer.val);
        if (Objects.nonNull(preSlowPointer)) {
            preSlowPointer.next = null;
            node.left = this.sortedListToBST(head);
        }

        if (Objects.nonNull(slowPointer.next)) {
            node.right = this.sortedListToBST(slowPointer.next);
        }

        return node;
    }

    public static void main(String[] args) {
        ListNode head = generateList(Arrays.asList(1, 2, 3, 4));
        ConvertSortedListToBinarySearchTree convertSortedListToBinarySearchTree = new ConvertSortedListToBinarySearchTree();
        TreeNode root = convertSortedListToBinarySearchTree.sortedListToBST(head);
        System.out.println(bfsWithNull(root));
    }

}
