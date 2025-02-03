package Session3.Task3;



public class ThreadWaitAndNotifyAll {
    private static final Object lock = new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            one();
        });
        Thread thread2 = new Thread(() -> {
            two();
        });


        thread1.start();
        thread2.start();
    }
    public static void one(){
        synchronized (lock){
            System.out.println("Hello it method one ....");
            try {
                lock.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("It is remaining method one  ");
        }
    }
    public static void two(){
        synchronized (lock){
            System.out.println("Hello it method two - - - - -");
            lock.notifyAll();

        }
    }
}
