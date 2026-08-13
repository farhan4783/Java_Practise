
class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class stack_LL {
    private Node top;
    private int size;

    public stack_LL() {
        top = null;
        size = 0;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public int pop() {
        if (top == null) {
            throw new RuntimeException("Stack is empty");
        }

        Node temp = top;
        top = top.next;
        size--;
        return temp.data;
    }

    public int peek() {
        if (top == null) {
            throw new RuntimeException("Stack is empty");
        }

        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int getSize() {
        return size;
    }

    public void display() {
        Node current = top;

        System.out.print("Stack: ");
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        stack_LL stack = new stack_LL();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        stack.display();

        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());

        stack.display();
        System.out.println("Stack size: " + stack.getSize());
    }
}
