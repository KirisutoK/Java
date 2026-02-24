public class MainWeek5Class {
    public static void main(String[] args) {
        // primitive variable: just a simple number
        int postLimit = 3;

        // reference variable: named object for Paige
        SocialMediaPost post1 = new SocialMediaPost("PaigeL456", "So much snow today! ❄️");

        // array of objects: representing the user's feed
        SocialMediaPost[] feed = new SocialMediaPost[postLimit];
        feed[0] = post1;

        // anonymous object: created directly inside the array for Will
        feed[1] = new SocialMediaPost("WillM789", "The snow is so scenic!");

        // another anonymous object: for Carrie
        feed[2] = new SocialMediaPost("CarrieB123", "Let it snow ❄️");

        // using a mutator (setter): Paige decides to edit her caption
        post1.setCaption("So much snow today! ❄️ #FLCC #CanandaiguaNY");

        // passing objects to methods: sending Paige's post to be printed
        displayPost(post1);

        System.out.println("--- Current Feed ---");
        // scope: 'i' only exists inside this for loop
        for (int i = 0; i < feed.length; i++) {
            System.out.println(feed[i].getPostDetails());
        }
        
        // accessing the static method via the Class name
        System.out.println("\nTotal posts today: " + SocialMediaPost.getTotalPosts());
    }

    // method that accepts a SocialMediaPost object reference as a parameter
    public static void displayPost(SocialMediaPost p) {
        System.out.println("Refreshing post... Updated caption: " + p.getCaption());
    }
}