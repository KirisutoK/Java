// Creation Date: March 10, 2026. at 11:34 AM
// Last Modified: March 10, 2026. at 11:56 AM

public class Rectangle
        extends GeometricObject {
    //=======VARIABLES=======//
    private double width;
    private double height;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Rectangle() {
        super();
        this.width = 1.0;
        this.height = 1.0;
    }
    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }
    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }
    public double getArea() {
        return height*width;
    }
    public double getPerimeter() {
        return 2.0*(height*width);
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void setWidth(double width) {
        this.width = width;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        System.out.println("Shape: Rectangle");
        System.out.println("Color: "+color);
        System.out.println("Filled: "+filled);
        System.out.println("Height: "+height);
        System.out.println("Width: "+width);
        System.out.println("Area: "+getArea());
        System.out.println("Perimeter: "+getPerimeter());
        System.out.println("Date Created: "+getDateCreated());
    }
}
