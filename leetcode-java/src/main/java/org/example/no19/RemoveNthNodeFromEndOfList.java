package org.example.no19;

import org.example.base.ListNodeBase;

import java.util.Objects;

public class RemoveNthNodeFromEndOfList extends ListNodeBase {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode front = head;
        for (int i = 0; i < n; i++) {
            front = front.next;
        }
        if (Objects.isNull(front)) {
            return head.next;
        }
        ListNode behind = head;
        while (Objects.nonNull(front.next)) {
            front = front.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(7);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        print(removeNthNodeFromEndOfList.removeNthFromEnd(head, 2));
    }

}
