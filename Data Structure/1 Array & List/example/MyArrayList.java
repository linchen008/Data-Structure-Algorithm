
import java.util.Arrays;
import java.util.NoSuchElementException;

class MyArrayList<E> {
    // Array to store elements
    private E[] data;

    // Size of the array
    private int size;

    // default size = 1
    private static final int INIT_CAP = 1;

    // Default constructor
    public MyArrayList() {
        this(INIT_CAP);
    }

    // Constructor
    public MyArrayList(int initCap) {
        data = (E[]) new Object[initCap];
        size = 0;
    }

    // Add element
    public void addLast(E e) {
        int cap = data.length;

        // If the array is full, resize it
        if (size == cap) {
            resize(2 * cap);
        }

        // Add element to the end
        data[size] = e;
        size++;
    }

    // Add element at index
    public void add(int index, E e) {
        // Check if the index is valid
        checkPositionIndex(index);

        int cap = data.length;
        // If the array is full, resize it
        if (size == cap) {
            resize(2 * cap);
        }

        // Shift elements to the right
        // data[index..] -> data[index+1..]
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }

        // Add element at index
        data[index] = e;
        size++;
    }

    // add element at the beginning
    public void addFirst(E e) {
        add(0, e);
    }

    // remove last element
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        }

        int cap = data.length;

        // If the array is less than 1/4 full, resize it
        if (size < cap / 4) {
            resize(cap / 2);
        }

        // Remove the last element
        E deletedElement = data[size - 1];
        // Avoid memory leak, set the last element to null
        data[size - 1] = null;
        size--;

        return deletedElement;
    }

    // remove element at index
    public E remove(int index) {
        // Check if the index is valid
        checkPositionIndex(index);

        int cap = data.length;
        // If the array is less than 1/4 full, resize it
        if (size < cap / 4) {
            resize(cap / 2);
        }

        // Remove the element at index
        E deletedElement = data[index];

        // Shift elements to the left
        // data[index+1..] -> data[index..]
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        // Avoid memory leak, set the last element to null
        data[size - 1] = null;
        size--;

        return deletedElement;
    }

    // remove first element
    public E removeFirst() {
        return remove(0);
    }

    // get element at index
    public E get(int index) {
        // Check if the index is valid
        checkPositionIndex(index);

        return data[index];
    }

    // set element at index
    public E set(int index, E e) {
        // Check if the index is valid
        checkPositionIndex(index);

        // Set element at index
        E oldElement = data[index];
        data[index] = e;

        return oldElement;
    }

    // get the size of the array
    public int size() {
        return size;
    }

    // check if the array is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // check if the array contains the element at the index
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    // print the array
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    // display the array
    private void display() {
        System.out.println("size = " + size + " cap = " + data.length);
        System.out.println(Arrays.toString(data));
    }

    // resize the array
    private void resize(int newCap) {
        E[] temp = (E[]) new Object[newCap];

        for (int i = 0; i < size; i++) {
            temp[i] = data[i];
        }

        data = temp;
    }

    // Check if the index is valid
    private void checkPositionIndex(int index) {
        if (index < 0 && index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
    }

    public static void main(String[] args) {
        // set initial capacity to 3
        MyArrayList<Integer> list = new MyArrayList<>(3);

        // add 5 elements
        for (int i = 0; i < 5; i++) {
            list.addLast(i);
        }

        // print the list
        list.print();

        list.remove(3);

        list.add(1, 9);

        list.print();

        list.addFirst(100);

        int val = list.removeLast();

        list.print();
    }
}
