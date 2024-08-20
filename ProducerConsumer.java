package Multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class ProducerConsumer {
    private Queue<Integer> treasureChest = new LinkedList<>();
    private Semaphore emptySlots = new Semaphore(10);
    private Semaphore fullSlots = new Semaphore(0);

    public void produce(int item) throws InterruptedException {
        emptySlots.acquire();
        treasureChest.add(item);
        fullSlots.release();
    }

    public int consume() throws InterruptedException {
        fullSlots.acquire();
        int item = treasureChest.poll();
        emptySlots.release();
        return item;
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();


        Thread producer1 = new Thread(() -> {
            try {
                producerConsumer.produce(42);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread producer2 = new Thread(() -> {
            try {
                producerConsumer.produce(99);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // Create consumers
        Thread consumer1 = new Thread(() -> {
            try {
                int item = producerConsumer.consume();
                System.out.println("Consumer 1 got item: " + item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer2 = new Thread(() -> {
            try {
                int item = producerConsumer.consume();
                System.out.println("Consumer 2 got item: " + item);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer1.start();
        producer2.start();
        consumer1.start();
        consumer2.start();
    }
}
