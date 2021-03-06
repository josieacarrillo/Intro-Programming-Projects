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

    /**************  PART 1 METHODS *********************/
    // INCLUDE THESE IN THEIR OWN VERSION OF Picture.java FOR PART 1

    /**The collage method
    * This method will create the collage of your modified pictures.
    * Hint 1: Inside of the for loop here will be another 2 nested for loops,
    *     giving you a grand total of 3 nested for loops in this method.
    *     If it makes you more comfortable, you are welcome to create and call
    *     a helper method to do each copy.
    * Hint 2: If you're clever about the way you decide to draw your pixels
    *     onto the canvas, you may only have to write ONE LINE OF CODE inside
    *     the inner-most for loop to achieve the desired collage effect!
    *     However, more than one line inside of the nested for loops is
    *     perfectly fine, of course!
    **/
    public void collage(Picture [] pictures)
    {
        int sum = 0;
        for(int i = 0; i < pictures.length; i++){
            Picture picture = pictures [i];

            for (int x = 0; x < picture.getWidth() && x+sum < this.getWidth(); x++){

              for (int y = 0; y < picture.getHeight() && y< this.getHeight(); y++){


                Pixel pixel = picture.getPixel(x,y);
                int rValue = pixel.getRed();
                int gValue = pixel.getGreen();
                int bValue = pixel.getBlue();
                this.getPixel (x+sum,y).setRed(rValue);
                this.getPixel(x+sum,y).setGreen(gValue);
                this.getPixel(x+sum,y).setBlue(bValue);

        }
      }
      sum = sum + picture.getWidth();

        }
    }


    /**
    *  TODO: Add header comment and complete the method
    **/
    public void flipHorizontalRectangle(int x, int y, int width, int height)
    {
        // Think about why you might need this variable
        //Color tempColor = null;
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

    /**
    *  TODO: Add header comment and complete the method
    **/
    public void flipVerticalRectangle(int x, int y, int width, int height)
    {
        // Think about why you might need this variable
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

    /**************  PART 2 METHODS *********************/
    // INCLUDE THESE IN THEIR OWN VERSION OF Picture.java FOR PART 2

    /**
    *  TODO: Add header comments and complete this method.  (See writeup)
    */
    public void copyTo(Picture target, int startX, int startY)
    {
      for( int x = 0; x < this.getWidth() && x+ startX< target.getWidth(); x++ ){
        for(int y = 0; y< this.getHeight()&& y+startY< target.getHeight(); y++){
          int targetX = x + startX;
          int targetY = y+startY;
            Pixel sourcePixel = this.getPixel(x,y);

            Pixel targetPixel = target.getPixel(targetX,targetY);
            //System.out.println("x= " + x + "y ="+ y);
          //  System.out.println("targetX="+ targetX+ "targetY=" + targetY);
            int sourceRed = sourcePixel.getRed();
            int sourceGreen = sourcePixel.getGreen();
            int sourceBlue = sourcePixel.getBlue();
            targetPixel.setRed(sourceRed);
            targetPixel.setGreen(sourceGreen);
            targetPixel.setBlue(sourceBlue);
          // System.out.println("x= " + x + "y ="+ y);
            //System.out.println("targetX="+ targetX+ "targetY=" + targetY);
        }

      }
    }

    /**
    *  TODO: Add header comments and complete this method.  (See writeup)
    */
    public void flipHorizontalInto(Picture canvas, int startX, int startY)
    {
      int right = Math.min(canvas.getWidth(), startX+ this.getWidth());
      int newWidth = right - startX;

      int bottom = Math.min(canvas.getHeight(), startY + this.getHeight());
      int newHeight = bottom - startY;

        this.copyTo(canvas,startX,startY);
      canvas.flipHorizontalRectangle(startX,startY,newWidth,newHeight);

    }

    /**
    *  TODO: Add header comments and complete this method.  (See writeup)
    */
    public void flipVerticalInto(Picture canvas, int startX, int startY)
    {
      int right = Math.min(canvas.getWidth(), startX+ this.getWidth());
      int newWidth = right - startX;

      int bottom = Math.min(canvas.getHeight(), startY + this.getHeight());
      int newHeight = bottom - startY;

        this.copyTo(canvas,startX,startY);
      canvas.flipVerticalRectangle(startX,startY,newWidth,newHeight);

    }

    /**
    *  TODO: Add header comments and complete this method.  (See writeup)
    */
    public void copyAbove(int x, int y, int width, int height, int gap)
    {


        Pixel [][] buffer = new Pixel[height][width];
      for(int j =0; j < buffer.length; j++){
        for(int i =0; i < buffer[j].length; i++){
          Pixel sourcePixel = this.getPixel(x+i, y+j);
          buffer[j][i] = sourcePixel;
        }
      }


        int sourceX = x;
        int sourceY = gap + height;

        for(int bufferY=0; bufferY < buffer.length; bufferY++){
          for(int bufferX =0; bufferX < buffer[bufferY].length; bufferX++){
            int tempRed = buffer[bufferY][bufferX].getRed();
            int tempGreen = buffer[bufferY][bufferX].getGreen();
            int tempBlue = buffer[bufferY][bufferX].getBlue();

            Pixel targetPixel = this.getPixel(sourceX+bufferX, y-sourceY+bufferY);
            targetPixel.setRed(tempRed);
            targetPixel.setGreen(tempGreen);
            targetPixel.setBlue(tempBlue);
          }
        }


    }

    /**
    *  TODO: Add header comments and complete this method.  (See writeup)
    */
    public void copyRight(int x, int y, int width, int height, int gap)
    {

        Pixel [][] buffer = new Pixel[height][width];
        for (int j =0; j< buffer.length; j++){
          for(int i=0; i< buffer[j].length; i++){
            buffer[j][i] = this.getPixel(x+i, y+j);



          }
        }

        // for (int j =0; j< buffer.length; j++){
        //   for(int i =0; i< buffer[j].length; i++){
        //       System.out.println(buffer[j][i]);
        //     }
        //   }



          int sourceX = width + gap;
          int sourceY = y;
          for(int bufferY = 0; bufferY < buffer.length; bufferY++){
            for(int bufferX = 0; bufferX < buffer[bufferY].length; bufferX++){
              //buffer[y][x]= [startY][startX];
            int tempRed = buffer[bufferY][bufferX].getRed();
            int tempGreen = buffer[bufferY][bufferX].getGreen();
            int tempBlue = buffer[bufferY][bufferX].getBlue();

            Pixel targetPixel = this.getPixel(bufferX+sourceX+x,sourceY+bufferY);
            targetPixel.setRed(tempRed);
            targetPixel.setGreen(tempGreen);
            targetPixel.setBlue(tempBlue);
            }
          }
        }




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

    public int putInColorRange(int value)
    {
        value = Math.max(value, 0);  // get the max of 0 and the value
        value = Math.min(value, 255);  // get the min of value and 255
        return value;
    }


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

} // this } is the end of class Picture, put all new methods before this
