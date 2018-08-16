/*
 name and IDs go here (see prev homeworks and the other files for template)
 */

/*--------PROGRAM DESCRIPTION----------
 goes here

 */

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
  *  Ensure the value is between 0 and 255.  If it is, return it.
  *  If it is less than 0, return 0.  If it is greater than 255,
  *  return 255.
  */
  public int putInColorRange(int value)
  {
     value = Math.max(value, 0);  // get the max of 0 and the value
     value = Math.min(value, 255);  // get the min of value and 255
     return value;
  }

   /*
    * Method Header goes here
    * Describe: What the method does and what the parameters mean.
    * (See writeup)
    */
    public void scaleColor(double rScale, double gScale, double bScale)
    {
      Pixel [] pixelArray = this.getPixels();
      int scaled = 0;
      for (int index =0; index < pixelArray.length; index++)
      {
        scaled = pixelArray[index].getRed();
        scaled = (int)(rScale*scaled);
        pixelArray[index].setRed(scaled);
        scaled = this.putInColorRange(scaled);

        scaled = pixelArray[index].getGreen();
        scaled = (int)(gScale*scaled);
        pixelArray[index].setGreen(scaled);
        scaled = this.putInColorRange(scaled);

        scaled = pixelArray[index].getBlue();
        scaled = (int)(bScale*scaled);
        pixelArray[index].setBlue(scaled);
        scaled = this.putInColorRange(scaled);


      }
    }


    /*
     * Method Header goes here
     * Describe: What the method does and what the parameters mean.
     * (See writeup)
     */
    public void complement(int start, int end)
    {

      Pixel [] pixelArray = this.getPixels();
       int value = 0;


       for (int i = start; i < end; i++){

         value = pixelArray[i].getRed();
         value = (int)(255-value);
         pixelArray[i].setRed(value);

         value = pixelArray[i].getGreen();
         value = (int)(255-value);
         pixelArray[i].setGreen(value);

         value = pixelArray[i].getBlue();
         value = (int)(255-value);
         pixelArray[i].setBlue(value);
       }
    }

    /*
     * Method Header goes here
     * Describe: What the method does and what the parameters mean.
     * (See writeup)
     */
    public void grayscale(int start, int end)
    {

          Pixel [] pixelArray = this.getPixels();
          Pixel pixel = null;
          int average = 0;
          /*int rScale= 0;
          int gScale = 0;
          int bScale = 0; */


          for (int i = start; i < end; i++)
          {
            pixel = pixelArray[i];
            /*rScale = pixelArray[i].getRed();
            gScale = pixelArray[i].getGreen();
            bScale = pixelArray[i].getBlue();*/

            //average = (int)(((bScale + gScale+ bScale)/ 3));
            average = (int)((pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3);
            average = this.putInColorRange(average);
            pixel.setColor(new Color(average, average, average));

          }
    }


    /*
     * Method Header goes here
     * Describe: What the method does and what the parameters mean.
     * (See writeup)
     */
     public void myFilter(int start, int end)
     {
          Pixel [] pixelArray = this.getPixels();
          int rScale = 0;
          int gScale = 0;
          int bScale = 0;
          Pixel pixel = null;
            for( int i = start; i < end; i++)
            {
              rScale = pixelArray[i].getRed();
              gScale = pixelArray[i].getGreen();
              bScale = pixelArray[i].getBlue();

              pixelArray[i].setRed(bScale);
              pixelArray[i].setGreen(rScale);
              pixelArray[i].setBlue(gScale);

            }

     }

} // this } is the end of class Picture, put all new methods before this
