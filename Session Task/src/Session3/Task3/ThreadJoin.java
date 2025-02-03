package Session3.Task3;

public class ThreadJoin {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{

            for(int i =0 ; i<10; i++){
                System.out.println("Thread 1 "+i);
            }
        });
        Thread thread2 = new Thread(()->{

            for(int i =0 ; i<10; i++){
                System.out.println("Thread 2 "+i);
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread2.join();  // thread2 run completely then after other thread run
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
