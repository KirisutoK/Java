public class AddingValues01 {
    static int CountNamesAdded = 0; // Variable is used anywhere in the folder or inside the file because it is a static variable.

    public static void main(String[] args) {

        String[] Names = new String[10];

        addName("Christ", Names);
        addName("John", Names);
        addName("Tina", Names);

        for (String names : Names) { // Enhanced for loops to print
            System.out.println(names);
        }
    }

    public static void addName(String Name, String[] Array) {
        if (CountNamesAdded < Array.length) {
            Array[CountNamesAdded] = Name;
            CountNamesAdded++;
        } else {
            System.out.println("Array is full");
        }
    }
}
