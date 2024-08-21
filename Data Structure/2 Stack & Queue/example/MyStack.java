import java.util.LinkedList;

/*
 * Implement a stack using LinkedList.
 */
class MyStack<E> {
    private LinkedList<E> list = new LinkedList<>();

    // Push element x onto stack.
    public void push(E e) {
        list.addLast(e);
    }

    // Removes the element on top of the stack.
    public E pop() {
        return list.removeLast();
    }

    // Get the top element.
    public E peek() {
        return list.getLast();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return list.isEmpty();
    }

    // Return the number of elements in the stack.
    public int size() {
        return list.size();
    }

    // Print the stack.
    public void print() {
        System.out.println(list);
    }
}
