package Quest;

// Creation Date: April 07, 2026. at 10:31 AM
// Last Modified: April 07, 2026. at 11:09 AM

import Item.Item;
import Quest.TimerTypes.DailyQuest;
import Quest.TimerTypes.MonthlyQuest;
import Quest.TimerTypes.WeeklyQuest;

public abstract class Quest
        implements DailyQuest, MonthlyQuest, WeeklyQuest {
    //=======VARIABLES=======//
    protected String Title;
    protected String QuestID;
    protected String Description;
    protected double CurrentProgress;
    protected final double TargetProgress = 100.0;
    protected double RewardPoints;
    protected Item[] Drops;
    protected boolean isCompleted;
    protected boolean isActive;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Quest(String Title, String QuestID, String Description, double RewardPoints) {
        this.Title = Title;
        this.QuestID = QuestID;
        this.Description = Description;
        CurrentProgress = 0;
        this.RewardPoints = RewardPoints;
        this.isCompleted = false;
        this.isActive = false;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    // [{CONCRETE}]
    public double getCompletionProgress() {
        return CurrentProgress;
    }

    // [{ABSTRACT}]
    public abstract void checkCompletion();
    public abstract String getProgressDescription();
    public abstract void rewardCalculations();
    

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    // [{CONCRETE}]
    public void startQuest() {
        isActive = true;
    }
    public void updateProgress(double amount) {
        CurrentProgress = amount;
    }
    public void completeQuest() {
        isCompleted = true;
        isActive = false;
    }

    // [{ABSTRACT}]

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
}
