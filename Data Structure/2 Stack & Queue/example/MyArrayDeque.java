class MyArrayDeque<E> {
    private CycleArray<E> arr;

    public MyArrayDeque() {
        arr = new CycleArray<>();
    }

    // add an element to the front, O(1)
    public void addFirst(E e) {
        arr.addFirst(e);
    }

    // add an element to the end, O(1)
    public void addLast(E e) {
        arr.addLast(e);
    }

    // remove the first element, O(1)
    public E removeFirst() {
        return arr.removeFirst();
    }

    // remove the last element, O(1)
    public E removeLast() {
        return arr.removeLast();
    }

    // get the first element, O(1)
    public E getFirst() {
        return arr.getFirst();
    }

    // get the last element, O(1)
    public E getLast() {
        return arr.getLast();
    }

    // get the size of the deque
    public int size() {
        return arr.size();
    }
}
