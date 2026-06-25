// Creation Date: June 24, 2026. at 10:16 PM
// Last Modified: June 24, 2026. at 10:53 PM

import Exceptions.CloseAndOpenBarException;
import Exceptions.CollectionFullException;
import Exceptions.DataNotFoundException;
import Exceptions.EmptyException;

public class Bar {
    //=======VARIABLES=======//
    public String Name;
    private Alcohol[] AlcoholCollections;
    private int AlcoholCollectionCount;
    public int MinimumAge;
    public boolean isOpen;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Bar(String Name, int AlcoholCollectionsLimit) {
        this.Name = Name;
        MinimumAge = 21;
        AlcoholCollections = new Alcohol[AlcoholCollectionsLimit];
        AlcoholCollectionCount = 0;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public int getAlcoholCollectionCount() {
        return AlcoholCollectionCount;
    }
    public Alcohol getAlcohol(Alcohol a) throws DataNotFoundException {
        for (int i = 0; i < AlcoholCollectionCount; i++) {
            if (a.equals(AlcoholCollections[i])) {
                return AlcoholCollections[i];
            }
        }

        throw new DataNotFoundException();
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void closeBar() throws CloseAndOpenBarException { //... throws make the method make it so that it has the chance of throwing an error of this type
        if (isOpen) {
            isOpen = false;
        } else {
            throw new CloseAndOpenBarException("You can't close a bar that is already closed!");
        }
    }
    public void openBar() throws CloseAndOpenBarException{  //... throws make the method make it so that it has the chance of throwing an error of this type
        if (!isOpen) {
            isOpen = true;
        } else {
            throw new CloseAndOpenBarException("You can't open a bar that is already opened!");
        }
    }
    public void addAlcohol(Alcohol a) throws EmptyException, CollectionFullException {
        if (a.equals(null)) {
            throw new EmptyException();
        } else if (AlcoholCollectionCount == AlcoholCollections.length) {
            throw new CollectionFullException();
        }

        AlcoholCollections[AlcoholCollectionCount] = a;
    }
    public void removeAlcohol(Alcohol a) throws EmptyException, DataNotFoundException {
        if (a.equals(null)) {
            throw new EmptyException();
        }

        for (int i = 0; i < AlcoholCollectionCount; i++) {
            if (a.equals(AlcoholCollections[i])) {
                AlcoholCollections[i] = null;
                return; // STOPS THE WHOLE METHOD HERE
            }
        }

        throw new DataNotFoundException();

    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS


    // ================================================== OTHER CLASSES ================================================== \\
}


// BAR methods will consist of:
//  -> closeBar();
//  -> openBar();
//  -> addAlcohol(Alcohol a);
//  -> removeAlcohol(Alcohol a);