/*
    We will be using what we call Abstract which tells the code or class that it MUST need a children when creating instances into the main
*/

public abstract class Animals {
    private String name;

    public Animals(String n) {
        this.name = n;
    }

    public void Talk() {
        System.out.println("Talk");
    }

}  
