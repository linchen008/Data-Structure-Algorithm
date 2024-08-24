/**
 * @author : Tommy
 * @version : 1.0
 * @createTime : 21/08/2024 12:55
 * @Description :
 */
class CycleArray<T> {
    private T[] arr;
    private int start;
    private int end;
    private int count;
    private int size;

    public CycleArray() {
        this(1);
    }

    public CycleArray(int size) {
        this.size = size;
        // type cast Object[] to T[]
        this.arr = (T[]) new Object[size];
        // initialize the pointers [0,0)
        this.start = 0;
        this.end = 0;
        this.count = 0;
    }

    // automatic resize
    private void resize(int newSize) {
        // create a new array with the new size
        T[] newArr = (T[]) new Object[newSize];
        // copy the elements to the new array
        for (int i = 0; i < count; i++) {
            newArr[i] = arr[(start + i) % size];
        }
        // update the pointers
        arr = newArr;
        start = 0;
        end = count;
        size = newSize;
    }

    // add an element to the start of the array, O(1)
    public void addFirst(T val) {
        // resize the array if it's full
        if (isFull()) {
            resize(size * 2);
        }
        // move the start pointer backward before adding the new element
        start = (start - 1 + size) % size;
        arr[start] = val;
        count++;
    }

    // remove the first element of the array, O(1)
    public void removeFirst() {
        if (isEmpty()) {
            throw new IllegalStateException("The array is empty");
        }
        // remove the first element by moving the start pointer forward
        arr[start] = null;
        start = (start + 1) % size;
        count--;
        // resize the array if it's less than 1/4 full
        if (count > 0 && count == size / 4) {
            resize(size / 2);
        }
    }

    // add an element to the end of the array, O(1)
    public void addLast(T val) {
        if (isFull()) {
            resize(size * 2);
        }
        //
        arr[end] = val;
        end = (end + 1) % size;
        count++;
    }

    // remove the last element of the array, O(1)
    public void removeLast(){
        if(isEmpty()){
            throw new IllegalStateException("The array is empty");
        }
        // move the end pointer backward before removing the last element
        end = (end - 1 + size) % size;
        arr[end] = null;
        count--;
        // resize the array if it's less than 1/4 full
        if(count > 0 && count == size / 4){
            resize(size / 2);
        }
    }

    // get the first element of the array, O(1)
    public T getFirst(){
        if(isEmpty()){
            throw new IllegalStateException("The array is empty");
        }
        return arr[start];
    }

    // get the last element of the array, O(1)
    public T getLast(){
        if(isEmpty()){
            throw new IllegalStateException("The array is empty");
        }
        return arr[(end - 1 + size) % size];
    }

    // check if the array is full
    public boolean isFull() {
        return count == size;
    }

    //
    public int size() {
        return count;
    }

    //
    public boolean isEmpty() {
        return count == 0;
    }
}
