package Scope;

import java.util.Scanner;

public class ScopeA
{
    public static Scanner console = new Scanner(System.in);
    public static int x;

    public static int getInteger()
    {
        int x;

        System.out.print("Enter a value: ");
        x = console.nextInt();

        return x;
    }

    public static int addInt(int x, int y)
    {
        x = 3;

        return x + y;
    }

    public static double average(int sum, int count)
    {
        ++ScopeA.x;
        System.out.println("Calling average. x = " + x );

        return (double)sum / count;
    }

    public static void displayAns(double theAnswer) {
        System.out.println("The average is: " + theAnswer);
    }

    public static void main(String[] args)
    {
        int x, y, z;

        x = 4;

        x = getInteger();
        y = getInteger();
        z = getInteger();

        int sum = addInt(x, y);
        sum = addInt(sum, z);

        double avg = average(sum, 3);

        displayAns(avg);
    }
}


