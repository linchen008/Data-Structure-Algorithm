Quick sort is a sorting algorithm based on the *divide and conquer strategy*, known for its efficiency and wide application.

The core operation of quick sort is "pivot partitioning," aiming to: select an element from the array as the "pivot," move all elements smaller than the pivot to its left, and move elements greater than the pivot to its right. Specifically, the pivot partitioning process is illustrated in Figure.

1. Select the leftmost element of the array as the pivot, and initialize two pointers `i` and `j` at both ends of the array.
2. Set up a loop where each round uses `i` (`j`) to find the first element larger (smaller) than the pivot, then swap these two elements.
3. Repeat step `2.` until `i` and `j` meet, finally swap the pivot to the boundary between the two sub-arrays.
---
- **In-place Sorting**: QuickSort sorts the array in-place, meaning it doesn't require additional space proportional to the input size. This is an advantage over MergeSort, which typically requires O(n) extra space.
- **Performance Characteristics**:
    - Best-case time complexity: O(n log n)
    - Average-case time complexity: O(n log n)
    - Worst-case time complexity: O(n^2)
    - Space complexity: O(log n) average, O(n) worst case due to the recursive call stack
- **Stability**: QuickSort is not a stable sort, meaning it may change the relative order of equal elements. This can be important in some applications where the original order of equal elements needs to be preserved.
---
![[Pasted image 20240629150105.png|1200]]
```Java
//Quick Sort
void quickSort(int[] nums, int left, int right){
	//Terminate recursion when subarray length is 1
	//Ensures that the sub-array has more than one element
	if(left >= right) return; //the sub-array is already sorted
	//Step1: Partition
	int pivot = partition(nums, left, right);
	//Step2: recursively process the left subarray and right subarray
	quickSort(nums, left, pivot - 1);
	qucikSort(nums, pivot + 1, right);
}
private static int partition(int[] nums, int left, int right){
	int pivot = nums[right]; //Choose the rightmost element as the pivot
	
	//`i` starts at `low - 1` and keeps track of the boundary 
	//between elements smaller than the pivot and elements larger than the pivot.
	int i = left - 1; // Index of the smaller element
	
	//traverse through all elements
	//`j` scans through the array from `low` to `high - 1`.
	for(int j = left; j < right; j++){
		//if the current elements is smaller than or equal to pivot
		if(nums[j] <= pivot){
		//If the current element (`arr[j]`) is smaller than 
		//or equal to the pivot, we increment `i` and 
		//swap `arr[i]` with `arr[j]`. 
		//This effectively moves smaller elements to 
		//the left side of the array.
			i ++;
			int temp = nums[i];
			nums[i] = nums[j];
			nums[j] = temp;
		//If the current element is larger than the pivot, 
		//we do nothing and move to the next element.
		}
	}
	//Places the pivot in its correct position.
	int temp = nums[i+1];
	nums[i+1] = nums[right];
	nums[right] = temp;
	//Returns the partition index (`i + 1`).
	return i + 1;
}
```
