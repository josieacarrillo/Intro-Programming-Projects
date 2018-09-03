import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from
 * SimplePicture and allows the student to add functionality to
 * the Picture class.
 *
 * Copyright Georgia Institute of Technology 2004-2005
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture
{
  ///////////////////// constructors //////////////////////////////////

  /**
   * Constructor that takes no arguments
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor
     */
    super();
  }

  /**
   * Constructor that takes a file name and creates the picture
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }

  /**
   * Constructor that takes the width and height
   * @param width the width of the desired picture
   * @param height the height of the desired picture
   */
  public Picture(int width, int height)
  {
    // let the parent class handle this width and height
    super(width,height);
  }

  /**
   * Constructor that takes a picture and creates a
   * copy of that picture
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }

  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }

  ////////////////////// methods ///////////////////////////////////////

  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() +
      " height " + getHeight()
      + " width " + getWidth();

    return output;

  }

   /**
    * Prints the binary representation of the number n to the console
    *  n must be non-negative
    */
  public static void printAsBinaryString(int n)
  {
   if (n < 0) {
    System.out.print("Cannot print " + n + " in binary.  Number must be >= 0");
   }
   else {
    String binaryN = "";
    while (n > 1) {
     binaryN = (n%2) + binaryN;
     n = n/2;
    }
    binaryN = n + binaryN;
    while (binaryN.length() < 8) {
     binaryN = "0" + binaryN;
    }
    System.out.print(binaryN);
   }
  }

/**************  PART 1 METHODS *********************/

/**
  *  TODO: Add header comments and complete this method.  (See writeup)
  */

public Picture hideSecretMessage2Bits(Picture message)
{
  Picture canvas = new Picture(this.getWidth(),this.getHeight());
  for(int x = 0; x < this.getWidth() && x < message.getWidth(); x++){
    for(int y = 0; y < this.getHeight() && y < message.getHeight(); y++){
      Pixel sourcePixel = this.getPixel(x,y);
        Pixel messagePixel = message.getPixel(x,y);
        //grab Pixels colors from calling objects
      int sourceRed = sourcePixel.getRed();
      int sourceGreen = sourcePixel.getGreen();
      int sourceBlue = sourcePixel.getBlue();

      Pixel canvasPixel = canvas.getPixel(x,y);

      canvasPixel.setRed(sourceRed);

      int messageRed = messagePixel.getRed();
    int  canvasRed = canvasPixel.getRed();
     canvasRed = canvasRed>>2<<2;
      int mostSignificant = messageRed>>6;
      canvasRed = mostSignificant|canvasRed;
      canvasPixel.setRed(canvasRed);



    canvasPixel.setBlue(sourceBlue);

      int messageBlue = messagePixel.getBlue();
      int canvasBlue = canvasPixel.getBlue();
        canvasBlue = canvasBlue>>2<<2;
       mostSignificant = messageBlue>>6;
      canvasBlue = mostSignificant|canvasBlue;
      canvasPixel.setBlue(canvasBlue);



     canvasPixel.setGreen(sourceGreen);

      int messageGreen = messagePixel.getGreen();
      int canvasGreen = canvasPixel.getGreen();
       canvasGreen = canvasGreen>>2<<2;
       mostSignificant = messageGreen>>6;
      canvasGreen = mostSignificant|canvasGreen;
     canvasPixel.setGreen(canvasGreen);




    }
  }
  return canvas;
}

/**
  *  TODO: Add header comments and complete this method.  (See writeup)
  */

public Picture recoverSecretMessage2Bits( )
{
return null;  
}

/**************  END OF PART 1 METHODS *********************/

}// this } is the end of class Picture, put all new methods before this
