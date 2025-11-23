//Part one, make a car class 
import java.util.ArrayList;
public class Car {
    // instance variable for each car object
    private String VIN;
    private String manufacturer;
    private String Model;
    private int year;
    private boolean sold;
    private ArrayList<String> Recall = new ArrayList<String>();
    private String recallis;
    
    //Constructor for the cars
    public Car(String VIN1, String manufacturer1, String Model1, int year1)
    {
        VIN = VIN1;
        Model = Model1;
        year = year1;
        sold = false;
        manufacturer = manufacturer1;
        
    }
    
    //Get methods
    //Returns VIN of the car object
    public String getVIN()
    {
        return VIN;
    }
    
    //Return if the car object is sold
    public boolean isSold()
    {
        return sold;
    }
    
    //returns the number of recalls
    public int getNumberRecalls()
    {
        return (Recall.size());
    }
    
    
    //returns string representations of car object
    public String toString()
    {
        return ("A car Model of " + Model + " and a VIN of " + VIN+ ".");
    }
    
    //Mutator methods
    //Changes if the car is sold
    public void carSold()
    {
        sold = true;
    }
    
    //Add recalls to the arraylist Recalls
    public void addRecall(String recallis)
    {
        Recall.add(recallis);
    }
    
    
    
}