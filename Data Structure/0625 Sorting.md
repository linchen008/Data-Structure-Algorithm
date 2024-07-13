## What is sorting?
## Types of Sorting
Time Complexity
Space Complexity
Stability
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
	void printArray(int arr[]){
		int n = arr.length;
		for(int i = 0; i < n; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
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
            // Swap the found minimum element with the first element of the unsorted part  
            int temp = arr[minIndex];  
            arr[minIndex] = arr[i];  
            arr[i] = temp;  
        }  
    }  
    //Utility function to print the array  
    public static void printArray(int[] arr){  
        for (int i = 0; i < arr.length; i++) {  
            System.out.print(arr[i] + " ");  
        }  
        System.out.println();  
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
  
    public static void printArray(int[] arr){  
        for (int i = 0; i < arr.length; i++) {  
            System.out.print(arr[i] + " ");  
        }  
        System.out.println();  
    }  
}
```

### 4 Bucket Sort
#### Key Concepts
1. **Distribution**: Elements are distributed into buckets.
2. **Sorting**: Each bucket is sorted individually.
3. **Concatenation**: Sorted buckets are concatenated to produce the sorted array.
```Java
//Bucket Sort

```