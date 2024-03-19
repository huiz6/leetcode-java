package org.example.no160;

import org.example.base.ListNodeBase;

import java.util.Objects;

public class IntersectionOfTwoLinkedLists extends ListNodeBase {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA, curB = headB;
        int lengthA = 1, lengthB = 1;
        while (Objects.nonNull(curA.next)) {
            curA = curA.next;
            lengthA++;
        }

        while (Objects.nonNull(curB.next)) {
            curB = curB.next;
            lengthB++;
        }

        if (curA != curB) {
            return null;
        } else {
            ListNode list1, list2;
            if (lengthA > lengthB) {
                list1 = headA;
                list2 = headB;
            } else {
                list1 = headB;
                list2 = headA;
            }
            for (int i = 0; i < Math.abs(lengthA - lengthB); i++) {
                list1 = list1.next;
            }
            while (list1 != list2) {
                list1 = list1.next;
                list2 = list2.next;
            }
            return list1;
        }

    }

    public static void main(String[] args) {

    }

}
