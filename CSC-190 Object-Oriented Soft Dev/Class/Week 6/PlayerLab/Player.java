// Creation Date: March 05, 2026. at 9:59 AM
// Last Modified: March 05, 2026. at 10:39 AM

public class Player {
    //=======VARIABLES=======//
    private String name;
    private String tag;
    private int age;
    private int numGames;
    private int numWins;

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Player() {
        this.name = "player1";
        this.tag = "default_player";
        this.age = 0;
        this.numGames = 0;
        this.numWins = 0;
    }
    public Player(String name, String tag, int age) {
        this.name = name;
        this.tag = tag;
        this.age = age;
        this.numGames = 0;
        this.numWins = 0;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES
    public String getName() {
        return name;
    }
    public String getTag() {
        return tag;
    }
    public int getGamesPlayed() {
        return numGames;
    }
    public int getWins() {
        return numWins;
    }
    public int getLosses() {
        return numWins-getGamesPlayed();
    }
    public double getWinRatio() {
        return (double)numGames/(double)numWins;
    }

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE
    public void setTag(String tag) {
        this.tag = tag;
    }
    public void addGamesPlayed() {
        numGames++;
    }
    public void addWin() {
        numWins++;
    }

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void displayInformation() {
        System.out.println("Name: "+name);
        System.out.println("Tag: "+tag);
        System.out.println("Age: "+age);
        System.out.println("Games Played: "+numGames);
        System.out.println("Wins: "+numWins);
    }

}
