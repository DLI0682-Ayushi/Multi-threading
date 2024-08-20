package SynchronousOperations;

import java.util.concurrent.ConcurrentHashMap;

public class SynchronousMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String, Integer> map = new ConcurrentHashMap<>();
        
        map.put("Ayushi", 30);
        map.put("Aradhya", 25);
        map.put("Yash", 28);
        
        int ageOfAyushi = map.get("Ayushi");
        System.out.println("Age of Ayushi: " + ageOfAyushi);
        
        map.remove("Aradhya");

        boolean containsYash = map.containsKey("Yash");
        System.out.println("Contains Yash? " + containsYash);
    }
}
