package week23;//imports
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @Author Bennett Rundt
 * Version 9-11-25
 * Chapter 7 Programming Project (assign grades)
 */

//project class
public class Chapter7ProgProj {
    public static void main(String[] args) {

        //creates scanner object
        Scanner scan = new Scanner(System.in);

        //Initializes all variables needed
        int studentamt;
        ArrayList<Integer> grades = new ArrayList<Integer>();
        ArrayList<String> lettervalue = new ArrayList<String>();
        int max;

        //Get number of students
        System.out.println("How many students do you have? ");
        studentamt = scan.nextInt();

        //prompts user for all grades
        System.out.println("Enter your grades below: ");

        //Uses a loop to iterate and store all scores
        for (int i = 0; i < studentamt; i++) {
            grades.add(scan.nextInt());
        }

        //sets max value to first index
        max = grades.get(0);

        //finds max value of array
        for (int i = 1; i < grades.size(); i++) {
            if (grades.get(i) > max) {
                max = grades.get(i);
            }
        }

        System.out.println(max);

        //Iterates through all scores and assigns a grade
        for (int i = 0; i < grades.size(); i++)
        {
            if (grades.get(i) >= (max-10))
            {
                lettervalue.add("A");
            }

            else if (grades.get(i) >= (max-20))
            {
                lettervalue.add("B");
            }

            else if (grades.get(i) >= (max-30))
            {
                lettervalue.add("C");
            }

            else if (grades.get(i) >= (max-40))
            {
                lettervalue.add("D");
            }
        }

        for (int i = 0; i < lettervalue.size(); i++)
        {
            System.out.print(lettervalue.get(i) + " ");
        }

    }

}
