# What is Hashing?
Hashing is a method of sorting and indexing data. The idea behind hashing is to allow large amounts of data to be indexed using keys commonly created by formulas.

| Data Structure | Time complexity for SEARCH |
| -------------- | -------------------------- |
| Array          | O(logN)                    |
| Linked List    | O(N)                       |
| Tree           | O(logN)                    |
| Hashing        | O(1) / O(N)                |
# Hashing Terminology
**Hash function** : It is a function that can be used to map of arbitrary size to data of fixed size. 
**Key** : Input data by a user.
**Hash value** : A value that is returned by Hash Function.
**Hash Table** : It is a data structure which implements an associative array abstract data type, a structure that can map keys to values.
**Collision** : A collision occurs when two different keys to a hash function produce the same output.
![[Pasted image 20240625205024.png|600]]
# Hashing Functions
- Mod function
- ASCII function
- others
# Types of Collision Resolutions Techniques
- **Direct Chaining** : Implements the buckets as linked list. Colliding elements are stored in this lists.
![[Pasted image 20240625205158.png|600]]
- **Open Addressing**: Colliding elements are stored in other vacant buckets. During storage and lookup these are found through so called probing.
	- Linear probing : It places new key into closest following empty cell.
![[Pasted image 20240625205310.png|600]]
- Quadratic probing : Adding arbitrary quadratic polynomial to the index until an empty cell is found.
![[Pasted image 20240625205425.png|600]]
- Double Hashing : Interval between probes is computed by another hash function.
![[Pasted image 20240625205509.png|600]]
