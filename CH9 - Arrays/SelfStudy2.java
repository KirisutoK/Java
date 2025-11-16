import java.util.Random;

public class SelfStudy2 {
    public static void main(String[]args) {
        Random random = new Random();
        
        String[] Foods = {"Noodles", "Burgers", "Pizza", "Donut"};

        
        System.out.println(Foods[(random.nextInt(4))]);
    }
}
