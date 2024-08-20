package Multithreading;

import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    private static final int NUM_PHILOSOPHERS = 5;
    private static final Semaphore[] chopsticks = new Semaphore[NUM_PHILOSOPHERS];

    public static void main(String[] args) {
        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            chopsticks[i] = new Semaphore(1);
        }

        for (int i = 0; i < NUM_PHILOSOPHERS; i++) {
            int leftChopstick = i;
            int rightChopstick = (i + 1) % NUM_PHILOSOPHERS;

            new Thread(() -> {
                try {
                    while (true) {
                        think();
                        pickUpChopsticks(leftChopstick, rightChopstick);
                        eat();
                        putDownChopsticks(leftChopstick, rightChopstick);
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }).start();
        }
    }

    private static void think() throws InterruptedException {
        // Ponder life's mysteries
        Thread.sleep(100);
    }

    private static void eat() throws InterruptedException {
        // Savor wisdom soup
        Thread.sleep(100);
    }

    private static void pickUpChopsticks(int left, int right) throws InterruptedException {
        chopsticks[left].acquire();
        chopsticks[right].acquire();
    }

    private static void putDownChopsticks(int left, int right) {
        chopsticks[left].release();
        chopsticks[right].release();
    }
}
