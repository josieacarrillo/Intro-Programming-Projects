//package com.gradescope.psa6part2;
/* Filename: Picture.java
* Created by: CSE 8A Staff
* Date: Winter 2018
*/

/*----------- Program Description: ------------
* program description goes here
*
*
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
    * Add your comments here
    */
    public void eraseColor(Color eraseColor, int tolerance)
    {
      //Picture s = new Picture();
        for ( int x = 0; x < this.getWidth(); x++){
          for (int y = 0; y < this.getHeight(); y++){
            Pixel pixel = this.getPixel(x,y);
            int sourceRed = pixel.getRed();
            int sourceGreen = pixel.getGreen();
            int sourceBlue = pixel.getBlue();

            if(this.getPixel(x,y).colorDistance(eraseColor) < tolerance){
              pixel.setRed(255);
              pixel.setGreen(255);
              pixel.setBlue(255);
            }
          }

        }

    }

    /**
    * Add your comments here
    */
    public Picture copyRegionIfModified(Picture original, Picture replace,
        int x, int y, int width, int height)
    {
        Picture copy = new Picture(this.getWidth(),this.getHeight());

        for(int startX = 0; startX < original.getWidth(); startX++){
          for(int startY = 0; startY < original.getHeight(); startY++){
          Pixel originalPixel = original.getPixel(startX,startY);
          int originalRed = originalPixel.getRed();
          int originalGreen = originalPixel.getGreen();
          int originalBlue = originalPixel.getBlue();
          Pixel sourcePixel = this.getPixel(startX,startY);
          int sourceRed = sourcePixel.getRed();
          int sourceGreen = sourcePixel.getGreen();
          int sourceBlue = sourcePixel.getBlue();

          copy.getPixel(startX,startY).setRed(sourceRed);
          copy.getPixel(startX,startY).setGreen(sourceGreen);
          copy.getPixel(startX,startY).setBlue(sourceBlue);

          replace.getPixel(startX,startY);


            if(copy.getPixel(x,y).getRed()!= original.getPixel(x,y).getRed() || copy.getPixel(x,y).getGreen()!= original.getPixel(x,y).getGreen() || copy.getPixel(x,y).getBlue()!= original.getPixel(x,y).getBlue()){
              copy.getPixel(x,y).setRed(replaceRed);
              copy.getPixel(x,y).setGreen(replaceGreen);

              copy.getPixel(x,y).setBlue(replaceBlue);

            } else {

              copy.getPixel(x,y).setRed()
            }
          }
        }
        return copy;

    }

} // this } is the end of class Picture, put all new methods before this
