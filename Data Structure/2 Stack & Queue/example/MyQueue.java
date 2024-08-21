import java.util.LinkedList;

/*
 * Implement a queue using LinkedList.
 */
class MyQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    // Push element x onto queue. O(1)
    public void push(E e) {
        list.addLast(e);
    }

    // Removes the element on front of the queue. O(1)
    public E pop() {
        return list.removeFirst();
    }

    // Get the front element. O(1)
    public E peek() {
        return list.getFirst();
    }

    // Return whether the queue is empty. O(1)
    public boolean empty() {
        return list.isEmpty();
    }

    // Return the number of elements in the queue. O(1)
    public int size() {
        return list.size();
    }

    // Print the queue.
    public void print() {
        System.out.println(list);
    }
}
