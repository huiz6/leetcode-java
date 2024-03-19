package org.example.no21;

import java.util.Objects;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (Objects.isNull(list1)) {
            return list2;
        }
        if (Objects.isNull(list2)) {
            return list1;
        }
        ListNode head = null, pre = null;
        while (Objects.nonNull(list1) || Objects.nonNull(list2)) {
            if (Objects.isNull(list1)) {
                pre.next = list2;
                pre = list2;
                list2 = list2.next;
            } else if (Objects.isNull(list2)) {
                pre.next = list1;
                pre = list1;
                list1 = list1.next;
            } else if (list1.val <= list2.val) {
                if (Objects.isNull(head)) {
                    head = list1;
                } else {
                    pre.next = list1;
                }
                pre = list1;
                list1 = list1.next;
            } else {
                if (Objects.isNull(head)) {
                    head = list2;
                } else {
                    pre.next = list2;
                }
                pre = list2;
                list2 = list2.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(3);
        ListNode node14 = new ListNode(4);
        ListNode node15 = new ListNode(5);
        head1.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
        node14.next = node15;

        ListNode head2 = new ListNode(0);
        ListNode node21 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node23 = new ListNode(3);
        ListNode node24 = new ListNode(4);
        ListNode node25 = new ListNode(5);
        head2.next = node21;
        node21.next = node22;
        node22.next = node23;
        node23.next = node24;
        node24.next = node25;
        printList(head1);
        printList(head2);
        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode mergedHead = mergeTwoSortedLists.mergeTwoLists(head1, head2);
        printList(mergedHead);
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
