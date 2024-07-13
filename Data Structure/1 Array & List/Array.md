# What is Array?

```Java
//secondMax
public int findSecondMax(int[] arr){
	int max = Integer.MIN_VALUE;
	int secMax = Integer.MIN_VALUE;
	for (i = 0; i < arr.length; i ++){
		if(arr[i] > max){
			max = arr[i];
			secMax = max;
		} else if (arr[i] > secMax && arr[i] != max){
			secmax = arr[i];
			}
	}
	return secMax;
}
```
