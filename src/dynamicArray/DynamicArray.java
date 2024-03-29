package dynamicArray;

public class DynamicArray {

    protected int size;
    protected int capacity = 10;
    protected Object[] array;

    public DynamicArray() {
        this.array = new Object[capacity];
    }

    public DynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = new Object[capacity];
    }

    public Object get(int index) {
        return array[index];
    }

    public void add(Object data) {

        if (size >= capacity) {
            grow();
        }

        array[size] = data;
        size++;
    }

    public void insert(int index, Object data) {

        if (size >= capacity) {
            grow();
        }

        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }

        array[index] = data;
        size++;
    }

    public void delete(Object data) {

        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                for (int j = 0; j < (size - i - 1); j++) {
                    array[i + j] = array[i + j + 1];
                }

                array[size - 1] = null;
                size--;

                if (size <= (int) (capacity / 3)) {
                    shrink();
                }

                break;

            }
        }
    }

    public Object remove(int index) {

        Object aux = array[index];

        for (int i = index; i < size; i++) {
            array[i] = array[i + 1];
        }

        array[size] = null;
        size--;

        return aux;
    }

    public int search(Object data) {

        for (int i = 0; i < size; i++) {
            if (array[i] == data) {
                return i;
            }
        }

        return -1;

    }

    private void grow() {

        int newCapacity = capacity * 2;

        Object[] newArray = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        capacity = newCapacity;

        array = newArray;

    }

    private void shrink() {

        int newCapacity = (int) (capacity / 2);

        Object[] newArray = new Object[newCapacity];

        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }

        capacity = newCapacity;
        array = newArray;

    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();

        for (int i = 0; i < size; i++) {
            string.append(array[i]).append(", ");
        }

        if (!string.isEmpty()) {
            string = new StringBuilder("[" + string.substring(0, string.length() - 2) + "]");
        } else {
            string = new StringBuilder("[]");
        }

        return string.toString();

    }

}
