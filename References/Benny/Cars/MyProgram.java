// Part two, show application of car class made in part !

public class MyProgram
{
    //our main code
    public static void main(String[] args)
    {
     
     //Creates the car class
     Car newKia = new Car("TN236342", "Kia", "Soul", 2023);
     Car newGm = new Car("DT112743", "GM", "Trax", 2024);
     
     //Adds recalls to cars
     newGm.addRecall("Check wiper motor");
     newKia.addRecall("Airbag problem");
     newGm.addRecall("Defective floor mats");
     
     //Changes car sold status
     newGm.carSold();
     
     //Prints out string representations of Recall amount
     System.out.println("the kia has " + newKia.getNumberRecalls() + " recalls.");
     
     //Prints out string representation of the car object 
     System.out.println(newGm.toString());
            
    }
}