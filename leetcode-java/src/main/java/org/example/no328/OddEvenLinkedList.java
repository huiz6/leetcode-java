package org.example.no328;

import org.example.base.ListNodeBase;

import java.util.Objects;

public class OddEvenLinkedList extends ListNodeBase {

    public ListNode oddEvenList(ListNode head) {
        ListNode oddPre = null, evenPre = null, evenHead = null, cur = head;
        boolean isOdd = true;
        while (true) {
            if (Objects.isNull(cur)) {
                break;
            }
            if (isOdd) {
                if (Objects.nonNull(oddPre)) {
                    oddPre.next = cur;
                }
                oddPre = cur;
            }
            if (!isOdd) {
                if (Objects.isNull(evenHead)) {
                    evenHead = cur;
                }
                if (Objects.nonNull(evenPre)) {
                    evenPre.next = cur;
                }
                evenPre = cur;
            }
            cur = cur.next;
            isOdd = !isOdd;
        }
        if (Objects.nonNull(oddPre)) {
            oddPre.next = evenHead;
        }
        if (Objects.nonNull(evenPre)) {
            evenPre.next = null;
        }
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
        OddEvenLinkedList oddEvenLinkedList = new OddEvenLinkedList();
        print(oddEvenLinkedList.oddEvenList(head));
    }

}
