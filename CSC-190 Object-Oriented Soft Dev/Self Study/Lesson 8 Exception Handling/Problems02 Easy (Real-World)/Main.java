// Creation Date: June 19, 2026. at 12:32 PM
// Last Modified: June 20, 2026. at 11:09 PM

public class Main {
    public static void main(String[] args) {
        registerVoter("Alice", 25);
        registerVoter("Bob", 15);
    }

    public static void registerVoter(String name, int age) {
        try {
            if (age < 18 || age > 120) {
                throw new InvalidVoterAgeException(name, age);
            } else {
                System.out.println(name+" has been registered!");
            }
        } catch (InvalidVoterAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}


// TODO:
// A voting system only accepts ages between 18 and 120.
// Write a method registerVoter(String name, int age) that prints "[name] has been registered!" if the age is valid.
// If not, throw a custom exception called InvalidVoterAgeException with the message "[name] cannot register.
// Age [age] is not valid."
//
// Catch it in main and print the message.


// Input: name="Alice", age=25
// Output: Alice has been registered!
//
// Input: name="Bob", age=15
// Output: Bob cannot register. Age 15 is not valid.