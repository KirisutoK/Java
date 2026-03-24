public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[5];

        shapes[0] = new Circle(5.0);
        shapes[1] = new Rectangle(4.0, 6.0);
        shapes[2] = new Triangle(3.0, 4.0);
        shapes[3] = new Circle(3.0);
        shapes[4] = new Rectangle(5.0, 5.0);

        System.out.println("All shapes:");
        for (Shape s : shapes) {
            s.displayInfo();
            System.out.println();
        }

        System.out.println("Total area: " + calculateTotalArea(shapes));

        System.out.println("\nCircles only:");
        Shape[] circles = getShapesByType(shapes, "Circle");
        for (Shape s : circles) {
            s.displayInfo();
            System.out.println(" "); // Space for Readability
        }

        System.out.println("\nLargest shape:");
        Shape largest = findLargestShape(shapes);
        largest.displayInfo();
    }

    public static double calculateTotalArea(Shape[] shapes) {
        double total = 0;
        for (int i = 0; i <= shapes.length-1; i++) { // IT WAS OUT OF BOUNDS
            total += shapes[i].getArea();
        }
        return total;
    }

    public static Shape[] getShapesByType(Shape[] shapes, String type) {
        int count = 0;
        for (Shape s : shapes) { // Counts how many matches are there
            if (s.getClass().getSimpleName().equals(type)) { // from getName() to GetSimpleName() (CHANGED)
                count++;
            }
        }

        Shape[] result = new Shape[count]; // Creates a new array for the new matched type shapes
        int index = 0;
        for (Shape s : shapes) {
            if (s.getClass().getSimpleName().equals(type)) { // from getName() to getSimpleName() | from == to .equals() (CHANGED)
                result[index] = s;
                index++;
            }
        }
        return result;
    }

    public static Shape findLargestShape(Shape[] shapes) {
        Shape largest = shapes[0];
        for (Shape s : shapes) {
            if (s.getArea() > largest.getArea()) { // Logic Error (CHANGED)
                largest = s;
            }
        }
        return largest;
    }
}