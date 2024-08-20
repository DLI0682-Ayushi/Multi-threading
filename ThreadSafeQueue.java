package Threading;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadSafeQueue<T> {
    private Queue<T> treasureChest = new LinkedList<>();

    public synchronized void enqueue(T item) {
        treasureChest.add(item);
    }

    public synchronized T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty!");
        }
        return treasureChest.poll();
    }

    public synchronized boolean isEmpty() {
        return treasureChest.isEmpty();
    }

    public synchronized int size() {
        return treasureChest.size();
    }
}
