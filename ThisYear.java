import org.code.theater.*;
import org.code.media.*;

public class ThisYear extends Scene {

  // Instance variables (and 1D arrays)
  private String[] thisYearImages;            //will contain contain the four images for this year
  private String thisYearBG = "goals2.png";   //the background image for the "this year" section
  
  /*
   * No-argument constuctor
   */
  public ThisYear() {
    thisYearImages = new String[] {"sleep2.png", "test2.png", "five2.png", "travel2.png"};
  }

  /*
   * Parameterized constuctor
   */
  public ThisYear(String[] thisYearImages) {
    this.thisYearImages = thisYearImages;
  }

  /*
   * Top level drawScene method that uses other methods in the class
   * Precondition: All methods called in drawScene() must exist and work properly
   * Postcondition: The screens and images are properly displayed when the TheaterRunner calls the object
   */
  public void drawScene() {
    drawTitleScreen();
    drawThisYear(3);
    clear("BLACK");
  }

  // other methods

  /*
   * Displays the title for the images
   * Precondition: Should be declared right before drawThisYear()
   * Postcondition: The title of the thisYearImages is displayed properly before the images
   */
  public void drawTitleScreen() {
    drawImage(thisYearBG, 0, 0, 400, 0.0);
    setTextHeight(60);
    setTextColor("BLACK");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("MY GOALS", 55, 200);
    drawText("THIS YEAR", 40, 250);
    pause(2);
    drawImage(thisYearBG, 0, 0, 400, 0.0);
  }

  /*
   * Draws a tile arrangement
   * Precondition: Images should be a square
   * Postcondition: Images are displayed in a tile arrangement with a black border
   */
  public void drawThisYear(int size) {
    //Draws a black square to act as the border of the images
    int[] points = {44, 44, 356, 44, 356, 356, 44, 356};
    drawShape(points, true);
    //Creates variables for the right dimensions of the image tiles
    int tileSize = getTileSize(size);
    int width = getWidth() - 100;
    int height = getHeight() - 100;
    int index = 0;
    //Draws the images with a nested for-loop that checks if the x and y coordinates are still in the correct dimensions
    for (int y = 50; y < height; y += tileSize) {
      for (int x = 50; x < width; x += tileSize) {
        drawImage(thisYearImages[index], x, y, tileSize);
        pause(1); //Staggers image drawing
        index++;
      }
    }  
  }

  /*
   * Determines the size of the image tiles
   * Precondition: Size parameter must be 1, 2, 3, or 4
   * Postcondtion: Returns the corresponding integer for the size
   */
  public int getTileSize(int size) {
    if (size == 1) {
      return 400;
    } else if (size == 2) {
      return 200;
    } else if (size == 3) {
      return 150;
    } else {
      return 100;
    }
  }
}