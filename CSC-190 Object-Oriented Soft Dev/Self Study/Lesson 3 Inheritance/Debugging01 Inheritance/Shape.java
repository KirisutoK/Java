public class Shape {
    protected String color;
    private static int totalShapes;

    public Shape(String color) {
        this.color = color;
        totalShapes++;
    }

    public double calculateArea() {
        return 0.0;
    }

    public void displayInfo() {
        System.out.println("Shape color: " + color);
    }

    public static int getTotalShapes() {
        return totalShapes;
    }
}
