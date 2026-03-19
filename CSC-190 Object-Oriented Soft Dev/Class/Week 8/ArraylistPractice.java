// Creation Date: March 19, 2026. at 10:14 AM
// Last Modified: March 19, 2026. at 10:34 AM

import java.util.ArrayList;
import java.util.Random;

public class ArraylistPractice {
    static Random random = new Random();
    public static void main(String[] args) {
        //1. Create an ArrayList of Strings to represent items of your choosing
        //   (for example: foods, game titles, movie titles).
        //   Fill the ArrayList with 5 items (Strings).

        ArrayList<String> AnimeOnWatch = new ArrayList<>();

        AnimeOnWatch.add("Sentenced to be Hero");
        AnimeOnWatch.add("Jujutsu Kaisen: Culling Games");
        AnimeOnWatch.add("One Piece");
        AnimeOnWatch.add("Hell's Paradise");
        AnimeOnWatch.add("The Journey of Frieren");

        //2. Print the values in the ArrayList.
        System.out.println(AnimeOnWatch.toString());
        System.out.println(" "); // Space for Readability

        //3. Create an ArrayList of integers, and fill it with 100 random values that
        //   are between 1 and 1000 (inclusive).

        ArrayList<Integer> OneThousandValues = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            OneThousandValues.add(random.nextInt(10)+1);
        }

        final int NUM_OF_VALS = 100;

        int low = 1;
        int high = 1000;

        ArrayList<Integer> values = getRandomList(NUM_OF_VALS, low, high);


        //4. Print the values in the ArrayList.
        printList(values);
    }

    /**
     *
     * @param values - an ArrayList of ints
     * prints the values in the ArrayList
     */
    public static void printList(ArrayList<Integer> values) {

        //System.out.println(values);    // easy way (small data sets)

        // large data sets? print 10 values per line
        for(int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i) + "\t");  // auto-spacing for different sized nums

            if(i % 10 == 9) {   // new line after every 10 values
                System.out.println();
            }
        }


    }

    /**
     * @param numOfVals - number of values in the list
     * @param low - smallest value in the range of values
     * @param high - largest value in the range of values (inclusive)
     * @return returns an ArrayList filled with random ints in the range low-high
     */
    public static ArrayList<Integer> getRandomList(int numOfVals, int low, int high) {

        // Note: to generate random ints:

        // Need num of values from low to high:   high - low + 1
        // ex. 1-10: num of values is 10
        // range: starts at low

        // Using Java's Random class:
        // Random rand = new Random();
        // int num = rand.nextInt(num of values) + start
        // ex. rand.nextInt(10) + 1

        // using Math.random(): multiply Math.random() by num of values and cast to an int
        // then add start value (low)
        // ex: to get 1-10:       (int)(Math.random() * 10) + 1

        // FINISH THIS!!! :)

        ArrayList<Integer> TempIntegerArray = new ArrayList<>();

        for (int i = 0; i < numOfVals; i++) {
            TempIntegerArray.add(random.nextInt(high)+low);
        }

        return TempIntegerArray;

    }
}
