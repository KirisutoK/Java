public class ZooKeeper {
    //=======VARIABLES=======//
    private String Name;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public ZooKeeper(String Name) {
        this.Name = Name;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

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
        if (animal instanceof Mammal) { // THIS IS WHERE YOU LEFT OFF

            }
        }
    }
}
