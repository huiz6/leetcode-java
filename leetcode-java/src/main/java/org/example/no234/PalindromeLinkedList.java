package org.example.no234;

import org.example.base.ListNodeBase;

import java.util.Objects;

public class PalindromeLinkedList extends ListNodeBase {

    public boolean isPalindrome(ListNode head) {
        if (Objects.isNull(head.next)) {
            return true;
        }
        ListNode fast = head, slow = head;
        while (Objects.nonNull(fast.next) && Objects.nonNull(fast.next.next)) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode afterReversed = this.reverseList(slow.next);
        while (Objects.nonNull(afterReversed)) {
            if (head.val != afterReversed.val) {
                return false;
            }
            head = head.next;
            afterReversed = afterReversed.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
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
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(0);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        PalindromeLinkedList palindromeLinkedList = new PalindromeLinkedList();
        System.out.println(palindromeLinkedList.isPalindrome(head));
    }

}
