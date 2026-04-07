package Quest.ObjectiveTypes;

// Creation Date: April 07, 2026. at 11:00 AM
// Last Modified: April 07, 2026. at 11:10 AM

import Quest.Quest;

public class CollectionQuest extends Quest {
    //=======VARIABLES=======//
    private int CurrentCollectibles;
    private int TargetCollectibles;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public CollectionQuest(String Title, String QuestID, String Description, double RewardPoints, int TargetCollectibles) {
        super(Title, QuestID, Description, RewardPoints);
        this.TargetCollectibles = TargetCollectibles;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    // [{ABSTRACT}]
    public void checkCompletion() {
        
    }
    public String getProgressDescription() {
        return "";
    }
    public void rewardCalculations() {

    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
