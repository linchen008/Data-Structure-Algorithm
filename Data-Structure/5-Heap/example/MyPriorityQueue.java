import java.util.Comparator;

class MyPriorityQueue<T> {

    private T[] heap;
    private int size;
    private final Comparator<? super T> comparator;

    MyPriorityQueue(int capacity, Comparator<? super T> comparator) {
        heap = (T[]) new Object[capacity + 1]; // keep 0 index empty
        size = 0;
        this.comparator = comparator;
    }

    int size() {
        return size;
    }

    boolean isEmpty() {
        return size == 0;
    }

    // parent index
    int parent(int node) {
        return node / 2;
    }

    // sub left node index
    int left(int node) {
        return node * 2;
    }

    // sub right node index
    int right(int node) {
        return node * 2 + 1;
    }

    // swap array's element
    private void swap(int i, int j) {
        T temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // search: return peak element, O(1)
    T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        return heap[1];
    }

    // add, O(logN)
    void push(T x) {
        // resize if needed
        if (size == heap.length - 1) {
            resize(2 * heap.length);
        }
        // set the new element to last
        heap[++size] = x;
        // swim and keep the heap property
        swim(size);
    }

    // delete the peak element, O(logN)
    T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Priority queue is empty");
        }
        T res = heap[1];
        // swap the last element with the peak element
        swap(1, size--);
        // sink and keep the heap property
        sink(1);
        heap[size + 1] = null; // avoid loitering
        // resize if needed
        if ((size > 0) && (size == (heap.length - 1) / 4)) {
            resize(heap.length / 2);
        }
        return res;
    }

    // swim, O(logN)
    private void swim(int k) {
        while (k > 1 && comparator.compare(heap[parent(k)], heap[k]) > 0) {
            swap(parent(k), k);
            k = parent(k);
        }
    }

    // sink, O(logN)
    private void sink(int k) {
        while (left(k) <= size) {
            int j = left(k);
            if (j < size && comparator.compare(heap[j], heap[j + 1]) > 0) {
                j++;
            }
            if (comparator.compare(heap[k], heap[j]) <= 0) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    // resize the heap
    private void resize(int capacity) {
        assert capacity > size;
        T[] temp = (T[]) new Object[capacity];
        for (int i = 0; i <= size; i++) {
            temp[i] = heap[i];
        }
        heap = temp;
    }
}