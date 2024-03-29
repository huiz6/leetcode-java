package org.example.no146;

import java.util.Objects;

public class DoubleLinkedList<T> {

    private final Node<T> dummyHead;
    private Node<T> tail;

    public DoubleLinkedList() {
        this.dummyHead = new Node<>(null, null);
        this.tail = this.dummyHead;
    }

    public void add(Node<T> node) {
        this.tail.setNext(node);
        node.setPre(this.tail);
        this.tail = node;
    }

    public Node<T> getHead() {
        return this.dummyHead.getNext();
    }

    public void removeNode(Node<T> node) {
        node.getPre().setNext(node.getNext());
        if (Objects.nonNull(node.getNext())) {
            node.getNext().setPre(node.getPre());
        } else {
            this.tail = node.getPre();
        }

        node.setPre(null);
        node.setNext(null);
    }

    public void moveToTail(Node<T> node) {
        this.removeNode(node);
        this.add(node);
    }

}
