package linkedList;

public class Node {

    protected Object data;
    protected Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }

    public Node(Object data, Node next) {
        this.data = data;
        this.next = next;
    }
}
