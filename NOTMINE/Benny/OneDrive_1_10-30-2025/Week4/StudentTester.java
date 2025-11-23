package Week4;

/**
 * @Author Bennett Rundt
 * @Edition 09/25/25
 *
 * works with student objects
 */

public class StudentTester {
    public static void main(String[] args)
    {
        Student s1 = new Student("Jack", 23);

        System.out.println(s1.getName() + " " + s1.getAge());

        System.out.println("\nEnd of Program");
    }
}
