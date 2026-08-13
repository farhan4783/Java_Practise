// package Day-5(monday);

import java.util.LinkedList;
import java.util.Queue;

public class Stackusing2queue {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public Stackusing2queue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int value) {
        q1.offer(value);
    }

    public int pop() {
        if (q1.isEmpty() && q2.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int popped = q1.poll();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return popped;
    }

    public int peek() {
        if (q1.isEmpty() && q2.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int top = q1.peek();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    public boolean isEmpty() {
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args) {
        Stackusing2queue stack = new Stackusing2queue();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}
