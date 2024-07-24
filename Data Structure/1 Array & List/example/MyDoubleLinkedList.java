import java.util.NoSuchElementException;

class MyDoubleLinkedList<E> {

    // virtual head,tail node
    final private Node<E> head, tail;
    private int size;

    // double linked list node
    private static class Node<E> {
        E val;
        Node<E> prev, next;

        Node(E val) {
            this.val = val;
        }
    }

    // constructor
    public MyDoubleLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
        this.size = 0;
    }

    // add node to the end of the list
    public void addLast(E e) {
        Node<E> newNode = new Node(e);
        Node<E> temp = tail.prev;
        // temp <-> tail
        temp.next = newNode;
        newNode.prev = temp;

        newNode.next = tail;
        tail.prev = newNode;
        // temp <-> newNode <-> tail

        size++;
    }

    // add node to the beginning of the list
    public void addFirst(E e) {
        Node<E> newNode = new Node(e);
        Node<E> temp = head.next;
        // head <-> temp
        head.next = newNode;
        newNode.prev = head;

        newNode.next = temp;
        temp.prev = newNode;
        // head <-> newNode <-> temp

        size++;
    }

    // add node at index
    public void add(int index, E e) {
        checkIndex(index);
        // if index is at the end of the list
        if (index == size) {
            addLast(e);
            return;
        }

        // if index is at the beginning of the list
        if (index == 0) {
            addFirst(e);
            return;
        }

        // if index is in the middle of the list
        // 1. find the node at index
        Node<E> cur = getNode(index);

        // 2. create a new node
        Node<E> newNode = new Node(e);

        // 3. insert the new node
        Node<E> temp = cur.prev;
        // temp <-> cur
        temp.next = newNode;
        newNode.prev = temp;

        newNode.next = cur;
        cur.prev = newNode;
        // temp <-> newNode <-> cur

        // 4. increase size
        size++;
    }

    // remove node at beginning
    public E removeFirst() {
        // if list is empty
        if (size < 1) {
            throw new NoSuchElementException();
        }
        Node<E> x = head.next;
        Node<E> temp = x.next;
        // head <-> X <-> temp

        head.next = temp;
        temp.prev = head;

        x.next = null;
        x.prev = null;

        // head <-> temp
        size--;

        return x.val;
    }

    // remove node at the end
    public E removeLast() {
        // if list is empty
        if (size < 1) {
            throw new NoSuchElementException();
        }

        Node<E> x = tail.prev;
        Node<E> temp = x.prev;

        // temp <-> x <-> tail
        temp.next = tail;
        tail.prev = temp;

        x.next = null;
        x.prev = null;
        // temp <-> tail

        size--;

        return x.val;
    }

    // remove node at index
    public E remove(int index) {
        checkIndex(index);
        // if index is at the beginning of the list
        if (index == 0) {
            return removeFirst();
        }

        // if index is at the end of the list
        if (index == size - 1) {
            return removeLast();
        }

        // if index is in the middle of the list
        // 1. find the node at index
        Node<E> cur = getNode(index);

        // 2. remove the node
        Node<E> prev = cur.prev;
        Node<E> next = cur.next;
        // prev <-> cur <-> next

        prev.next = next;
        next.prev = prev;
        // prev <-> next

        cur.next = null;
        cur.prev = null;
        // cur

        // 3. decrease size
        size--;

        return cur.val;
    }

    // get node at index
    public E get(int index) {
        checkIndex(index);
        return getNode(index).val;
    }

    // get the first node
    public E getFirst() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return head.next.val;
    }

    // get the last node
    public E getLast() {
        if (size < 1) {
            throw new NoSuchElementException();
        }
        return tail.prev.val;
    }

    // set node at index
    public E set(int index, E e) {
        // check if index is valid
        checkIndex(index);

        // find the node at index
        Node<E> cur = getNode(index);

        // store the old value
        E oldVal = cur.val;

        // set the new value
        cur.val = e;

        return oldVal;
    }

    // get the size of the list
    public int size() {
        return size;
    }

    // check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // get node at index
    private Node<E> getNode(int index) {
        checkIndex(index);
        Node<E> cur = head.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    // heler func to check if index is valid
    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index is invalid");
        }
    }
}
