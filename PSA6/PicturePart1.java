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
    public Picture replaceAllColor(Picture background,
    Color replaceColor, double tolerance)
    {
        Picture copy = new Picture(this.getWidth(), this.getHeight());
        for( int x = 0; x < this.getWidth(); x++){
          for( int y=0; y < this.getHeight(); y++){
            Pixel sourcePixel = this.getPixel(x,y);
            int sourceRed = sourcePixel.getRed();
            int sourceGreen = sourcePixel.getGreen();
            int sourceBlue = sourcePixel.getBlue();
            copy.getPixel(x,y).setRed(sourceRed);
            copy.getPixel(x,y).setGreen(sourceGreen);
            copy.getPixel(x,y).setBlue(sourceBlue);
          }
        }

        for (int x=0; x < background.getWidth(); x++){
          for (int y=0; y < background.getHeight(); y++){
            Pixel backgroundPixel = background.getPixel(x,y);
            int backgroundRed = backgroundPixel.getRed();
            int backgroundGreen = backgroundPixel.getGreen();
            int backgroundBlue = backgroundPixel.getBlue();

//double colorDistance = copy.getPixel(x,y).colorDistance(replaceColor);
//System.out.println("Color distance ="+ colorDistance);
            if(copy.getPixel(x,y).colorDistance(replaceColor)< tolerance){

              copy.getPixel(x,y).setRed(backgroundRed);
              copy.getPixel(x,y).setGreen(backgroundGreen);
              copy.getPixel(x,y).setBlue(backgroundBlue);
            }
          }
        }
        return copy;
    }

    /**
    * Add your comments here
    */
    public Picture replaceOldColorInRange(Picture shirt, Picture original,
    Color replaceColor, int startX, int startY, int width, int height, double tolerance)
    {
      Picture copy = new Picture(this.getWidth(), this.getHeight());
      for( int x = 0; x < this.getWidth(); x++){
        for( int y=0; y < this.getHeight(); y++){
          Pixel sourcePixel = this.getPixel(x,y);
          int sourceRed = sourcePixel.getRed();
          int sourceGreen = sourcePixel.getGreen();
          int sourceBlue = sourcePixel.getBlue();
          copy.getPixel(x,y).setRed(sourceRed);
          copy.getPixel(x,y).setGreen(sourceGreen);
          copy.getPixel(x,y).setBlue(sourceBlue);
        }
      }

    for(int x = 0; x < original.getWidth(); x++){
      for(int y = 0; y < original.getHeight(); y++){
      Pixel originalPixel =  original.getPixel(x,y);


      }
      }
      for(int j =0; j < height; j++){
        for(int i =0; i < width; i++){
          Pixel sourcePixel = shirt.getPixel(i, j);
          if(originalPixel.colorDistance(replaceColor)< tolerance){
            copy.getPixel(startX +i , startY +j).setPixel(sourcePixel);

            }
     }
     return copy;
    }

} // this } is the end of class Picture, put all new methods before this
