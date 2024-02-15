package stack;

import dynamicArray.DynamicArray;

public class Stack extends DynamicArray {

    public Stack() {
        super();
    }

    public Stack(int capacity) {
        super(capacity);
    }

    public void push(Object data) {
        super.add(data);
    }

    public Object pop() {

        Object aux = array[size - 1];
        array[size - 1] = null;
        size--;

        return aux;
    }

    public Object peek() {

        Object aux = array[size - 1];

        return aux;
    }


}
