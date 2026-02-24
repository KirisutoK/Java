public class SocialMediaPost {
    // data field encapsulation
    // immutable: the author and timestamp shouldn't change after posting
    private final String author;
    private final String timestamp;
    private String caption; // mutable: allows for "edit post" functionality
    private int likes;      // primitive variable

    // static constant: the platform name is shared and never changes
    public static final String PLATFORM = "Discordbookstagram";

    // static variable: tracks total posts across the entire platform
    private static int totalPostsCreated = 0;

    // constructor: defines how to create a post object
    public SocialMediaPost(String author, String caption) {
        // the 'this' reference: connects parameters to fields
        this.author = author;
        this.caption = caption;
        this.timestamp = "Feb 23, 2026"; 
        this.likes = 0;
        totalPostsCreated++; // accessing a static variable
    }

    // accessor (getter): lets us read the private caption
    public String getCaption() {
        return this.caption;
    }

    // mutator (setter): lets us update the private caption
    public void setCaption(String newCaption) {
        this.caption = newCaption;
    }

    public void addLike() {
        this.likes++;
    }

    // static method: belongs to the class itself, not a specific post
    public static int getTotalPosts() {
        return totalPostsCreated;
    }

    public String getPostDetails() {
        return author + " [" + PLATFORM + "]: " + caption;
    }
}