public class Main {
    public static void main(String[] args) {
        // CREATING OBJECTS OR INSTANCES
                // Vehicle Vehicle01 = new Vehicle("V01", "Toyota", "2026",123.4);             // DOES NOT WORK BECAUSE THE CLASS OR OBJECT IS ABSTRACT
        Car Cars01 = new Car("C01", "Buick", "2015", 12.50, 4);
        Car Cars02 = new Car("C02", "Ford", "2022", 30.50, 4);
        Motorcycle Motorcycle01 = new Motorcycle("M01", "Honda", "2016", 20.50, 450);
        Motorcycle Motorcycle02 = new Motorcycle("MO2", "Nissan", "2024", 45.60, 600);
        Truck Truck01 = new Truck("T01", "Chevrolet", "2019", 49.50, 2800, false);

        Vehicle[] Vehicles = {Cars01, Cars02, Motorcycle01, Motorcycle02, Truck01};

        // DISPLAY DETAILS
        System.out.println("=== DISPLAY DETAILS===");
        for (Vehicle i : Vehicles) {
            i.DisplayDetails();
            System.out.println(" "); // Space for Readability
        }

        // RENT VEHICLES
        System.out.println("=== RENT VEHICLES ===");
        Vehicles[0].rent();
        Vehicles[1].rent();
        Vehicles[2].rent();
        Vehicles[2].rent(); // to see if it shows an error message
        System.out.println(" "); // Space for Readability

        // CALCULATE RENTAL COST
        System.out.println("=== CALCULATE RENTAL COST===");
        System.out.println("Rental cost for "+Vehicles[0].getVehicleID()+" is "+Vehicles[0].calculateRentalCost(3));
        System.out.println("Rental cost for "+Vehicles[3].getVehicleID()+" is "+Vehicles[3].calculateRentalCost(5));
        System.out.println("Rental cost for "+Vehicles[4].getVehicleID()+" is "+Vehicles[4].calculateRentalCost(7));
        System.out.println(" "); // Space for Readability

        // RETURN RENTAL VEHICLES
        System.out.println("=== RETURN RENTAL VEHICLES ===");
        Vehicles[0].returnVehicle();
        Vehicles[1].returnVehicle();
        Vehicles[4].returnVehicle(); // to see if it shows an error messAGE
        System.out.println(" "); // Space for Readability

        // CALCULATE ALL VEHICLES IF RENTED FOR 7 DAYS
        System.out.println("=== CALCULATE ALL VEHICLES IF RENTED FOR 7 DAYS ===");
        double TotalRentIncome = 0;
        for (Vehicle i : Vehicles) {
            TotalRentIncome += i.calculateRentalCost(7);
        }
        System.out.println("Total Rental Income if all Vehicles are rented for 7 days: $"+TotalRentIncome);
        System.out.println(" "); // Space for Readability

        // MOST EXPENSIVE VEHICLE TO RENT IN 10 DAYS
        System.out.println("=== MOST EXPENSIVE VEHICLE TO RENT IN 10 DAYS ===");
        int MostExpensiveIndex = 0;
        for (Vehicle i : Vehicles) { // THIS IS WHHERE YOU LEFT OFF, (CHANGE IT INTO STANDARD FOR LOOP
            if (i.calculateRentalCost(10) > MostExpensiveIndex) {
                MostExpensiveIndex.i
            }
        }
    }
}
