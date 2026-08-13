
import java.util.LinkedList;
import java.util.Queue;


class StackUsing_One_Queue {

    Queue<Integer> queue = new LinkedList<>();

    // Push
    public void push(int x) {

        queue.add(x);

        // Move previous elements behind x
        int size = queue.size();

        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }
    }

    // Pop
    public int pop() {

        if (queue.isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        return queue.remove();
    }

    // Peek
    public int peek() {

        if (queue.isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return queue.peek();
    }

    // isEmpty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void display() {
        System.out.println(queue);
    }
}

public class StackUsing {

    public static void main(String[] args) {

        StackUsing_One_Queue stack = new StackUsing_One_Queue();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Peek: " + stack.peek());

        System.out.println("Pop: " + stack.pop());

        System.out.println("Peek: " + stack.peek());
    }
}