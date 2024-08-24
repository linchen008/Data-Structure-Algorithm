class SimpleMiniPQ {
    private final int[] heap;
    private int size;

    public SimpleMiniPQ(int capacity) {
        heap = new int[capacity + 1];
        size = 0;
    }

    public int size() {
        return size;
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
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // search: return peak element, O(1)
    public int peek() {
        return heap[1];
    }

    // add, O(logN)
    public void push(int x) {
        // set the new element to last
        heap[++size] = x;
        // swim and keep the heap property
        swim(size);
    }

    // delete the peak element, O(logN)
    public int pop() {
        int res = heap[1];
        // set bottem element to top
        heap[1] = heap[size - 1];
        // sink to property position
        sink(1);
        return res;
    }

    // swim: keep the heap property
    private void swim(int x) {
        while (x > 1 && heap[parent(x)] > heap[x]) {
            swap(parent(x), x);
            x = parent(x);
        }
    }

    // sink: keep the heap property
    private void sink(int x) {
        while (left(x) <= size || right(x) <= size) {
            int min = x;
            if (left(x) <= size && heap[left(x)] < heap[min]) {
                min = left(x);
            }
            if (right(x) <= size && heap[right(x)] < heap[min]) {
                min = right(x);
            }
            if (min == x) {
                break;
            }
            swap(x, min);
            x = min;
        }
    }

}
