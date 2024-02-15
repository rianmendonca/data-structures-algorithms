package queue;

import dynamicArray.DynamicArray;

public class Queue extends DynamicArray {

    public Queue() {
        super();
    }

    public Queue(int capacity) {
        super(capacity);
    }

    public void enqueue(Object data) {
        super.add(data);
    }

    public Object dequeue() {
        return super.remove(0);
    }

    public Object peek() {

        return array[0];
    }
}
