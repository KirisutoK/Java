package Week5;

/**
 * @Author Bennett Rundt
 * @Edition 09/30/25
 * Create a rectangle with a width and length
 */

public class Rectangle {

    private double width;
    private double height;

    Rectangle()
    {
        width = 1;
        height = 2;
    }

    Rectangle(double width, double height)
    {
        this.width = width;
        this.height = height;
    }

    public double getWidth()
    {
        return width;
    }

    public double getHeight()
    {
        return height;
    }

    public double getArea()
    {
        return (width*height);
    }

    public double getPerimeter()
    {
        return (width + width + height + height);
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public void setWidth(double width)
    {
        this.width = width;
    }
}
