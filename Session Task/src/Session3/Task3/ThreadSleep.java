package Session3.Task3;

public class ThreadSleep {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            System.out.println("Thread set on sleep mode thread 1");
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Sleep mode is over thread 1");
        });
        Thread thread2 = new Thread(()->{
            System.out.println("Thread 2");
            for(int i =0 ; i<10; i++){
                System.out.println("Thread 2 "+i);
            }

        });
thread.start();
thread2.start();
    }
}
