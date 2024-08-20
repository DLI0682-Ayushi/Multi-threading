package GarbageCollection;

class GCExample {
    public GCExample() {
        System.out.println("GCExample object created.");
    }

    @Override
    public void finalize() {
        System.out.println("GCExample object finalized and garbage collected.");
    }
}
public class GarbageCollectionDemo {
    public static void main(String[] args) {

        GCExample obj1 = new GCExample();
        GCExample obj2 = new GCExample();

        obj1 = null;
        obj2 = null;
        System.gc();
    }
}
