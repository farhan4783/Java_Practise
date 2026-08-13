
public class stack_using_array {
    private int[] arr;
    private int top;
     int capacity;

    
    stack_using_array(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

   
    public boolean isEmpty() {
        return top == -1;
    }

  
    public boolean isFull() {
        return top == capacity - 1;
    }

    
    public void push(int data) {
        if (isFull()) {
            System.out.println("Stack Overflow: cannot push " + data);
            return;
        }

        arr[++top] = data;
        System.out.println("Pushed: " + data);
    }

    
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow: stack is empty");
            return -1;
        }

        int value = arr[top];
        top--;
        System.out.println("Popped: " + value);
        return value;
    }

   
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return arr[top];
    }

  
    public int size() {
        return top + 1;
    }

  
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        System.out.println("Stack elements:");
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        stack_using_array stack = new stack_using_array(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(50);
        stack.push(60);
        stack.push(90);


        System.out.println("Top element: " + stack.peek());
        stack.display();

        stack.pop();
        System.out.println("Top element after pop: " + stack.peek());
        stack.display();
    }
}
