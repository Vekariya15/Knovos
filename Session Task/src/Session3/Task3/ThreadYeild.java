package Session3.Task3;

public class ThreadYeild {
    public static void main(String[] args) {
        Thread thread1 = new Thread(()->{

            for(int i =1 ; i<=10; i++){
                System.out.println("Thread 1 "+i);
            }
        });
        Thread thread2 = new Thread(()->{

            for(int i =11 ; i<=20; i++){
                System.out.println("Thread 2 "+i);
            }
        });
        Thread thread3 = new Thread(()->{

            for(int i =21 ; i<=30; i++){
                System.out.println("Thread 3 "+i);
            }
        });
        thread3.setPriority(Thread.MAX_PRIORITY);
        thread1.setPriority(Thread.MIN_PRIORITY);
        thread1.start();
        thread2.start();
        thread2.yield();
        thread3.start();
    }
}
