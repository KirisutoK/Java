import java.util.Random;

public class NestedLoopsPractice02 {
    public static void main(String[] args) {
        System.out.println("\t\t");
        Practice1();
        System.out.println("\t\t");
        Practice2();
        System.out.println("\t\t");
        Practice3();
    }

    public static void Practice1() {
        for (int row = 0; row <= 9; row++) {
            for (int col = 1; col <= 10 - row; col++) {
                System.out.print(col + " ");
            }
            System.out.println();
        }
    }

    public static void Practice2() { // Creates a 5 star of lines in a slanting way
        for (int row = 1; row <= 5; row++) {
            for (int i = 1; i <= row; i++) {
                System.out.print(" ");
            }

            for (int col = 5; col <= 9; col++) {
                System.out.print("*");
            }

            System.out.println();
            System.out.println();
        }
    }

    public static void Practice3() { // Create a grid of 6x20 waves and then there will be randomly emojis inside
                                     // the waves emoji grid
        Random random = new Random();

        for (int row = 1; row <= 6; row++) {
            for (int col = 1; col <= 20; col++) {
                System.out.print(" ");
                int chance = random.nextInt(100);

                if (chance < 30) {
                    System.out.print("🐟");
                } else if (chance < 35) {
                    System.out.print("🦈");
                } else if (chance < 37) {
                    System.out.print("🧜");
                } else if (chance < 38) {
                    System.out.print("⛵");
                } else if (chance < 40) {
                    System.out.print("🦑");
                } else {
                    System.out.print("🌊");
                }
            }
            System.out.println();
        }
    }
}
