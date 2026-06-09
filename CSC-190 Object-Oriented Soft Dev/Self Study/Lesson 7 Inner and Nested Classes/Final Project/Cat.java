// Creation Date: June 08, 2026. at 11:28 AM
// Last Modified: June 09, 2026. at  3:16 PM

public class Cat {
    //=======VARIABLES=======//
    private String Name;
    private int Age;
    private String Breed;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Cat(String Name) {
        this.Name = Name;
    }
    public Cat(String Name, int Age) {
        this.Name = Name;
        this.Age = Age;
    }
    public Cat(String Name, int Age, String Breed) {
        this.Name = Name;
        this.Age = Age;
        this.Breed = Breed;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void makeNoise() {
        System.out.println(Name+": Meow~, Meow~");
    }
    public void eatFood(String food) {
        System.out.println(Name+" is eating "+food);
    }


    // ================================================== OTHER CLASSES ================================================== \\
    // [STATIC CLASS]


    // [INNER CLASS]
    public class Accessories {
        //=======VARIABLES=======//
        private String AccessoriesType;
        private String AccessoriesName;
        private int Value = 0;

        //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
        public Accessories(String AccessoriesType, String AccessoriesName, int Value) {
            this.AccessoriesType = AccessoriesType;
            this.AccessoriesName = AccessoriesName;
            this.Value = Value;
        }
        public Accessories(String AccessoriesType, String AccessoriesName) {
            this.AccessoriesType = AccessoriesType;
            this.AccessoriesName = AccessoriesName;
        }

        //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

        //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

        //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
        public void displayInformation() {
            System.out.println("------- ACCESSORIES INFORMATION -------");
            System.out.println("Accessories Type: "+AccessoriesType);
            System.out.println("Accessories Name: "+AccessoriesName);
            System.out.println("Value: "+Value);
        }
    }
}
