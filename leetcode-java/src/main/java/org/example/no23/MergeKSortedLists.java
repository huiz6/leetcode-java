package org.example.no23;

import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(
                Comparator.comparing(o -> o.val)
        );
        for (ListNode node : lists) {
            while (Objects.nonNull(node)) {
                priorityQueue.add(node);
                node = node.next;
            }
        }
        ListNode zero = new ListNode(0);
        ListNode cur = zero;
        while (!priorityQueue.isEmpty()) {
            cur.next = priorityQueue.poll();
            cur = cur.next;
        }
        cur.next = null;
        return zero.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-2);
        ListNode node2 = new ListNode(-1);
        ListNode node3 = new ListNode(-1);
        ListNode node4 = new ListNode(-1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode[] lists = new ListNode[]{node1};

        new MergeKSortedLists().mergeKLists(lists);
    }

}
