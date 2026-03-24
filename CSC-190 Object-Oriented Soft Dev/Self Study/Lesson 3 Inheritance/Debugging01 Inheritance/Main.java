public class Main {
    public static void main(String[] args) {
        Shape shape1 = new Shape("Red");
        Circle circle1 = new Circle("Blue", 5.0);
        Rectangle rect1 = new Rectangle("Green", 4.0, 6.0);

        shape1.displayInfo();
        circle1.displayInfo();
        rect1.displayInfo();

        System.out.println("\nAreas:");
        System.out.println("Circle area: " + circle1.calculateArea());
        System.out.println("Rectangle area: " + rect1.calculateArea());

        System.out.println("\nTotal shapes created: " + Shape.getTotalShapes());
    }
}
