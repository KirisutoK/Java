package Week4;

/**
 * @Author Bennett Rundt
 * @Edition 09/23/25
 * Create a circle class with a radius that can return perimeter and area
 */

public class Circle {

    //Data fields
    private double radius;

    //Constructors, create an instance of the circle class

    /*
    Constructor just like method but
    1. Same exact name as class
    2. no return type
     */

    public Circle()
    {
        radius = 1;
    }

    public Circle(double radius)
    {
        this.radius = radius;
    }

    //Methods
    public double getPerimeter()
    {
        return (2 * 3.14 * radius);
    }

    public double getArea()
    {
        return (3.14 * radius * radius);
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

}
