package Threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 20; i++) {
            threadPool.submit(() -> {

                System.out.println("Thread " + Thread.currentThread().getId() + " is working.");
            });
        }
        threadPool.shutdown();
    }
}
