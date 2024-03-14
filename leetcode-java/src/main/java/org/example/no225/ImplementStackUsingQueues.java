package org.example.no225;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {

    private final Queue<Integer> queue1, queue2;

    public ImplementStackUsingQueues() {
        this.queue1 = new LinkedList<>();
        this.queue2 = new LinkedList<>();
    }

    public void push(int x) {
        if (this.queue2.isEmpty()) {
            this.queue1.add(x);
        } else {
            this.queue2.add(x);
        }
    }

    public int pop() {
        if (!this.queue1.isEmpty()) {
            while (this.queue1.size() > 1) {
                this.queue2.add(this.queue1.poll());
            }
            return this.queue1.poll();
        } else {
            while (this.queue2.size() > 1) {
                this.queue1.add(this.queue2.poll());
            }
            return this.queue2.poll();
        }
    }

    public int top() {
        int top;
        if (!this.queue1.isEmpty()) {
            while (this.queue1.size() > 1) {
                this.queue2.add(this.queue1.poll());
            }
            top = this.queue1.peek();
            this.queue2.add(this.queue1.poll());
        } else {
            while (this.queue2.size() > 1) {
                this.queue1.add(this.queue2.poll());
            }
            top = this.queue2.peek();
            this.queue1.add(this.queue2.poll());
        }
        return top;
    }

    public boolean empty() {
        return this.queue1.isEmpty() && this.queue2.isEmpty();
    }

    public static void main(String[] args) {
        ImplementStackUsingQueues stack = new ImplementStackUsingQueues();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack.pop());
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }

}
