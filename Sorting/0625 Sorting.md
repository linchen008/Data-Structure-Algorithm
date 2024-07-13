## What is sorting?
## Types of Sorting
### Time Complexity
### Space Complexity
- As the name implies, in-place sorting is achieved by directly manipulating the original array, without the need for additional auxiliary arrays, thus saving memory. Generally, in-place sorting involves fewer data movement operations and is faster.
### Stability
- Stable sorting ensures that the relative order of equal elements in the array does not change after sorting.
### Adaptability
- Adaptive sorting has a time complexity that depends on the input data, i.e., the best time complexity, worst time complexity, and average time complexity are not exactly equal.
- Adaptability needs to be assessed according to the specific situation. If the worst time complexity is worse than the average, it suggests that the performance of the sorting algorithm might deteriorate under certain data, hence it is seen as a negative attribute; whereas, if the best time complexity is better than the average, it is considered a positive attribute.
### Comparison-based
- Comparison-based sorting relies on comparison operators (<, =, >) to determine the relative order of elements and thus sort the entire array, with the theoretical optimal time complexity being 𝑂(𝑛log⁡𝑛). Meanwhile, non-comparison sorting does not use comparison operators and can achieve a time complexity of 𝑂(𝑛), but its versatility is relatively poor.
## Sorting Terminology
### 1 Bubble Sort
```Java
//Bubble Sort
public class BubbleSort(){
	void bubbleSort(int arr[]){
		int n = arr.length;
		for(int i =0; i < n-1; i++){
			for(j=0; j = n-i-1; j++){
				if(arr[j] > arr[j+1]){ //asc
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
}
```

### 2 Selection Sort
```Java
//Selection Sort
public class SelectionSort {  
    //Function to perform selection sort on arr[]  
    public static void selectionSort(int[] arr) {  
        // One by one move the boundary of the unsorted subarray  
        for (int i = 0; i < arr.length-1; i++) {  
            // Find the minimum element in the unsorted part  
            int minIndex = i;  
            for (int j = i + 1; j < arr.length; j++) {  
                if (arr[j] < arr[minIndex]) {  
                    minIndex = j;  
                }  
            }  
            // Swap the found minimum element with 
            // the first element of the unsorted part  
            int temp = arr[minIndex];  
            arr[minIndex] = arr[i];  
            arr[i] = temp;  
        }  
    }  
}
```

### 3 Insertion Sort
[[Drawing 2024-06-26 Insertion Sort.excalidraw]]
```Java
//Insertion Sort
public class InsertionSort {  
    public static void insertionSort(int[] arr){  
        //Start from the second element(index = 1)  
        for (int i = 1; i < arr.length; i++) {  
            int key = arr[i];  
            int j = i - 1;  
            // move elements of arr[0..i-1] that are  
            // greater than key to one position ahead            
            // of their current position            
            while (j >= 0 && arr[j] > key) {  
                arr[j + 1] = arr[j];  
                j = j - 1;  
            }  
            // Place the key at its correct position  
            arr[j + 1] = key;  
        }  
    }  
}
```

### 4 Bucket Sort
[[0628 Bucket Sort]]
#### Key Concepts
1. **Distribution**: Elements are distributed into buckets.
2. **Sorting**: Each bucket is sorted individually.
3. **Concatenation**: Sorted buckets are concatenated to produce the sorted array.

### 5 Merge Sort
[[0628 Merge Sort]]

### 6 Quick Sort
[[0628 Quick Sort]]

