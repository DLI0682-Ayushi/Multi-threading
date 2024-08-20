package SynchronousOperations;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) {

        CountDownLatch latch = new CountDownLatch(3);
        Runnable worker = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " is working...");
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getName() + " has completed.");
                latch.countDown();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        for (int i = 1; i <= 3; i++) {
            new Thread(worker, "Worker-" + i).start();
        }

        try {
            latch.await();
            System.out.println("All workers have completed their tasks!");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
