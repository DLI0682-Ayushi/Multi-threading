package Threading;

public class ThreadInteruption {
    public static void main(String[] args) {
        Thread newThread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("New Thread: Onward!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("New Thread: Quest complete!");
        });

        newThread.start();

        try {
            Thread.sleep(5000);
            newThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
