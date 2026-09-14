// Creation Date: September 14, 2026. at 12:28 PM
// Last Modified: September 14, 2026. at 12:34 PM

public class Clothes {
    //=======VARIABLES=======//
    private String Type;
    private String Brand;
    private String Color;
    private String Size;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Clothes(String Type, String Brand, String Color, String Size) {
        this.Type = Type;
        this.Brand = Brand;
        this.Color = Color;
        this.Size = Size;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void dispalyInformation() {
        System.out.println("Type: "+Type);
        System.out.println("Brand: "+Brand);
        System.out.println("Color: "+Color);
        System.out.println("Size: "+Size);
    }


    // ================================================== OTHER CLASSES ================================================== \\
}
