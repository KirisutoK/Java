// Creation Date: June 08, 2026. at 11:28 AM
// Last Modified: June 10, 2026. at  9:06 PM

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Cat {
    //=======VARIABLES=======//
    private String Name;
    private int Age;
    private String Breed;

    // [HEALTH DETAILS]
    private boolean isVaccinated;

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
    public Cat(String Name, int Age, String Breed, boolean isVaccinated) {
        this.Name = Name;
        this.Age = Age;
        this.Breed = Breed;
        this.isVaccinated = isVaccinated;
    }
    public Cat(String Name, int Age, boolean isVaccinated) {
        this.Name = Name;
        this.Age = Age;
        this.isVaccinated = isVaccinated;
    }
    public Cat(String Name, boolean isVaccinated) {
        this.Name = Name;
        this.isVaccinated = isVaccinated;
    }
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void getVaccinated() {
        if (isVaccinated) {
            System.out.println(Name+" has been vaccinated already");
            return; // stops the whole method here
        }

        //? CREATE A FORMATED RECORD CLASS

        class VaccinationTimeRecord {
            S
        }


        System.out.println(Name+" has been vaccinated!");
        isVaccinated = true;
        String VaccinationTime = "";
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void makeNoise() {
        System.out.println(Name+": Meow~, Meow~");
    }
    public void eatFood(String food) {
        System.out.println(Name+" is eating "+food);
    }


    // ================================================== OTHER CLASSES ================================================== \\
    // [STATIC CLASS]
    public static class VaccinationRecord {
        //=======VARIABLES=======//
        ArrayList<String> VaccinationVisits = new ArrayList<>();

        //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

        //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

        //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
        public void addVisit(String VisitRecord) {
            VaccinationVisits.add(VisitRecord);
        }

        //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
        public void displayVaccinationVisits() {
            System.out.println("========================================= VACCINATION VISITS =========================================");
            for (int i = 0; i <VaccinationVisits.size(); i++) {
                System.out.println(VaccinationVisits);
                System.out.println(); // Space for Readability
            }
        }
    }


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
