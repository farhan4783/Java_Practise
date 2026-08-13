public class LinkedList {
    private Node head;

    public LinkedList() {
        this.head = null;
    }

    // Node is an inner class to encapsulate list implementation
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Add an element at the end
    public void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = newNode;
    }

    // Add an element at the front
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // insert After
    public void insertafter(int prevdata, int data) {
        Node temp = head;
        while (temp != null && temp.data != prevdata) {
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    //insert at a given index
    public void insertAt(int index, int data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node temp = head;
        int currentIndex = 0;
        while (temp != null && currentIndex < index - 1) {
            temp = temp.next;
            currentIndex++;
        }
        if (temp == null) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // delete data 

    public void delete(int key) {
        Node temp = head;
        if(temp != null && temp.data == key) {
            head = temp.next;
            return;

        }
        Node prev = null;
        while(temp != null && temp.data != key){
            prev = temp;
            temp = temp.next;


        }

        if(temp == null){
            System.out.println("key not found");
            return;


        }
        prev.next = temp.next;
    }
    
    // search the element
    public boolean  search(int data){
        Node temp = head;
        while(temp != null) {
            if (temp.data == data){
                return true;
            }
            temp = temp.next;

            // return false;


        }
        return false;
    }

    //Display the element
    public void display(){
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data +"->");
            temp = temp.next;
            
        }
        System.out.println("None");

    }

    // find if a Linkedlist is circular

    // public void Circular()



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node cur = head;
        while (cur != null) {
            sb.append(cur.data);
            if (cur.next != null) sb.append(", ");
            cur = cur.next;
        }
        sb.append("]");
        return sb.toString();
    }
}