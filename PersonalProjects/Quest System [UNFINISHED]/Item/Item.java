package Item;// Creation Date: April 07, 2026. at 10:35 AM
// Last Modified: April 07, 2026. at 10:54 AM

public class Item {
    //=======VARIABLES=======//
    protected String Name;
    protected int Durability;
    protected int Health;
    protected boolean isConsumable;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Item(String Name, int Durability, int Health, boolean isConsumable) {
        Name = Name;
        this.Durability = Durability;
        this.Health = Health;
        this.isConsumable = isConsumable;
    }


    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    // [{CONCRETE}]
    

    // [{ABSTRACT}]
    public String getName() {
        return Name;
    }
    public int getDurability() {
        return Durability;
    }
    public int getHealth() {
        return Health;
    }
    public boolean isConsumable() {
        return isConsumable;
    }


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
