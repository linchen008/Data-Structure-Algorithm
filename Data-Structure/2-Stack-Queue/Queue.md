A queue is *a linear data structure* that follows the **First-In-First-Out (FIFO)** rule. As the name suggests, a queue simulates the phenomenon of lining up, where newcomers join the queue at the rear, and the person at the front leaves the queue first.

As shown in Figure 5-4, we call the front of the queue the "head" and the back the "tail." The operation of adding elements to the rear of the queue is termed "enqueue," and the operation of removing elements from the front is termed "dequeue."
![[Pasted image 20240630224845.png|800]]
## Common operations on queue
The common operations on a queue are shown in Table 5-2. Note that method names may vary across different programming languages. Here, we use the same naming convention as that used for stacks.
Table 5-2   Efficiency of queue operations

| Method Name | Description                            | Time Complexity |
| ----------- | -------------------------------------- | --------------- |
| `push()`    | Enqueue an element, add it to the tail | 𝑂(1)           |
| `pop()`     | Dequeue the head element               | 𝑂(1)           |
| `peek()`    | Access the head element                | 𝑂(1)           |
We can directly use the ready-made queue classes in programming languages:
```Java
public class QueueImpl {  
    //Initialize the queue  
    Queue<Integer> queue = new LinkedList<>();  
    //Enqueue elements  
    queue.offer(1);  
    queue.offer(3);  
    queue.offer(4);  
    queue.offer(5);  
    queue.offer(7);  
    // Access the first element  
    int peek = queue.peek();  
    //Dequeue an element  
    int pop = queue.poll();  
    //Get the length of the queue  
    int size = queue.size();  
    //Check if the queue is empty  
    boolean isEmpty = queue.isEmpty();  
}
```
## Implementing a queue
To implement a queue, we need a data structure that allows adding elements at one end and removing them at the other. Both linked lists and arrays meet this requirement.
### 1.   Implementation based on a linked list
As shown in Figure 5-5, we can consider the "head node" and "tail node" of a linked list as the "front" and "rear" of the queue, respectively. It is stipulated that nodes can only be added at the rear and removed at the front.
