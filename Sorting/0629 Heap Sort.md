## What is Heap?
[[0629 Heap]]
## Heap Sort
Heap sort is an efficient sorting algorithm _based on the heap data structure_. We can implement heap sort using the _"heap creation" and "element extraction"_ operations we have already learned.
1. Input the array and establish a min-heap, where the smallest element is at the heap's top.
2. Continuously perform the extraction operation, recording the extracted elements in sequence to obtain a sorted list from smallest to largest.
   Although the above method is feasible, it requires an additional array to save the popped elements, which is somewhat space-consuming. In practice, we usually use a more elegant implementation.

## Algorithm flow
Suppose the array length is 𝑛, the heap sort process is as follows.
1. Input the array and establish a max-heap. After completion, the largest element is at the heap's top.
2. Swap the top element of the heap (the first element) with the heap's bottom element (the last element). After the swap, reduce the heap's length by 1 and increase the sorted elements count by 1.
3. Starting from the heap top, perform the sift-down operation from top to bottom. After the sift-down, the heap's property is restored.
4. Repeat steps `2.` and `3.` Loop for 𝑛−1 rounds to complete the sorting of the array.

### Detailed Explanation
#### 1. Build a Max Heap
To build a max heap, we start from the last non-leaf node and heapify each node up to the root. The last non-leaf node is at index `n/2 - 1` (where `n` is the number of elements in the array).
#### 2. Heapify
Heapify is the process of adjusting a heap to maintain the heap property. Starting from a node, we compare it with its children and swap if necessary, then recursively heapify the affected subtree.
#### 3. Sorting
Once the max heap is built, the largest element is at the root. We swap the root with the last element, reduce the heap size, and heapify the root. This process is repeated until the heap size is 1.

```Java
public void sort(int arr[]) {
        int n = arr.length;

        // build max heap
        /*
         * We start building the max heap from the
         * last non-leaf node (n/2 - 1) and move upwards.
         * This is because leaf nodes are already 1-element heaps.
         */
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    void heapify(int arr[], int n, int i) {
        int largest = i; // initialize largest as root
        int left = 2 * i + 1; // left child
        int right = 2 * i + 2; // right child

        // if left child is larger than root
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // if right child is larger than largest so far
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // if largest is not root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
        }

        // recursively heapify the affected sub-tree
        heapify(arr, n, largest);
    }
```

## Algorithm characteristics
- **Time complexity is 𝑂(𝑛log⁡𝑛), non-adaptive sort**: The heap creation uses 𝑂(𝑛) time. Extracting the largest element from the heap takes 𝑂(log⁡𝑛) time, looping for 𝑛−1 rounds.
---
- Heap Sort has a time complexity of O(n log n) for all cases (best, average, and worst). This is because:
  - Building the initial heap takes O(n) time.
  - Each call to heapify takes O(log n) time, and we call it n times.
---
- **Space complexity is 𝑂(1), in-place sort**: A few pointer variables use 𝑂(1) space. The element swapping and heapifying operations are performed on the original array.
- **Non-stable sort**: The relative positions of equal elements may change during the swapping of the heap's top and bottom elements.
