//image source: https://pixabay.com/photos/sunflowers-vase-bouquet-flowers-1719119/
//this image is in the same folder and labeled as sunflowers.png

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.Color;

public class ImageFilterInvert {
    public static void main(String[] args) {
        try {
            // 1. READ THE IMAGE
            File inputFile = new File("C:\\Users\\kiris\\OneDrive - Finger Lakes Community College\\Documents\\FLCC\\Coding\\Java\\References\\Professor Paige Labar\\2D Arrays\\sunflowers.png");
            BufferedImage img = ImageIO.read(inputFile);

            // Get dimensions (The 2D Array limits)
            int width = img.getWidth();
            int height = img.getHeight();

            System.out.println("Processing image: " + width + "x" + height);

            // 2. PROCESS (Loop through the 2D grid)
            // Outer loop: Columns (x)
            for (int x = 0; x < width; x++) {
                // Inner loop: Rows (y)
                for (int y = 0; y < height; y++) {
                    
                    // Get the color at this coordinate [x][y]
                    int rgba = img.getRGB(x, y);
                    Color col = new Color(rgba, true);
                    
                    // Invert the colors (255 - value)
                    int r = 255 - col.getRed();
                    int g = 255 - col.getGreen();
                    int b = 255 - col.getBlue();
                    
                    // Create new color and put it back into the array
                    Color newCol = new Color(r, g, b);
                    img.setRGB(x, y, newCol.getRGB());
                }
            }

            // 3. WRITE THE OUTPUT
            File outputFile = new File("sunflowers-inverted.png");
            ImageIO.write(img, "png", outputFile);
            
            System.out.println("Success! Saved as sunflowers-inverted.png");

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}