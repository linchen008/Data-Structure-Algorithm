import java.util.LinkedList;

class MyListDeque<E> {
    private LinkedList<E> list;

    public MyListDeque() {
        list = new LinkedList<>();
    }

    // add an element to the front, O(1)
    public void addFirst(E e) {
        list.addFirst(e);
    }

    // add an element to the end, O(1)
    public void addLast(E e) {
        list.addLast(e);
    }

    // remove the first element, O(1)
    public E removeFirst() {
        return list.removeFirst();
    }

    // remove the last element, O(1)
    public E removeLast() {
        return list.removeLast();
    }

    // get the first element, O(1)
    public E getFirst() {
        return list.getFirst();
    }

    // get the last element, O(1)
    public E getLast() {
        return list.getLast();
    }

    // get the size of the deque
    public int size() {
        return list.size();
    }
}
