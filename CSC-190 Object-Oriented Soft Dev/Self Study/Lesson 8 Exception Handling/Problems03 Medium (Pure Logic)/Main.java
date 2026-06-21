// Creation Date: June 20, 2026. at 11:12 PM
// Last Modified: June 20, 2026. at 11:26 PM

public class Main {
    public static void main(String[] args) {
        String[] Animals = {"Dog", "Cat", "Bird", "Mouse"};
        String[] NullAnimals = null;
        System.out.println(getElement(Animals, 0)); //... <========= NORMAL
        System.out.println(getElement(Animals, 4)); //... <========= OUT OF BOUNDS
        System.out.println(getElement(NullAnimals, 10)); //... <========= NULL POINTER
    }

    public static String getElement(String[] arr, int index) {  
        try {
            String CatchedElement = arr[index];
            return CatchedElement;
        } catch (NullPointerException e) {
            return "NULL_ARRAY";
        } catch (ArrayIndexOutOfBoundsException e) {
            return "OUT_OF_BOUNDS";
        } finally {
            System.out.println("Operation Complete");
        }
    }
}
