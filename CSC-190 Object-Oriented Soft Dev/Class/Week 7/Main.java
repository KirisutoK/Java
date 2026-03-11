// Creation Date: March 10, 2026. at 11:27 AM
// Last Modified: March 10, 2026. at 12:02 PM

public class Main {
    public static void main(String[] args) {
        GeometricObject g1 = new GeometricObject();
        GeometricObject g2 = new GeometricObject("bleu", true);
        System.out.println(g1.toString());
        System.out.println(g2.toString());
        System.out.println(" "); // Space for Readability

        // [CIRCLE]
        Circle C1 = new Circle("Blue", true, 5.67);
        Circle C2 = new Circle("Green", true, 10.67);
        Circle C3 = new Circle("Red", false, 1.67);
        System.out.println(" "); // Space for Readability

        // [RECTANGLE]
        Rectangle R1 = new Rectangle("Blue", true, 5.67, 4);
        Rectangle R2 = new Rectangle("Red", false, 13.67, 15);
        Rectangle R3 = new Rectangle("Yellow", true, 9.67, 12);
        System.out.println(" "); // Space for Readability

        // ADDING IN AN ARRAY
        GeometricObject[] GeoObjects = {C1, C2, C3, R1, R2, R3};
        for (GeometricObject i:GeoObjects) {
            if (i instanceof Circle) {
                ((Circle)i).displayInformation();
            } else if (i instanceof Rectangle) {
                ((Rectangle)i).displayInformation();
            }
            System.out.println(" "); // Space for Readability
        }

    }
}
