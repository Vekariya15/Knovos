package Session3.Task3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockUnlock {

    private Lock lock = new ReentrantLock();

    public void showdata(int j) {
        lock.lock();
        try {
            for (int i = 0; i < 10; i++) {

                System.out.println("Thread  " + j + " " + i);
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        LockUnlock lockUnlock = new LockUnlock();

        // Creating threads
        Thread t1 = new Thread(() -> {
            lockUnlock.showdata(1);
        });

        Thread t2 = new Thread(() -> {
            lockUnlock.showdata(2);
        });

        t1.start();
        t2.start();
    }
}
