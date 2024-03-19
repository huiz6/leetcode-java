package org.example.no148;

import org.example.base.ListNodeBase;

import java.util.Objects;

public class SortList extends ListNodeBase {

    public ListNode sortList(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        if (Objects.isNull(head.next.next)) {
            ListNode sortedHead;
            if (head.val > head.next.val) {
                sortedHead = head.next;
                sortedHead.next = head;
                head.next = null;
            } else {
                sortedHead = head;
            }
            return sortedHead;
        }

        ListNode fast = head, slow = head;
        while (Objects.nonNull(fast.next) && Objects.nonNull(fast.next.next)) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode rightHead = slow.next;
        slow.next = null;
        ListNode leftSortedHead = this.sortList(head);
        ListNode rightSortedHead = this.sortList(rightHead);
        return this.mergeTwoLists(leftSortedHead, rightSortedHead);
    }

    private ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (Objects.isNull(list1)) {
            return list2;
        }
        if (Objects.isNull(list2)) {
            return list1;
        }
        ListNode head = null, pre = null;
        while (Objects.nonNull(list1) && Objects.nonNull(list2)) {
            if (list1.val <= list2.val) {
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

            pre.next = Objects.isNull(list1)? list2 : list1;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(7);
        ListNode node1 = new ListNode(6);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        SortList sortList = new SortList();
        print(sortList.sortList(head));
    }

}
