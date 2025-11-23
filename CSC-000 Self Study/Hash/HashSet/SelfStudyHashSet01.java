import java.util.HashSet;

public class SelfStudyHashSet01 {
    public static void main(String [] args) {
        HashSet<String> Fruits = new HashSet<>();

        Fruits.add("Banana");
        Fruits.add("Banana"); // Does not add because "Banana" already exist in the HashSet
        Fruits.add("banana"); // Adds because it first char is lowercased
        Fruits.add("Banana");

        System.out.println(Fruits);
    }
}
