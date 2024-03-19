package org.example.no160;

import org.example.base.ListNodeBase;

import java.util.Objects;

public class IntersectionOfTwoLinkedLists2 extends ListNodeBase {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = Objects.nonNull(curA)? curA.next: headB;
            curB = Objects.nonNull(curB)? curB.next: headA;
        }
        return curA;
    }

    public static void main(String[] args) {

    }

}
