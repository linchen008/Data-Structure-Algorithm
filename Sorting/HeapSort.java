class HeapSort {
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
}