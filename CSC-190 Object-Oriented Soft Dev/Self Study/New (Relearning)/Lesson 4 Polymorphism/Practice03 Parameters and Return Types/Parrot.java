public class Parrot extends Bird {
    //=======VARIABLES=======//
    private int Vocabulary; // number of words it knows

    //=======CONSTRUCTOR=======// NOTE: IN ORDER TO USE THIS FILES WE NEED A CONSTRUCTOR TO CREATE INSTANCES FROM OTHER FILES
    public Parrot(String Name, int Age, String Species, double WingSpan, int Vocabulary) {
        super(Name, Age, Species, WingSpan);
        this.Vocabulary = Vocabulary;
    }

    //==========GETTERS==========\\ NOTE: TO ACCESS THE PRIVATE VARIABLES AND USE IT TO OTHER FILES

    //==========SETTERS==========\\ NOTE: CHANGES THE VARIABLES ON THIS FILE

    //===========METHODS===========\\ NOTE: THIS ARE THE SPECIFIC PROCESS IN ORDER TO MEET THE DESIRED RESULTS
    public void mimic(String phrase) {
        System.out.println(Name+" mimics: "+phrase);
    }


    // @OVERRIDE
    @Override
    public void makeSound() {
        System.out.println(Name+" says: Hello! Polly wants a cracker!");
    }
    @Override
    public void DisplayInfo() {
        super.DisplayInfo();
        System.out.println("Vocabulary: "+Vocabulary);
    }
}
