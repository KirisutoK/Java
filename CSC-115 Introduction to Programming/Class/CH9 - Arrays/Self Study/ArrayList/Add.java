import java.util.ArrayList;

public class Add {
    public static void main(String[] args) {
        ArrayList<Integer> RandomNumbers = new ArrayList<>();

        RandomNumbers.add(1);
        RandomNumbers.add(6);
        RandomNumbers.add(1);
        RandomNumbers.add(2);
        RandomNumbers.add(3);

        System.out.println(RandomNumbers.toString());

        RandomNumbers.add(1, 3);
        RandomNumbers.add(2, 4);
        RandomNumbers.add(3, 5);
        RandomNumbers.add(4, 6);

        System.out.println(RandomNumbers.toString());
    }
}
