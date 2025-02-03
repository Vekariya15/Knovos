package Session3.Task5;

class Max extends Thread {
    static int max = 0;
    int[] arr;
    String name;

    public Max(int[] arr1, String name) {
        this.arr = new int[arr1.length];      // set array vallue
        for (int i = 0; i < arr1.length; i++) {
            arr[i] = arr1[i];
        }
        this.name = name;
    }

    public void run() {
        int localmax = arr[0];
        for (int j : arr) {
            if (localmax < j) {  // find maximum
                localmax = j;
            }
        }
        System.out.println(name + " local max = " + localmax);
        if (localmax > max) {
            max = localmax;
        }
    }
}

public class MainClass {


    public static void main(String[] args) {
        int[] arr = {10, 22, 38, 4, 5, 23, 45, 50, 3};
        int end = arr.length;
        int start = 0;
        int mid = (start + end) / 2;
        int[] arr1 = new int[mid];
        int[] arr2 = new int[arr.length - mid];
        for (int j = 0; j < mid; j++) {            // divide array in 2 parts
            arr1[j] = arr[j];
        }
        for (int j = mid; j < arr.length; j++) {
            arr2[j - mid] = arr[j];
        }

        Max max1 = new Max(arr1, "Thread 1");          // create thread object 1
        Max max2 = new Max(arr2, "Thread 2");          // create thread object 2
        max1.start();                                         // start all thread
        max2.start();
        try {
            max1.join();
            max2.join();
        } catch (InterruptedException e) {
            e.getMessage();
        }
        System.out.println("Maximum of all array is " + Max.max);
    }
}
