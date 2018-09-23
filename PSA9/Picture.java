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
                        " height " + getHeight() +
                        " width " + getWidth();
        return output;
    }


    /**
     * Blend the calling object pic into the parameter Picture
     * object with the upper left corner at (x, y)
     * Input: x - The background's top left corner x coordinate
     *        y - The background's top left corner y coordinate
     *        background - The background picture to blend into
     * Returns: nothing
     */
    public void alphaBlending(int x, int y, Picture background)
    {

      x = Math.max(0,x);
      y = Math.max(0,y);




      for( int i = 0; i < this.getWidth() && i + x < background.getWidth(); i++ ){
        for(int j = 0; j < this.getHeight()&& j + y < background.getHeight(); j++){
          int backgroundX = i + x;
          int backgroundY = j + y;
            Pixel sourcePixel = this.getPixel(i,j);
            int sourceRed = sourcePixel.getRed();
            int sourceGreen = sourcePixel.getGreen();
            int sourceBlue = sourcePixel.getBlue();

            double alphaSource = sourcePixel.getAlpha();

            Pixel targetPixel = background.getPixel(backgroundX,backgroundY);
             int targetRed = targetPixel.getRed();
             int targetGreen = targetPixel.getGreen();
             int targetBlue = targetPixel.getBlue();



             targetRed = (int)(( alphaSource / 255 * sourceRed ) + ((1 - alphaSource) / 255 ) * targetRed);
             targetGreen = (int)((alphaSource / 255 * sourceGreen) + (( 1 - alphaSource)/255) * targetGreen);
             targetBlue = (int) ((alphaSource / 255 * sourceBlue) + ((1 - alphaSource)/ 255) * targetBlue);
            targetPixel.setRed(targetRed);
            targetPixel.setGreen(targetGreen);
            targetPixel.setBlue(targetBlue);


    }
  }
}

} // this } is the end of class Picture, put all new methods before this
