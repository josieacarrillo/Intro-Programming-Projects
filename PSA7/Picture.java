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
//this method hides a picture( message) behind the calling object
  */

public Picture hideSecretMessage2Bits(Picture message)
{
  Picture canvas = new Picture(this.getWidth(),this.getHeight());
   System.out.println("message width ="+ message.getWidth());
    System.out.println("message height ="+ message.getHeight());
    System.out.println("canvas width="+ canvas.getWidth());
    //the width is off when hiding message into an image with a different size
  for(int x = 0; x < this.getWidth(); x++){
    for(int y = 0; y < this.getHeight(); y++){
    //  System.out.println("x="+x);
      Pixel sourcePixel = this.getPixel(x,y);

        //grab Pixels colors from calling objects
      int sourceRed = sourcePixel.getRed();
      int sourceGreen = sourcePixel.getGreen();
      int sourceBlue = sourcePixel.getBlue();
      Pixel canvasPixel = canvas.getPixel(x,y);
      canvasPixel.setRed(sourceRed);
      canvasPixel.setBlue(sourceBlue);
      canvasPixel.setGreen(sourceGreen);
      int  canvasRed = canvasPixel.getRed();
      int canvasBlue = canvasPixel.getBlue();
      int canvasGreen = canvasPixel.getGreen();

      if( x < message.getWidth() && y < message.getHeight() ){
        Pixel messagePixel = message.getPixel(x,y);
        int messageRed = messagePixel.getRed();
        int messageBlue = messagePixel.getBlue();
        int messageGreen = messagePixel.getGreen();
        canvasRed = canvasRed>>2<<2;
        int mostSignificant = messageRed>>6;
        canvasRed = mostSignificant|canvasRed;
        canvasPixel.setRed(canvasRed);

       canvasBlue = canvasBlue>>2<<2;
       mostSignificant = messageBlue>>6;
       canvasBlue = mostSignificant|canvasBlue;
       canvasPixel.setBlue(canvasBlue);

       canvasGreen = canvasGreen>>2<<2;
       mostSignificant = messageGreen>>6;
       canvasGreen = mostSignificant|canvasGreen;
       canvasPixel.setGreen(canvasGreen);




      } else{
         canvasPixel.setRed(sourceRed);
         canvasPixel.setBlue(sourceBlue);
         canvasPixel.setGreen(sourceGreen);

      }







    }
  }
  return canvas;

}

/**
  *  TODO: Add header comments and complete this method.  (See writeup)
  */

public Picture recoverSecretMessage2Bits( )
{
  Picture result = new Picture(this.getWidth(),this.getHeight());

  for(int x = 0; x < this.getWidth() && x < result.getWidth(); x++){
    for (int y = 0; y < this.getHeight() && y < result.getHeight(); y++){
      Pixel sourcePixel = this.getPixel(x,y);
      Pixel resultPixel = result.getPixel(x,y);
      //retrieve r value from the hidden picture
      int sourceRed = sourcePixel.getRed();
      int resultRed = resultPixel.getRed();
      int leastSig = sourceRed<<6;
      resultRed = leastSig&resultRed;
      resultPixel.setRed(resultRed);

      //retrieve g value from the hidden Picture

      int sourceGreen = sourcePixel.getGreen();
      int resultGreen = resultPixel.getGreen();
      leastSig = sourceGreen<<6;
      resultGreen = leastSig&resultGreen;
      resultPixel.setGreen(resultGreen);

      //retrieve b value from hidden picture

      int sourceBlue = sourcePixel.getBlue();
      int resultBlue = resultPixel.getBlue();
      leastSig = sourceBlue<<6;
      resultBlue = leastSig&resultBlue;
      resultPixel.setBlue(resultBlue);
    }
  }
return result;

}

/**************  END OF PART 1 METHODS *********************/

}// this } is the end of class Picture, put all new methods before this
