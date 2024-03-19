package org.example.no83;

import org.example.base.ListNodeBase;

import java.util.Objects;

public class RemoveDuplicatesFromSortedList extends ListNodeBase {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (Objects.nonNull(cur)) {
            while (Objects.nonNull(cur.next) && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(3);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        RemoveDuplicatesFromSortedList removeDuplicatesFromSortedList = new RemoveDuplicatesFromSortedList();
        ListNode dealedHead = removeDuplicatesFromSortedList.deleteDuplicates(head);
        print(dealedHead);
    }

}
