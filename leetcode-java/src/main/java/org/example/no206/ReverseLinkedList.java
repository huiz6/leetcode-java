package org.example.no206;

import java.util.Objects;

public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (true) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            if (Objects.isNull(next)) {
                break;
            }
            cur = next;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        printList(head);
        ListNode reverse = new ReverseLinkedList().reverseList(head);
        printList(reverse);
    }

    public static void printList(ListNode node) {
        while (true) {
            System.out.println(node.val);
            if (Objects.isNull(node.next)) {
                break;
            } else {
                node = node.next;
            }
        }
    }

}
