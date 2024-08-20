package GarbageCollection;

class ResourceWithFinalizer {
    public ResourceWithFinalizer() {
        System.out.println("ResourceWithFinalizer created.");
    }

    @Override
    protected void finalize() {
        System.out.println("ResourceWithFinalizer finalized (cleanup).");

    }
}
public class CustomFinalizer {
    public static void main(String[] args) {

        try (ResourceWithFinalizer resource = new ResourceWithFinalizer()) {

            System.out.println("Resource in use...");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}

