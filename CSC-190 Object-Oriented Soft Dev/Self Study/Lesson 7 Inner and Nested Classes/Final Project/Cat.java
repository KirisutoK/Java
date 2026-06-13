// Creation Date: June 08, 2026. at 11:28 AM
// Last Modified: June 12, 2026. at  8:11 PM

import java.time.LocalDate;
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
    public String getVaccinated() {
        if (isVaccinated) {
            System.out.println(Name+" has been vaccinated already");
            return null; // stops the whole method here
        }

        //? CREATE A FORMATED RECORD CLASS
        class getVaccinationDate { //... <======================= THIS IS A LOCAL CLASS
            String Month;
            String Day;
            String Year;

            public getVaccinationDate() {
                LocalDate Today = LocalDate.now();
                Month = Today.getMonth().toString();        // Month
                Day = String.valueOf(Today.getDayOfMonth()); // Day
                Year = String.valueOf(Today.getYear());   // Year
            }

            public String getFormattedInformation() {
                return Month+" "+Day+" "+Year;
            }
        }
        getVaccinationDate Today = new getVaccinationDate();

        //? APPLYING THE STUFF
        System.out.println(Name+" has been vaccinated!");
        isVaccinated = true;
        return Today.getFormattedInformation();
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
        static String Type = "Cat";
        static ArrayList<String> VaccinationVisits = new ArrayList<>();
        private String HealthProvider;
        private String CatName;

        //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
        public VaccinationRecord(String HealthProvider, String CatName) {
            this.HealthProvider = HealthProvider;
            this.CatName = CatName;
        }

        //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
        public String getHealthProvider() {
            return HealthProvider;
        }

        //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
        public void addVisit(String VisitRecord) {
            VaccinationVisits.add(VisitRecord);
        }

        //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
        public void displayVaccinationVisits() {
            System.out.println("---------------------- VACCINATION VISITS ----------------------");
            for (int i = 0; i < VaccinationVisits.size(); i++) {
                System.out.println((i+1)+". "+VaccinationVisits.get(i));
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
            System.out.println("------- "+Name+"'s Accessory Information -------");
            System.out.println("Accessories Type: "+AccessoriesType);
            System.out.println("Accessories Name: "+AccessoriesName);
            System.out.println("Value: "+Value);
        }
    }
}
