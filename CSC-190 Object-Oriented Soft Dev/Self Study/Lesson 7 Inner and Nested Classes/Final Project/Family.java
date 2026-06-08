// Creation Date: June 08, 2026. at 11:28 AM
// Last Modified: June 08, 2026. at 12:19 PM

import Interfaces.Actions;
import Interfaces.ParentActions;

import java.util.ArrayList;

public class Family {
    //=======VARIABLES=======//
    private String FamilyName;
    private ArrayList<FamilyMember> Members;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Family(String FamilyName) {
        this.FamilyName = FamilyName;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    void addFamilyMember(FamilyMember member) {
      Members.add(member);
    }
    void removeFamilyMember(FamilyMember member) {
        Members.remove(member);
    }

    // ================================================== OTHER CLASSES ================================================== \\
    public class FamilyMember{
        //=======VARIABLES=======//

        //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES

        //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

        //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

        //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS

        // ================================================== OTHER CLASSES ================================================== \\

        public class Mother implements ParentActions, Actions {
            //=======VARIABLES=======//
            private String FirstName;
            private String LastName;
            private String MiddleInitial;
            private int Age;

            //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
            public Mother(String FirstName, String LastName, String MiddleInitial, int Age) {
                this.FirstName = FirstName;
                this.LastName = LastName;
                this.MiddleInitial = MiddleInitial;
                this.Age = Age;
            }

            //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
            public String getFullName() {
                return FirstName+" "+MiddleInitial+" "+LastName;
            }
            public int getAge() {
                return Age;
            }

            //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

            //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
            // [CHILDREN'S INTERFACE]
            @Override public void leaveHouse(String reason) {
                System.out.println("Mother has left the house for "+reason);
            }
            // [PARENTS INTERFACE]
            @Override public void callFamilyMeeting(String Location, String Time) {
                System.out.println("Mother has called for a family meeting!");
                System.out.println("Location: "+Location);
                System.out.println("Time: "+Time);
            }
            // ================================================== OTHER CLASSES ================================================== \\

        }

        public class Father {

        }


    }
}
