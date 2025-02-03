package Session3.Task1;

class DataPrint extends Thread {
    private static final Object lock = new Object();
    static int i = 0;
    private String name;
    private int threadId;

    public DataPrint(int threadId, String name) {
        this.threadId = threadId;
        this.name = name;
    }

    public void run() {
        while (i <= 20) {
            synchronized (lock) {
                if (i == 0) {
                    System.out.println(i);
                    i++;
                } else if (i % 2 == threadId % 2) {
                    System.out.println(threadId + " " + name + " " + i);
                    i++;
                    lock.notify();
                } else {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
            try {
                Thread.sleep(50);
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}

public class OddAndEven {

    public static void main(String[] args) {
        DataPrint odd = new DataPrint(1, "odd");
        DataPrint even = new DataPrint(2, "even");
        odd.start();
        even.start();

        try {
            odd.join();
            even.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
