// Creation Date: June 24, 2026. at 10:16 PM
// Last Modified: June 24, 2026. at 10:57 PM

import Exceptions.AgeInvalidException;
import Exceptions.InvalidEnvironmentException;

public class People {
    //=======VARIABLES=======//
    private String Name;
    private int Age;
    private boolean isInBar;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public People(String Name, int Age) {
        this.Name = Name;
        this.Age = Age;
        isInBar = false;
    }


    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES


    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void enterBar() throws InvalidEnvironmentException, AgeInvalidException {
        if (Age < 21) {
            throw new AgeInvalidException();
        } else if (isInBar) {
            throw new InvalidEnvironmentException("You are already in a bar!");
        } else {
            isInBar = true;
        }
    }
    public void leaveBar() throws InvalidEnvironmentException {
        if (!isInBar) {
            throw new InvalidEnvironmentException("You are not in a bar!");
        }
    }
    public void drinkAlcohol(Alcohol a) throws InvalidEnvironmentException, AgeInvalidException {
        if (Age < 21) {
            throw new AgeInvalidException();
        }
        if (!isInBar) {
            throw new InvalidEnvironmentException("You cannot drink outside the bar!");
        }

        System.out.println(Name+" is drinking "+a.getName());
    }




    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS


    // ================================================== OTHER CLASSES ================================================== \\
}

// PEOPLE methods will consist of:
//  -> drinkAlcohol();
//  -> enterBar();
//  -> leaveBar();