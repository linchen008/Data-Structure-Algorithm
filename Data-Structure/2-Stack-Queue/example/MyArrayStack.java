import java.util.ArrayList;

/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 21/08/2024 13:33
 * @Description : using array to implement stack
 */
class MyArrayStack<E> {
    private ArrayList<E> list = new ArrayList<>();

    // Push element x onto stack. O(1)
    public void push(E e) {
        list.add(e);
    }

    // Removes the element on top of the stack. O(1)
    public E pop() {
        return list.remove(list.size() - 1);
    }

    // Get the top element. O(1)
    public E peek() {
        return list.get(list.size() - 1);
    }

    // Return whether the stack is empty. O(1)
    public boolean empty() {
        return list.isEmpty();
    }

    // Return the number of elements in the stack. O(1)
    public int size() {
        return list.size();
    }

    // Print the stack.
    public void print() {
        System.out.println(list);
    }
}
