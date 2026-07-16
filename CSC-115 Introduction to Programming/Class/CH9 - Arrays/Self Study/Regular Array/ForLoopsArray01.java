public class ForLoopsArray01 {
    public static void main(String[] args) {
        // Method 1: Declaring and Initializing
        String[] Names = {"John", "Tina", "Christ", "Bella", "Sophia", "Shan"};

        // Method 2: Declaring maximum values
        String[] Names1 = new String[10]; // 0 - 9

        for (int i = 0; i < Names.length; i++) {
            System.out.println(Names[i]);
        }
    }
}