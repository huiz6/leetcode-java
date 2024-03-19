package org.example.no24;

import org.example.base.ListNodeBase;

import java.util.Objects;

public class SwapNodesInPairs extends ListNodeBase {

    public ListNode swapPairs(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        ListNode swappedHead = null, cur = head, pre = null, nextNext = null;
        while (true) {
            if (Objects.isNull(swappedHead)) {
                if (Objects.nonNull(cur.next)) {
                    swappedHead = cur.next;
                } else {
                    swappedHead = cur;
                }
            }

            if (Objects.isNull(cur) || Objects.isNull(cur.next)) {
                break;
            } else {
                if (Objects.nonNull(pre)) {
                    pre.next = cur.next;
                }
                nextNext = cur.next.next;
                cur.next.next = cur;
                pre = cur;
                cur = nextNext;
            }
        }

        if (Objects.nonNull(pre)) {
            pre.next = nextNext;
        }
        return swappedHead;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(0);
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(3);
        ListNode node14 = new ListNode(4);
//        ListNode node15 = new ListNode(5);
//        head1.next = node11;
        node11.next = node12;
        node12.next = node13;
        node13.next = node14;
//        node14.next = node15;
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode swappedHead = swapNodesInPairs.swapPairs(head1);
        print(swappedHead);
    }
}
