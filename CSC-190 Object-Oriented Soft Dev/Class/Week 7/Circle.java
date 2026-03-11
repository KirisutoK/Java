// Creation Date: March 10, 2026. at 11:32 AM
// Last Modified: March 10, 2026. at 12:03 PM

public class Circle
        extends GeometricObject {
    //=======VARIABLES=======//
    private double radius;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Circle() {
        super();
        this.radius = 10;
    }
    public Circle(double radius) {
        super();
        this.radius = radius;
    }
    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.radius = radius;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return Math.PI*Math.pow(radius, 2); // A = πr²
    }
    public double getPerimeter() { // C=2πr
        return 2*Math.PI*radius;
    }
    
    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void setRadius(double radius) {
        this.radius = radius;
    }


    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        System.out.println("Shape: Circle");
        System.out.println("Color: "+color);
        System.out.println("Filled: "+filled);
        System.out.println("Radius: "+radius);
        System.out.println("Area: "+getArea());
        System.out.println("Perimeter: "+getPerimeter());
        System.out.println("Date Created: "+getDateCreated());
    }
}
