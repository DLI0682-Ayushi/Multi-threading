package Multithreading;

public class SingletonClass {
    private static volatile SingletonClass instance;

    private SingletonClass() {
        System.out.println("This is singleton class");
    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}
