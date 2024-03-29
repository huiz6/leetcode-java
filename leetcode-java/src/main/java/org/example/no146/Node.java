package org.example.no146;

public class Node<T> {

    private final T key;

    private T value;

    private Node<T> pre;

    private Node<T> next;

    public Node(T key, T value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return this.key;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public void setNext(Node<T> node) {
        this.next = node;
    }

    public Node<T> getNext() {
        return this.next;
    }

    public void setPre(Node<T> node) {
        this.pre = node;
    }

    public Node<T> getPre() {
        return this.pre;
    }

}
