// Oct 17, 2025
// This code prints an array string randomly from 1-4

import java.util.Random;

public class SelfStudyArray02 {
    public static void main(String[]args) {
        Random random = new Random();
        
        String[] Foods = {"Noodles", "Burgers", "Pizza", "Donut"};
        
        System.out.println(Foods[(random.nextInt(4))]);
    }
}
