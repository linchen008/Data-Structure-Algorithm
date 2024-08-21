/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 21/08/2024 13:37
 * @Description : using circle array to implement queue
 */

class MyArrayQueue<E> {
    private CycleArray<E> arr;

    public MyArrayQueue() {
        arr = new CycleArray<>();
    }

    // add an element
    public void push(E e) {
        arr.addLast(e);
    }

    // remove the first element
    public E pop() {
        return arr.removeFirst();
    }

    // get the first element
    public E peek() {
        return arr.getFirst();
    }

    // get the size of the queue
    public int size() {
        return arr.size();
    }
}
