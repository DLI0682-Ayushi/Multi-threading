package SynchronousOperations;

import java.util.concurrent.BrokenBarrierException;

public class CyclicBarrier {
    public static void main(String[] args) {
        final int numThreads = 3;
        java.util.concurrent.CyclicBarrier barrier = new java.util.concurrent.CyclicBarrier(numThreads, () -> {
            System.out.println("All threads have reached the barrier!");
        });
        for (int i = 0; i < numThreads; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " is waiting...");
                    Thread.sleep(1000);
                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + " has passed the barrier.");
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }
}

