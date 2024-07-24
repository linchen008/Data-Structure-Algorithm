import java.util.NoSuchElementException;

class MySingleLinkedList<E> {

    // class of single linked list
    private static class Node<E> {
        E val;
        Node<E> next;

        Node(E val) {
            this.val = val;
            this.next = null;
        }
    }

    // head and tail of the list
    private Node<E> head;
    private Node<E> tail;
    private int size;

    // constructor
    public MySingleLinkedList() {
        this.head = new Node<>(null);
        this.tail = new Node<>(null);
        this.head.next = tail;
        this.size = 0;
    }

    // add element to the beginning of the list
    public void addFirst(E e) {
        Node<E> newNode = new Node(e);
        newNode.next = head.next;
        head.next = newNode;
        if (size == 0) {
            tail = newNode;
        }
        size++;
    }

    // add element to the end of the list
    public void addLast(E e) {
        Node<E> newNode = new Node(e);
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    // add element at index
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new NoSuchElementException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            addFirst(e);
        } else if (index == size) {
            addLast(e);
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node<E> newNode = new Node(e);
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    // remove element at beginning
    public E removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        Node<E> current = head.next;
        head.next = current.next;
        if (size == 1) {
            tail = head;
        }
        size--;
        return current.val;
    }

    // remove element at end
    public E removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        Node<E> current = head;
        while (current.next != tail) {
            current = current.next;
        }
        Node<E> removedNode = current.next;
        current.next = tail;
        tail = current;
        size--;
        return removedNode.val;
    }

    // remove element at index
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            return removeFirst();
        } else if (index == size - 1) {
            return removeLast();
        } else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            Node<E> removedNode = current.next;
            current.next = removedNode.next;
            size--;
            return removedNode.val;
        }
    }

    // get element at Beginning
    public E getFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        return head.next.val;
    }

    // get element at end
    public E getLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.val;
    }

    // get element at index
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    // set element at index
    public E set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new NoSuchElementException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        E oldValue = current.val;
        current.val = e;
        return oldValue;
    }

    // get size of the list
    public int size() {
        return size;
    }

    // check if list is empty
    public boolean isEmpty() {
        return size == 0;
    }
}
