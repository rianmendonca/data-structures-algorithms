package algorithms;

public class Algorithms {

    // O(n)
    public static int linearSearch(Object[] array, Object value) {

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return -1;

    }

    // O(log n)
    public static int binarySearch(int[] array, int target) {

        int low = 0;
        int high = array.length - 1;

        while (low <= high) {

            int middle = low + (high - low) / 2;
            int value = array[middle];

            if (value < target) low = middle + 1;
            else if (value > target) high = middle - 1;
            else return middle;
        }

        return -1;

    }

}
