## Detailed Explanation
- Merge sort is a sorting algorithm based on the divide-and-conquer strategy, involving the "divide" and "merge" phases.
- It is an *efficient, stable, comparison-based* sorting algorithm with a time complexity of `O(nlog⁡n)`.
---
1. **Divide phase**: Recursively split the array from the ***midpoint***, transforming the sorting problem of a long array into that of shorter arrays.
2. **Merge phase**: Stop dividing when the length of the sub-array is 1, start merging, and continuously combine two shorter ordered arrays into one longer ordered array until the process is complete.
![[Pasted image 20240628211659.png|1200]]
## Algorithm workflow
As shown in Figure 11-11, the "divide phase" recursively splits the array from the midpoint into two sub-arrays from top to bottom.
1. Calculate the midpoint `mid`, recursively divide the left sub-array (interval `[left, mid]`) and the right sub-array (interval `[mid + 1, right]`).
2. Continue with step `1.` recursively until the sub-array interval length is 1 to stop.
The "merge phase" combines the left and right sub-arrays into a single ordered array from bottom to top. Note that merging starts with sub-arrays of length 1, and each sub-array is ordered during the merge phase.

It is observed that the order of recursion in merge sort is consistent with the post-order traversal of a binary tree.
- **Post-order traversal**: First recursively traverse the left subtree, then the right subtree, and finally handle the root node.
- **Merge sort**: First recursively handle the left sub-array, then the right sub-array, and finally perform the merge.
## Code
```Java
//merge sort
void mergeSort(int[] nums, int left, int right){
	//termination condition
	if(left >= right){
		//terminate recursion when subarray length is 1
		return;
	}
	// Partition stage
	int mid = left + (right - left) / 2; // Find the middle point
	mergeSort(nums, left, mid); //recursively process the left
	mergeSort(nums, mid+1, right);//recusrively process the right
	//merge stage
	merge(nums,left,mid,right);
}
//merge left subarray and right subarray
void merge(int[] nums, int left, int mid, int right){
	//left subarray interval is [left, mid], 
	//right subarray interval is [mid+1, right]
	//create a temporary array tmp to store the merged results
	int n1 = mid - left + 1;
	int n2 = right - mid;
	//create temporary arrays
	int[] L = new int[n1];
	int[] R = new int[n2];
	//copy data to temporary arrays
	for(int i = 0; i < n1; i++){
		L[i] = arr[left + i];
	}
	for(int j = 0; j < n2; j++){
		R[j] = rightArray[mid + 1 + j];
	}
	//merge the temporary arrays
	//initial indexes of first and second subarrays
	int i =0; j = 0;
	//initial index of merged subarray
	int k =left;
	//The first loop compares and merges elements from both halves.
	while(i < n1 && j < n2){
		if(L[i] <= R[j]){
			arr[k] = L[i];
			i++;
		}else{
			arr[k] = R[j];
			j++;
		}
		k++;
	}
	//copy remaining elements of leftArrray if any
	while(i < n1){
		arr[k] = L[i];
		i ++;
		k ++;
	}

	//copy remaining elements of rightArray if any
	while(j < n2){
		arr[k] = R[j];
		j ++;
		k ++;
	}
}
```
## Algorithm characteristics
- **Time complexity of 𝑂(𝑛log⁡𝑛), non-adaptive sort**: The division creates a recursion tree of height log⁡𝑛, with each layer merging a total of 𝑛 operations, resulting in an overall time complexity of 𝑂(𝑛log⁡𝑛).
- **Space complexity of 𝑂(𝑛), non-in-place sort**: The recursion depth is log⁡𝑛, using 𝑂(log⁡𝑛) stack frame space. The merging operation requires auxiliary arrays, using an additional space of 𝑂(𝑛).
- **Stable sort**: During the merging process, the order of equal elements remains unchanged.
