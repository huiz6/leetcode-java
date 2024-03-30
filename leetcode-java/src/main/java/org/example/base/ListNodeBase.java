package org.example.base;

import java.util.List;
import java.util.Objects;

public class ListNodeBase {

    public static class ListNode {

        public int val;
        public ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }

    public static ListNode generateList(List<Integer> arrayList) {
        ListNode head = new ListNode(arrayList.get(0)), cur = head;
        for (int i = 1; i < arrayList.size(); i++) {
            ListNode node = new ListNode(arrayList.get(i));
            cur.next = node;
            cur = node;
        }
        return head;
    }

    public static void print(ListNode node) {
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
