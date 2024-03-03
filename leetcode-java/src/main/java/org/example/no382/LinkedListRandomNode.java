package org.example.no382;


import java.util.Objects;

public class LinkedListRandomNode {

    private final ListNode head;

    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }

    public int getRandom() {
        int val = head.val;
        ListNode node = head.next;
        int i = 2;
        while (Objects.nonNull(node)) {
            if (i == (int)(Math.random() * i) + 1) {
                val = node.val;
            }
            i++;
            node = node.next;
        }
        return val;
    }

    public static void main(String[] args) {

    }

}
