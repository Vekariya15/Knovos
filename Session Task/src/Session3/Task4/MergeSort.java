package Session3.Task4;

class MergeSort extends Thread {
    private static int[] tempArr;
    int[] arr;
    int low;
    int high;

    public MergeSort(int[] arr, int low, int high) {
        this.arr = arr;
        this.low = low;
        this.high = high;
    }


    public void run() {
        int mid = 0;
        // Only proceed if the low index is less than the high index
        if (low < high) {
            mid = (low + high) / 2; // Find the middle point

            // Create two threads for the left and right  of the array
            MergeSort thread1 = new MergeSort(arr, low, mid);
            MergeSort thread2 = new MergeSort(arr, mid + 1, high);


            thread1.start();
            thread2.start();
            try {
                // complete both thread
                thread1.join();
                thread2.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            // Merge the sorted array
            merge(arr, low, mid, high);
        }
    }

    static void merge(int[] arr, int low, int mid, int high) {
        int[] tempArr = new int[arr.length]; // Temporary array for merging

        int k = low;
        int j = mid + 1;
        int l = low;

        // Merge into the temporary array
        while (l <= mid && j <= high) {
            if (arr[l] <= arr[j]) {
                tempArr[k++] = arr[l++];
            } else {
                tempArr[k++] = arr[j++];
            }
        }
        // Copy any remaining elements from the left half
        while (l <= mid) {
            tempArr[k++] = arr[l++];
        }
        // Copy any remaining elements from the right half
        while (j <= high) {
            tempArr[k++] = arr[j++];
        }
        // Copy the merged elements back into the original array
        for (int i = low; i <= high; i++) {
            arr[i] = tempArr[i];
        }
    }
}
