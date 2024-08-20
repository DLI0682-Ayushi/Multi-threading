package GarbageCollection;

import java.util.ArrayList;
import java.util.List;

class LargeData {
    private int[] largeArray;

    public LargeData(int size) {

        largeArray = new int[size];
    }
}


public class MemoryUsage {
    public static void main(String[] args) {
        List<LargeData> dataList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            dataList.add(new LargeData(1000000));
        }

        dataList.clear();

        System.gc();

        long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Used memory (before GC): " + usedMemory / (1024 * 1024) + " MB");

        System.gc();

        usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        System.out.println("Used memory (after GC): " + usedMemory / (1024 * 1024) + " MB");
    }
}

