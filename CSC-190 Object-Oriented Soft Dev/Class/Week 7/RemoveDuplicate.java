// Creation Date: March 16, 2026. at 11:08 PM
// Last Modified: March 17, 2026. at 10:45 AM

import java.util.Scanner;
import java.util.ArrayList;

public class RemoveDuplicate {
    static ArrayList<Integer> RandomNumbers = new ArrayList<>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter 10 Random Integers: ");
        for (int i = 0; i < 10; i++) {
            RandomNumbers.add(input.nextInt());
        }

        displayRandomNumbers();
        System.out.println(" "); // Space for Readability
        removeDuplicate(RandomNumbers);
        displayRandomNumbers();

    }

    public static void removeDuplicate(ArrayList<Integer> list) {
        //FIRST NUMBER TO COMPARE
        for (int i = 0; i < list.size(); i++) {
            Integer temp = list.get(i);
            // COMPARE TO THE REST
            for (int j = i+1; j < list.size(); j++) {
                if (temp.equals(list.get(j))) {
                    list.remove(j);
                    j--;
                }
            }
        }
    }

    public static void displayRandomNumbers() {
        for (int i = 0; i < RandomNumbers.size(); i++ ) {
            System.out.print(RandomNumbers.get(i)+" ");
        }
    }

}
