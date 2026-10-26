/**
 * TokenStack.java
 *
 * Your Name:        Doğa Kasaplı
 * Your Student ID:  240444403
 * Your Date:        26.10.2026
 */
public class TokenStack {
    private class Node {
        // create the instant named data as a String type
        String data;

        // create the next pointer that will be used for the Stack implementation as a Node type
        Node next;

        // complete the constructor accordingly
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }

    // create the top pointer that will be used for the Stack implementation as private
    private Node top;

    public TokenStack() {
        // create the constructor of the TokenStack class that will assign the top pointer to null
        top = null;
    }

    public void push(String value) {
        //  Create a new node.
        Node newNode = new Node(value);
        //       Connect it to the current top.
        newNode.next = top;
        //       Update top.
        top = newNode;
    }
    public String pop() {
        //  Check whether the stack is empty.
        if (isEmpty()) {
            return null;
        }
        //       Store the top value.
        String value = top.data;
        //       Move top to the next node.
        top = top.next;
        //       Return the stored value.
        return value;
    }

    public boolean isEmpty() {
        //  Return whether the stack is empty.
        return top == null;
    }
}
