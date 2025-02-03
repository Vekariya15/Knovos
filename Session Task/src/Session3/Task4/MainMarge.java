package Session3.Task4;

public class MainMarge {
    public static void main(String[] args) {
        int[] arr = {10, 22, 38, 4, 5, 23, 45, 50, 3};
        MergeSort mergeSort = new MergeSort(arr, 0, arr.length - 1);  // create object of mergesort
        mergeSort.start();
        try {
            mergeSort.join();
            for (int i : arr) {
                System.out.print(i + " ");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
