/**
 * BracketStack.java
 *
 * Your Name:        Doğa Kasaplı
 * Your Student ID:  240444403
 * Your Date:        26.10.2026
 */
public class BracketStack {
    private class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }
    private Node top;

    public BracketStack() {
        top = null;
    }

    // Add an element to the top of the stack
    public void push(char value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
    }
    //  Remove and return the top element
    public char pop() {
        if (isEmpty()) {
            return '\0';
        }
        char data = top.data;
        top = top.next;
        return data;
    }

    // Return the top element without removing it
    public char peek() {
        if (isEmpty()) {
            return '\0';
        }
        return top.data;
    }

    // Check whether the stack is empty
    public boolean isEmpty() {
        return top == null;
    }
}
