package Week6;

public class Player {

    //Instance Variables
    private String name;
    private int age;
    private int numGames;
    private int numWins;
    private String tag;

    public Player()
    {
        name = "N/A";
        tag = "N/A";
    }

    public Player(String name, String tag, int age)
    {
        this.name = name;
        this.tag = tag;
        this.age = age;
    }

    public Player(String name, String tag, int age, int numWins, int numGames)
    {
        this(name, tag, age);
        if (numWins <= numGames) {
            this.numWins = numWins;
        }
        else
        {
            numWins = numGames;
        }

        this.numGames = numGames;
    }

    //Mutators
    public void incrementGames(int numGames)
    {
        this.numGames += numGames;
    }

    public void incrementWins(int numWins)
    {
        if (this.numWins + numWins <= numGames)
        {
            this.numWins += numWins;
        }
        else
        {
            this.numWins = numGames;
        }
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setTag(String tag)
    {
        this.tag = tag;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    //Accessors
    public String getName()
    {
        return name;
    }

    public String getTag()
    {
        return tag;
    }

    public int getAge()
    {
        return age;
    }

    public int getNumGames()
    {
        return numGames;
    }

    public int getNumWIns()
    {
        return numWins;
    }

    public String toString()
    {
        return ("Name: " + name + ", Gamertag: " + tag + ", Age: " + age + ", # of Games: " + numGames + ", # of Wins: " + numWins);
    }
}
