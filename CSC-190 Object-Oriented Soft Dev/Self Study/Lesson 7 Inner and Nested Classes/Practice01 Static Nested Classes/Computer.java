// Creation Date: June 03, 2026. at 10:17 PM
// Last Modified: June 03, 2026. at 10:41 PM

public class Computer {
    //=======VARIABLES=======//
    private String Brand;
    private double Price;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Computer(String Brand, double Price) {
        this.Brand = Brand;
        this.Price = Price;
    }
    
    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInfo() {
        System.out.println("==== COMPUTER INFORMATION ===");
        System.out.println("Brand: "+Brand);
        System.out.println("Price: "+Price);
    }

    // ================================================== OTHER CLASSES ================================================== \\

    static class Specs {
        //=======VARIABLES=======//
        private String CPU;
        private int RAM; // in GB
        private int Storage; // in GB

        //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
        public Specs(String CPU, int RAM, int Storage) {
            this.CPU = CPU;
            this.RAM = RAM;
            this.Storage = Storage;
        }

        //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

        //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

        //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
        public void displaySpecs() {
            System.out.println("=== COMPUTER SPECS ===");
            System.out.println("CPU: "+CPU);
            System.out.println("RAM: "+RAM+"GB");
            System.out.println("Storage: "+Storage+"GB");
        }
    }
    static class Warranty {
        //=======VARIABLES=======//
        private int Years;
        private String Provider;

        //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
        public Warranty(int Years, String Provider) {
            this.Years = Years;
            this.Provider = Provider;
        }

        //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

        //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

        //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
        public void displayWarranty() {
            System.out.println("=== COMPUTER WARRANTY ===");
            System.out.println("Years: "+Years);
            System.out.println("Provider: "+Provider);
        }
    }
    
}
