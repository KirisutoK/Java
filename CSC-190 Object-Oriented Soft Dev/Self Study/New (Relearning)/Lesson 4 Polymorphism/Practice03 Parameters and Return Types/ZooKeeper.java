import java.util.ArrayList;

public class ZooKeeper {
    //=======VARIABLES=======//
    private String Name;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public ZooKeeper(String Name) {
        this.Name = Name;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public Animal getMostActiveAnimal(Animal[] animals) { // Returns the Animal with the lowest age (Class type)
        int LowestAge = animals[0].Age;
        Animal Species = animals[0];

        for (Animal i:animals) {
            if (LowestAge > i.Age) {
                LowestAge = i.Age;
                Species = i;
            }
        }

        return Species;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public Mammal[] seperateMammals(Animal[] animals) { // Returns an Arraylist (not regular array)
        ArrayList<Mammal> Mammals = new ArrayList<>(); // Arraylist (No limit of size)

        for (Animal i:animals) {
            if (i instanceof Mammal) {
                Mammals.add((Mammal)i); // Downcasting and adding value into an array
            }
        }

        return Mammals.toArray(new Mammal[0]); // Concatenating an Arraylist to a Regular Array.
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

    public void feedAnimal(Animal animal, String food) {
        animal.eat(food);
    }
    public void checkHealth(Animal animal) {
        System.out.println("Checking "+animal.getName()+"'s health...");
        System.out.println(">" + animal.getName() + " is healthy!");

        if (animal instanceof Bird) {                                // shit doesn't make sense... this if conditions are irrelevant.
            System.out.println("Checking feathers..");               // It just prints out shit and nothing going on in the backend
        } else if (animal instanceof Mammal) {
            System.out.println("Checking fur condition..");
        }

        System.out.println("Checking health completed!");
    }
    public void playWithAnimal(Animal animal) {
        animal.makeSound();
        if (animal instanceof Lion) {
            ((Lion)animal).hunt(); // Concatenating Animal into Lion (Parenet into Child)
        } else if (animal instanceof Elephant) {
            ((Elephant)animal).spray();
        } else if (animal instanceof Parrot) {
            ((Parrot)animal).mimic("I love the zoo!");
        }
    }
}
