//package com.gradescope.psa4part2;

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
 class Picture extends SimplePicture
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

    /**
    *  Convert the picture to "blueScale" by setting the red and green
    * channels to 0 for all pixels in the picture.
    */
    public void blueScale()
    {
        Pixel [] pixelArray = this.getPixels();
        int scaledToZero = 0;

        for (int index = 0; index < pixelArray.length; index++)
        {
          //set R value to 0
          scaledToZero = pixelArray[index].getRed();
          scaledToZero = (int)(scaledToZero*0);
          pixelArray[index].setRed(scaledToZero);
          //set G value to 0
          scaledToZero = pixelArray[index].getGreen();
          scaledToZero = (int)(scaledToZero*0);
          pixelArray[index].setGreen(scaledToZero);
        }
    }

    /**
    *  Scale the red, green and blue channels of each Pixel proportionately
    * to the input value scale.  The red channel is scaled exactly
    * by scale.  The green channel is scaled by 2 times the value of
    * scale.  The blue channel is scaled by half the value of scale.
    * Ensure that none of the color channels are set to anything
    * outside the range [0,255] (even when scale is negative or very large).
    */
    public void multiScale(double scale)
    {
        Pixel [] pixelArray = this.getPixels();



          for (int index = 0; index < pixelArray.length; index ++)
          {
            //create variable
            int rValue = 0;
            int gValue = 0;
            int bValue = 0;
            int scaled = 0;
            //generate RGB values from pixel
            rValue = pixelArray[index].getRed();
            gValue = pixelArray[index].getGreen();
            bValue = pixelArray[index].getBlue();

            //scale Red value and make sure doesnt go out of bound
            scaled = this.putInColorRange((int)(scale*rValue));
            //update the Red value for the pixel
            pixelArray[index].setRed(scaled);

            //scale Green by time 2 and make sure doesnt go out of bound
            scaled = this.putInColorRange((int)(scale*gValue*2));
            //update the Green value for pixelArray
            pixelArray[index].setGreen(scaled);

            //scale Blue by half of the scale and make sure doesnt go out of bound

            scaled = this.putInColorRange((int)(scale*bValue)/2);
            pixelArray[index].setBlue(scaled);



          }
    }


    /**
    *  Modify the colors each Pixel in range from start (inclusive) to end
    * (ALSO INCLUSIVE) in the pixel array of the calling object as follows:
    *    The blue channel gets the (former) value of the red channel
    *    The red channel gets the (former) value of the green channel
    *    The green channel gets the (former) value of the blue channel
    */
    public void rotateRGB(int start, int end) {
      Pixel [] pixelArray = this.getPixels();
      int rValue = 0;
      int gValue = 0;
      int bValue = 0;

        for( int i = start; i < end+1 ; i++)
        {
          rValue = pixelArray[i].getRed();
          gValue = pixelArray[i].getGreen();
          bValue = pixelArray[i].getBlue();

          pixelArray[i].setRed(gValue);

          pixelArray[i].setGreen(bValue);

          pixelArray[i].setBlue(rValue);

        }

    }

    /**
    *  Modify the colors each Pixel in range from start (inclusive) to end
    * (ALSO INCLUSIVE) so that each Pixel's red channel is the average
    * value of the red channel for all of the pixels in that range.
    */
    public void averageRed(int start, int end) {

          int rTotal = 0;

          Pixel [] pixelArray = this.getPixels();


        for ( int i = start; i < end+1; i++)
        {
          rTotal += pixelArray[i].getRed();

          }
          rTotal = (int)(rTotal/(end+1) -start);

          for (int i = start; i < end+1; i++)
           {
            pixelArray[i].setRed(rTotal);
          }
    }


} // this } is the end of class Picture, put all new methods before this
