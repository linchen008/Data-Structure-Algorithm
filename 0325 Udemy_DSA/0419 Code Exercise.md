## Code Exercise
> Sum Lists You have two numbers represented by a linked list, where each node contains a single digit. 
> The digits are stored in reverse order, such that the 1's digit is at the head of the list. 
> Write a function that adds the two numbers and returns the sum as a linked list. 
> list1 = 7 -> 1 -> 6 
> list2 = 5 -> 9 -> 2 
> result = 2 -> 1 -> 9
![[Pasted image 20240419230814 1.png|700]]

```Java
// Question 4 - Sum Lists  
LinkedList sumLists(LinkedList llA, LinkedList llB) {  
    Node n1 = llA.head;  
    Node n2 = llB.head;  
    int carry = 0; //store rounding value, from begining of 0  
    LinkedList resultLL = new LinkedList();  
    while (n1 != null || n2 != null) {  
        int result = carry;  
        if (n1 != null) {  
            result += n1.value;  
            n1 = n1.next;  
        }  
        if (n2 != null) {  
            result += n2.value;  
            n2 = n2.next;  
        }  
        resultLL.insertNode(result % 10);  
        carry = result / 10;  
    }  
    return resultLL;  
}
```

> Intersection
Given two (singly) linked lists, determine if the two lists intersect. Return the intersecting node.
Note that the intersection is defined based on reference, not value. 
That is, if the kth node of the first linked list is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
