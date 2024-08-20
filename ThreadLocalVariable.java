package Threading;

class ThreadLocalVariables {
    private static ThreadLocal<Integer> goldPouch = ThreadLocal.withInitial(() -> 0);

    public static void addToPouch(int amount) {
        goldPouch.set(goldPouch.get() + amount);
    }

    public static int checkPouch() {
        return goldPouch.get();
    }
}
public class ThreadLocalVariable {
    public static void main(String[] args) {
        Thread trader1 = new Thread(() -> {
            ThreadLocalVariables.addToPouch(100);
            System.out.println("Trader 1: Pouch contains " + ThreadLocalVariables.checkPouch() + " gold.");
        });

        Thread trader2 = new Thread(() -> {
            ThreadLocalVariables.addToPouch(50);
            System.out.println("Trader 2: Pouch contains " + ThreadLocalVariables.checkPouch() + " gold.");
        });

        trader1.start();
        trader2.start();
    }
}

