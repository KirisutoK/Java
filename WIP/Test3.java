import java.util.Random;

public class Test3 {
    public static void main(String []args) {

        int Seed = 50;

        Random random = new Random(Seed);

        int randomnumber = random.nextInt(100)+1;

        System.out.println(randomnumber);
    }
}
