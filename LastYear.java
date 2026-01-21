import org.code.theater.*;
import org.code.media.*;

public class LastYear extends Scene {

  // Instance variables (and 1D arrays)
  private String[] lastYearImages;   //will contain the images from lastYear.txt
  
  /*
   * No-argument constructor
   */
  public LastYear() {
    //reads the contents of lastYear.txt and stores it in the array
    lastYearImages = FileReader.toStringArray("lastYear.txt");
  }

  /*
   * Parameterized constructor
   */
  public LastYear(String[] lastYearImages) {
    this.lastYearImages = lastYearImages;
  }

  /*
   * Top level drawScene method that uses other methods in the class
   * Precondition: All methods called in drawScene() must exist and work properly
   * Postcondition: The screens and images are properly displayed when the TheaterRunner calls the object
   */
  public void drawScene() {
    System.out.println(returnMessage());
    drawFirstSectionTitle();
    drawFirstSection();
    drawSecondSectionTitle();
    drawSecondSection();
    drawThirdSectionTitle();
    drawThirdSection();
  }

  // other methods

  /*
   * Plays the first 4 images
   * Precondition: The images in lastYearImages must be in the correct order
   * Postcondition: The first four images are properly drawn
   */
  public void drawFirstSection() {
    for (int i = 0; i < 4; i++) {
      drawAndSetFormat(lastYearImages[i]);
      pause(1);
    }
  }

  /*
   * Plays the next 3 images
   * Precondition: The images in lastYearImages must be in the correct order
   * Postcondition: The middle three images are properly drawn
   */
  public void drawSecondSection() {
    for (int i = 4; i < 7; i++) {
      drawAndSetFormat(lastYearImages[i]);
      pause(1);
    }
  }

  /*
   * Plays the last 4 images
   * Precondition: The images in lastYearImages must be in the correct order
   * Postcondition: The last four images are properly drawn
   */
  public void drawThirdSection() {
    for (int i = 7; i < lastYearImages.length; i++) {
      drawAndSetFormat(lastYearImages[i]);
      pause(1);
    }
  }

  /*
   * Displays the title for the first section of images
   * Precondition: Should be declared right before drawFirstSection()
   * Postcondition: The title of the first section is displayed properly before the images
   */
  public void drawFirstSectionTitle() {
    clear("BLACK");
    setTextHeight(60);
    setTextColor("WHITE");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("FIRST PART", 20, 175);
    drawText("OF", 160, 225);
    drawText("2025", 120, 275);
    pause(2);
    clear("BLACK");
  }

  /*
   * Displays the title for the second section of images
   * Precondition: Should be declared right before drawSecondSection()
   * Postcondition: The title of the second section is displayed properly before the images
   */
  public void drawSecondSectionTitle() {
    clear("BLACK");
    setTextHeight(50);
    setTextColor("WHITE");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("SECOND PART", 30, 175);
    drawText("OF", 170, 225);
    drawText("2025", 130, 275);
    pause(2);
    clear("BLACK");
  }

  /*
   * Displays the title for the last section of images
   * Precondition: Should be declared right before drawThirdSection()
   * Postcondition: The title of the third section is displayed properly before the images
   */
  public void drawThirdSectionTitle() {
    clear("BLACK");
    setTextHeight(60);
    setTextColor("WHITE");
    setTextStyle(Font.MONO, FontStyle.BOLD);
    drawText("THIRD PART", 20, 175);
    drawText("OF", 160, 225);
    drawText("2025", 120, 275);
    pause(2);
    clear("BLACK");
  }

  /*
   * Draws the images in a random size and location
   * Precondition: The string parameter must be an image
   * Postcondition: The image is drawn no larger than 350
   */
  public void drawAndSetFormat(String image) {
    //x coordinate no smaller than 10 or larger than 60
    int x = (int)(Math.random() * 51) + 10;
    //y coordinate no smaller than 20 or larger than 70
    int y = (int)(Math.random() * 51) + 20;
    //size no smaller than 250 or larger than 350
    int size = (int)(Math.random() * 101) + 250;
    drawImage(image, x, y, size, 0.0);
  }

  /*
   * Returns a short description of what is displayed
   * Precondition: The scenes should display properly in three parts
   * Postcondition: Returns the correct string
   */
  public String returnMessage() {
    return "My 2025 year in three parts";
  }
}