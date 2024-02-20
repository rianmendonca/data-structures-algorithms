package linkedList;

public class LinkedList {

    protected Node head;
    protected Node tail;
    protected int size;

    public LinkedList() {
        this.size = 0;
    }

    public void insert(int index, Object data) {

        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Invalid Index");
        }

        if (index == 0) {
            addBeginning(data);
        } else if (index == size) {
            add(data);
        } else {

            Node previousNode = searchNode(index - 1);
            Node nextNode = previousNode.next;
            Node newNode = new Node(data, nextNode);
            previousNode.next = newNode;
            size++;
        }

    }

    private void addBeginning(Object data) {

        if (size == 0) {
            Node newNode = new Node(data);
            head = newNode;
            tail = newNode;
        } else {
            Node newNode = new Node(data, head);
            head = newNode;
        }

        size++;

    }

    public void add(Object data) {
        Node newNode = new Node(data);

        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }

        size++;

    }

    public Object remove(int index) {

        if (!(index >= 0 && index <= size)) {
            throw new IllegalArgumentException("Invalid Index");
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == size - 1) {
            return removeLast();
        }

        Node previousNode = searchNode(index - 1);
        Node currentNode = previousNode.next;
        Node nextNode = currentNode.next;

        currentNode.next = null;
        currentNode.data = null;
        previousNode.next = nextNode;
        size--;

        return null;

    }


    public Object removeFirst() {

        if (size == 0) {
            throw new RuntimeException("Linked list is empty");
        }

        Object removed = head.data;

        head = head.next;

        if (size == 0) {
            tail = null;
        }

        return removed;

    }

    public Object removeLast() {

        if (size == 0) {
            throw new RuntimeException("Linked list is empty");
        }

        if (size == 1) {
            return removeFirst();
        }

        Node penultimateNode = searchNode(size - 2);
        Object removed = penultimateNode.next.data;

        penultimateNode.next = null;
        tail = penultimateNode;
        size--;

        return removed;

    }

    private Node searchNode(int index) {

        if (!(index >= 0 && index <= size)) {
            throw new IllegalArgumentException("Invalid Index");
        }

        Node currentNode = head;

        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }

        return currentNode;
    }

    public Object search(int index) {
        return searchNode(index).data;
    }

    public boolean contains(Object data) {

        if (size == 0) {
            throw new RuntimeException("Linked list is empty");
        }

        Node currentNode = head;

        while (currentNode != null) {

            if (currentNode.data.equals(data)) {
                return true;
            }

            currentNode = currentNode.next;
        }

        return false;

    }

    public void clean() {

        for (Node currentNode = head; currentNode != null; ) {
            Node next = currentNode.next;

            currentNode.data = null;
            currentNode.next = null;

            currentNode = next;
        }

        size = 0;

    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {

        if (size == 0) {
            return "[]";
        }

        StringBuilder string = new StringBuilder();

        Node currentNode = head;

        string.append(currentNode.data).append(", ");

        while (currentNode.next != null) {
            currentNode = currentNode.next;
            string.append(currentNode.data).append(", ");
        }

        return "[" + string.substring(0, string.length() - 2) + "]";

    }

}
