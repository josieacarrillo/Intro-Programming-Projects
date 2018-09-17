//package com.gradescope.psa8part2;
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
    *  TODO: Add header comment and complete the method
    **/
    public void flipVerticalRectangle(int x, int y, int width, int height)
    {
      Picture source = new Picture(this.getWidth(),this.getHeight());
      for(int startX= 0; startX < this.getWidth(); startX++){
        for (int startY = 0; startY < this.getHeight(); startY++){
          Pixel sourcePixel = this.getPixel(startX,startY);


      x = Max(startX,x);
      width = Min(startX + width-1, width);

      y = Max(y,startY);
      height = Min(startY + height-1, height);

      int n = height;
      int start = y;
      int end = y + height- 1;

      for(int column =x; column < x + width; column++){
        for( int i = 0; i < n/2; i++){
          int top = start+ i;
          int bottom = end - i;
          int temp = this.getPixel(column, top).getRed();
          int bottomRed = this.getPixel(column, bottom).getRed();
          this.getPixel(column,top).setRed(bottomRed);
          this.getPixel(column, bottom).setRed(temp);

          int temp2 = this.getPixel(column, top).getGreen();
          int bottomGreen = this.getPixel(column, bottom).getGreen();
          this.getPixel(column,top).setGreen(bottomGreen);
          this.getPixel(column, bottom).setGreen(temp2);

          int temp3 = this.getPixel(column, top).getBlue();
          int bottomBlue = this.getPixel(column, bottom).getBlue();
          this.getPixel(column,top).setBlue(bottomBlue);
          this.getPixel(column, bottom).setBlue(temp3);

}
}
        }
      }


    }

    /**
    *  TODO: Add header comment and complete the method
    **/
    public void flipHorizontalRectangle(int x, int y, int width, int height)
    {
      Picture source = new Picture(this.getWidth(),this.getHeight());
      for(int startX = 0; startX < this.getWidth(); startX++){
        for (int startY = 0; startY < this.getHeight(); startY++){
          Pixel sourcePixel = this.getPixel(startX, startY);


      x = Max(startX,x);
      width = Min(startX + wdith-1, width);

      y = Max(y,startY);
      height = Min(startY + height-1, height);
      int n = width;
      int start = x;
      int end = x + width-1;


      for (int row =y; row < y+ height; row++){
      for(int i = 0; i < n/2; i++){
        int left = start + i;
        int right = end - i;
        int temp = this.getPixel(left,row).getRed();
        int rightRed = this.getPixel(right, row ).getRed();
        this.getPixel(left,row).setRed(rightRed);
        this.getPixel(right, row).setRed(temp);

        int temp2 = this.getPixel(left,row).getGreen();
        int rightGreen = this.getPixel(right, row).getGreen();
        this.getPixel(left,row).setGreen(rightGreen);
        this.getPixel(right, row).setGreen(temp2);

        int temp3 = this.getPixel(left,row).getBlue();
        int rightBlue = this.getPixel(right, row ).getBlue();
        this.getPixel(left,row).setBlue(rightBlue);
        this.getPixel(right, row).setBlue(temp3);


      }
    }

      }
}
    }



} // this } is the end of class Picture, put all new methods before this
