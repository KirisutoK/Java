package Week4;

import java.sql.SQLOutput;

/**
 * @author Carrie Brewer
 * @version 9-23-25
 *
 * Works with Circle objects.
 */

public class CircleApp {
    public static void main(String[] args) {

        String name = "Carrie";

        Circle circle1 = new Circle(5);

        Circle circle2 = new Circle();

        System.out.println(circle1.getPerimeter() + " " + circle1.getArea());

        circle1 = circle2;

        System.out.println(circle1.getArea());

    }
}
