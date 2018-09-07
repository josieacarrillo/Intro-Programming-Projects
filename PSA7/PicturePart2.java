//package com.gradescope.psa7part2;
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

/**************  PART 2 METHODS *********************/

  /**
    *  TODO: Add header comments and complete this method.  (See writeup)
    */
  public static int mostSignificant3( int num )
  {
    int newNumber = num>>5;
    return newNumber;

  }

  /**
    *  TODO: Add header comments and complete this method.  (See writeup)
    */
  public static int mostSignificantN( int num, int N )
  {
    int shift = (8-N);
    int newNumber= num>>shift;
    return newNumber;

  }

  /**
    *  TODO: Add header comments and complete this method.  (See writeup)
    */
  public int hideMessageInNBits(int contextVal, int messageVal, int n){
    contextVal = contextVal>>n<<n;
    contextVal = contextVal|messageVal;
    return contextVal;

  }

  /**
    *  TODO: Add header comments and complete this method.  (See writeup)
    */
  public Picture hideSecretMessageNBits(Picture message, int nBits )
  {
    Picture copy = new Picture(this.getWidth(),this.getHeight());
    for(int x = 0; x < this.getWidth() && x < message.getWidth(); x++){
      for(int y = 0; y < this.getHeight() && y < message.getHeight(); y++){
        Pixel sourcePixel = this.getPixel(x,y);
          Pixel messagePixel = message.getPixel(x,y);
          int sourceRed = sourcePixel.getRed();
          int sourceGreen = sourcePixel.getGreen();
          int sourceBlue = sourcePixel.getBlue();
        Pixel copyPixel = copy.getPixel(x,y);

        copyPixel.setRed(sourceRed);
        int messageRed = messagePixel.getRed();
        int copyRed = copyPixel.getRed();

        messageRed = mostSignificantN(messageRed,nBits);
        copyRed = hideMessageInNBits(copyRed,messageRed,nBits);
        copyPixel.setRed(copyRed);

        copyPixel.setGreen(sourceGreen);
        int messageGreen = messagePixel.getGreen();
        int copyGreen = copyPixel.getGreen();

        messageGreen = mostSignificantN(messageGreen,nBits);
        copyGreen = hideMessageInNBits(copyGreen,messageGreen,nBits);
        copyPixel.setGreen(copyGreen);


        copyPixel.setBlue(sourceBlue);
        int messageBlue = messagePixel.getBlue();
        int copyBlue = copyPixel.getBlue();

        messageBlue =mostSignificantN(messageBlue,nBits);
        copyBlue = hideMessageInNBits(copyBlue,messageBlue,nBits);
        copyPixel.setBlue(copyBlue);


}
}
return copy;

  }

  /**************  END OF PART 2 METHODS *********************/
}// this } is the end of class Picture, put all new methods before this
