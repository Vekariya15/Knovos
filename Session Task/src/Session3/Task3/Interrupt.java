package Session3.Task3;

public class Interrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Hello ...");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Hiii...");

            }
        });
        thread.start();
        thread2.start();
        thread.interrupt(); // thread1 in wait state so it give Interrupt exception


        thread2.interrupt();  // thread2 is not in wait()  state so it don't show exception
        System.out.println("Thread2 status : " + thread2.isInterrupted()); // check thread2 interruption status


    }
}
