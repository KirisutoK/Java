import javax.swing.*;

public class HelloWindow {
    public static void main(String[] args) {
        // Create the window
        JFrame frame = new JFrame("My First GUI");
        
        // Create a label with text
        JLabel label = new JLabel("Hi!");
        label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 48));
        label.setHorizontalAlignment(JLabel.CENTER);
        
        // Add label to window
        frame.add(label);
        
        // Set window properties
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center on screen
        
        // Make it visible
        frame.setVisible(true);
    }
}