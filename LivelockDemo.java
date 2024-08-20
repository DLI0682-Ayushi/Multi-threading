package Multithreading;

public class LivelockDemo {
    private static boolean Lock1 = true;
    private static boolean Lock2 = true;

    public static void main(String[] args) {
        Thread wizard1 = new Thread(() -> {
            while (Lock1) {
                System.out.println("Wizard 1: After you!");
                Lock2 = true;
                sleep();
            }
        });

        Thread wizard2 = new Thread(() -> {
            while (Lock2) {
                System.out.println("Wizard 2: No, after you!");
                Lock1 = true;
                sleep();
            }
        });

        wizard1.start();
        wizard2.start();
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
