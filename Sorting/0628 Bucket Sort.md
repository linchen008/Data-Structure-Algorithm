> Bucket sort is a typical application of the divide-and-conquer strategy. It involves setting up a series of ordered buckets, each corresponding to a range of data, and then distributing the data evenly among these buckets; each bucket is then sorted individually; finally, all the data are merged in the order of the buckets.

[Hello Algo Bucket Sort](https://www.hello-algo.com/en/chapter_sorting/bucket_sort/)
## Algorithm process
1. **Distribution**: Elements are distributed into buckets.
2. **Sorting**: Each bucket is sorted individually.
3. **Concatenation**: Sorted buckets are concatenated to produce the sorted array.
### Steps
1. Initialize 𝑘 buckets and distribute 𝑛 elements into these 𝑘 buckets.
2. Sort each bucket individually (using the built-in sorting function of the programming language).
3. Merge the results in the order from the smallest to the largest bucket.
![[Pasted image 20240628203210.png|1200]]
### Code
```Java
//Bucket Sort
void bucketSort(float[] nums){
	if (nums.length <= 1) return; //1 or 0 elements, already sorted
	
	//initialize k = n/2 buckets, expected to allocate 2 elements per bucket
	int k = nums.length / 2;
	List<List<Float>> buckets = new arrayList<>();
	//[ [1.1, 2.2], [3.4, 4.6], [5.6, 6.9] ]
	for(int i =0; i < k; i++){
		buckets.add(new ArrayList<>());
	}
	//1. Distribute array elements into various buckets
	for(float num: nums){
		//input data range is [0,1), use "num * k" to map to index range [0, k-1)
		int i = (int)(num * k);
		//add num to bucket i
		buckets.get(i).add(num);
	}
	//2. Sort each bucket
	for(List<Float> bucket : buckets){
		//use built-in sorting function, can replace with other sorting algorithms
		Collections.sort(bucket);
	}
	//3. Traverse buckets to merge results
	int i =0;
	for(List<Float> bucket : buckets){
		for(float num : bucket){
			nums[i++] = num;
		}
	}
}
```
## Algorithm characteristics
Bucket sort is *suitable for handling very large data sets*. For example, if the input data includes 1 million elements, and system memory limitations prevent loading all the data at once, you can divide the data into 1,000 buckets and sort each bucket separately before merging the results.
- **Time complexity is 𝑂(𝑛+𝑘)**: Assuming the elements are evenly distributed across the buckets, the number of elements in each bucket is 𝑛/𝑘. Assuming sorting a single bucket takes 𝑂(𝑛/𝑘log⁡(𝑛/𝑘)) time, sorting all buckets takes 𝑂(𝑛log⁡(𝑛/𝑘)) time. **When the number of buckets 𝑘 is relatively large, the time complexity tends towards 𝑂(𝑛)**. Merging the results requires traversing all buckets and elements, taking 𝑂(𝑛+𝑘) time.
- **Adaptive sorting**: In the worst case, all data is distributed into a single bucket, and sorting that bucket takes 𝑂(𝑛2) time.
- **Space complexity is 𝑂(𝑛+𝑘), *non-in-place sorting***: It requires additional space for 𝑘 buckets and a total of 𝑛 elements.
- Whether bucket sort is stable depends on whether the algorithm used to sort elements within the buckets is stable.

## How to achieve even distribution
The theoretical time complexity of bucket sort can reach 𝑂(𝑛), **the key is to evenly distribute the elements across all buckets**, as real data is often not uniformly distributed. For example, if we want to evenly distribute all products on Taobao by price range into 10 buckets, but the distribution of product prices is uneven, with many under 100 yuan and few over 1000 yuan. If the price range is evenly divided into 10, the difference in the number of products in each bucket will be very large.

To achieve even distribution, we can initially set a rough dividing line, roughly dividing the data into 3 buckets. **After the distribution is complete, the buckets with more products can be further divided into 3 buckets, until the number of elements in all buckets is roughly equal**.

As shown in Figure, this method essentially creates a recursive tree, aiming to make the leaf node values as even as possible. Of course, you don't have to divide the data into 3 buckets each round; the specific division method can be flexibly chosen based on data characteristics.
![[Pasted image 20240628210248.png|1200]]
If we know the probability distribution of product prices in advance, **we can set the price dividing line for each bucket based on the data probability distribution**. It is worth noting that it is not necessarily required to specifically calculate the data distribution; it can also be approximated based on data characteristics using some probability model.

As shown in Figure, we assume that product prices follow a normal distribution, allowing us to reasonably set the price intervals, thereby evenly distributing the products into the respective buckets.
![[Pasted image 20240628210332.png|1000]]
