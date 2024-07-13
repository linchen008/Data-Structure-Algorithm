A stack is *a linear data structure* that follows the principle of **Last-In-First-Out (LIFO)**.

We can compare a stack to a pile of plates on a table. To access the bottom plate, one must first remove the plates on top. By replacing the plates with various types of elements (such as integers, characters, objects, etc.), we obtain the data structure known as a stack.

As shown in Figure 5-1, we refer to the top of the pile of elements as the "top of the stack" and the bottom as the "bottom of the stack." The operation of adding elements to the top of the stack is called "push," and the operation of removing the top element is called "pop."
![[Pasted image 20240630224527.png|800]]
## Common operations on stack
The common operations on a stack are shown in Table 5-1. The specific method names depend on the programming language used. Here, we use `push()`, `pop()`, and `peek()` as examples.

Table 5-1   Efficiency of stack operations

|Method|Description|Time Complexity|
|---|---|---|
|`push()`|Push an element onto the stack (add to the top)|𝑂(1)|
|`pop()`|Pop the top element from the stack|𝑂(1)|
|`peek()`|Access the top element of the stack|𝑂(1)|

Typically, we can directly use the stack class built into the programming language. However, some languages may not specifically provide a stack class. In these cases, we can use the language's "array" or "linked list" as a stack and ignore operations that are not related to stack logic in the program.

