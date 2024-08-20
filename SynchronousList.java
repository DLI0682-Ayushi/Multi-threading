package SynchronousOperations;

import java.util.concurrent.CopyOnWriteArrayList;

public class SynchronousList {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> myList = new CopyOnWriteArrayList<>();
        myList.add("Apple");
        myList.add("Banana");
        myList.add("Cherry");

        System.out.println("List contents: " + myList);

        myList.add("Date");
        myList.remove("Banana");

        System.out.println("Updated list: " + myList);
    }
}
