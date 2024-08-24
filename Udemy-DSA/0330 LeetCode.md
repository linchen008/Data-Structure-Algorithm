DSA LeetCode

# Array
## LeetCode 26
>Remove Duplicates from Sorted Array - LeetCode 26
	Given a sorted array nums, remove the duplicates in-place such that each element appears only once and returns the new length. Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.
**Example:**
>1. Input: nums = [1, 1, 2] 
>2. Output: 2

```Java
public int removeDuplicates(int[] nums) {  
    //TODO: the new length of array  
    //Checks if the input array is empty (length is 0).
    if (nums.length == 0) {  
	//If it's empty, the method returns 0, 
	//indicating that there are no elements in the array.
        return 0;
    } 
    //pointer i point to the fisrt duplicated element 
    //Initializes a pointer `**i**` to 0
    //keep track of the last non-duplicate element found in the array.
    int i = 0
	//pointer j point to next element
	//starting from 1, and iterates until the end of the array.
	//iterate through the array and 
	//compare elements with the element pointed to by `**i**`.
    for (int j = 1; j < nums.length; j++) {  
        //Checks if the element at index `**j**` 
        //is not equal to the element at index `**i**`.
        //If the elements are not equal, 
        //it means that the element at `**j**` 
        //is a unique (non-duplicate) element.
        if (nums[j] != nums[i]) {  
            //If the elements at `**i**` and `**j**` 
            //are not equal, we increment `**i**` by 1. 
            //This prepares the next position to store the unique element.
            i++;
            //This line updates the element at index `**i**` 
            //with the element at index `**j**`. 
            //This operation effectively moves the unique element 
            //to its correct position in the updated array, 
            //removing any duplicates encountered so far.
            nums[i] = nums[j];  
        }  
    }
    //Returns the new length of the array 
    //after removing duplicates. 
    //Since the pointer `**i**` is zero-based, 
    //we return `**i + 1**` to get the correct length.
    return i+1;  
}
```

## LeetCode 121
 * Best Time to Buy and Sell Stock - LeetCode 121 * 
 * You are given an array prices where prices[i] is the
 * price of a given stock on the ith day.   
 * You want to maximize your profit by choosing a   
 * single day to buy one stock and choosing a   
 * different day in the future to sell that stock.   
 * Return the maximum profit you can achieve from this transaction.   
 * If you cannot achieve any profit, return 0.  
 * **Example:**
 * Input: prices = [7, 1, 5, 3, 6, 4] * Output: 5   
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.  

```Java
public int maxProfit(int[] prices){  
    int minPrice = 0;  
    int maxProfit = 0;  
  
    for (int price : prices) {  
        if (price < minPrice) {  
            minPrice = price;  
        } else if (price - minPrice > maxProfit){  
            maxProfit = price - minPrice;  
        }  
    }    return maxProfit;  
}
```

## LeetCode 48
Rotate Matrix
Given an image represented by an NxN matrix write a method to rotate the image by 90 degrees.
You have to rotate the image **in-place**, which means you have to modify the input 2D matrix directly.
**DO NOT** allocate another 2D matrix and do the rotation.
![[Pasted image 20240330220729.png|400]]


```Java
class Main {  
    public static void main(String[] args) {  
        Main mn = new Main();  
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};  
        mn.rotateMatrix(matrix);  
        System.out.println(Arrays.deepToString(matrix));  
    }  
  
    public boolean rotateMatrix(int[][] matrix) {  
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;  
        int n = matrix.length;  
        for (int layer = 0; layer < n / 2; layer++) {  
            int first = layer;  
            int last = n - 1 - layer;  
            for (int i = first; i < last; i++) {  
                int offset = i - first;  
                int top = matrix[first][i];  
                matrix[first][i] = matrix[last - offset][first];  
                matrix[last - offset][first] = matrix[last][last - offset];  
                matrix[last][last - offset] = matrix[i][last];  
                matrix[i][last] = top;  
            }  
        }
        return true;  
    }  
}
```
