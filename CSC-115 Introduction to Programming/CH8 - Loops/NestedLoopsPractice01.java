public class NestedLoopsPractice01 {
    public static void main(String[] args) {
        Practice1();
        System.out.println(" ");
        Practice2();
        System.out.println(" ");
        Practice3();
        System.out.println(" ");
        Practice4();
        System.out.println(" ");
        Practice5();
        System.out.println(" ");
        Practice6();
        System.out.println(" ");
        Practice7();
        System.out.println(" ");
        Practice8();
        System.out.println(" ");
        Practice9();
        System.out.println(" ");
        Practice10();
        System.out.println(" ");
        Practice11();
    }

    public static void Practice1() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 2; col++) {
                System.out.print(1);
            }
            System.out.println();
        }
    }

    public static void Practice2() {
        String word = "A";

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 4; col++) {
                System.out.print(word + " ");
            }
            System.out.println();
        }
    }

    public static void Practice3() {
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col < 4; col++) {
                System.out.print(row * col);
            }
            System.out.println();
        }
    }

    public static void Practice4() {
        for (int row = 1; row <= 5; row++) {
            for (int col = 1; col < 5; col++) {
                System.out.print(row * col + " ");
            }
            System.out.println();
        }
    }

    public static void Practice5() {
        for (int row = 0; row <= 4; row++) {
            for (int col = 2; col <= 5; col++) {
                System.out.print(row + col + " ");
            }
            System.out.println();
        }
    }

    public static void Practice6() {
        for (int row = 18; row <= 23; row++) {
            for (int col = 2; col <= 7; col++) {
                System.out.print(row + col + " ");
            }
            System.out.println();
        }
    }

    public static void Practice7() {
        for (int row = 0; row < 5; row++) {
            for (int col = 1; col <= row; col++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void Practice8() {
        for (int row = 1; row <= 5; row++) {
            for (int col = 5; col >= row; col--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void Practice9() {
        int as = 5;
        int bs = 0;

        for (int i = 1; i <= 5; i++) {
            for (int a = 0; a < as; a++) {
                System.out.print("A");
            }
            for (int b = 0; b < bs; b++) {
                System.out.print("B");
            }

            as--;
            bs++;
            System.out.println(" ");
        }
    }

    public static void Practice10() {
        for (int row = 1; row <= 5; row++) {
            for (int i = 1; i <= row; i++) {
                System.out.print(" ");
            }

            for (int col = 5; col <= 9; col++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void Practice11() {
        for (int row = 1; row <= 5; row++) {
            for (int i = 1; i <= row; i++) {
                System.out.print(" ");
            }
            for (int col = 5; col >= row; col--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}