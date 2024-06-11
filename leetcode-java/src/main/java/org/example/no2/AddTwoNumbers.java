package org.example.no2;

import org.example.base.ListNodeBase;

import java.util.Arrays;
import java.util.Objects;

public class AddTwoNumbers extends ListNodeBase {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0), tail = head;
        int step = 0;
        while (Objects.nonNull(l1) || Objects.nonNull(l2) || step != 0) {
            int l1Val = Objects.nonNull(l1) ? l1.val : 0;
            int l2Val = Objects.nonNull(l2) ? l2.val : 0;
            int sum = l1Val + l2Val + step;
            step = sum / 10;
            ListNode curr = new ListNode(sum % 10);
            tail.next = curr;
            tail = curr;
            l1 = Objects.isNull(l1) ? null : l1.next;
            l2 = Objects.isNull(l2) ? null : l2.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode l1 = generateList(Arrays.asList(9, 9, 9, 9, 9, 9, 9));
        ListNode l2 = generateList(Arrays.asList(9, 9, 9, 9));
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode result = addTwoNumbers.addTwoNumbers(l1, l2);
        print(result);
    }
}
