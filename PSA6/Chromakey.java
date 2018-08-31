/* Filename: Chromakey.java
* Created by: CSE 8A Staff
* Date: Winter 2018
*/
import java.awt.Color;
public class Chromakey
{
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args)
    {
      String fileName =  FileChooser.pickAFile();
        Picture original = new Picture(fileName);
      //  original.explore();

        String fileName2 =  FileChooser.pickAFile();
        Picture background = new Picture(fileName2);
        //background.explore();

        String fileName3 =  FileChooser.pickAFile();
        Picture shirt = new Picture(fileName3);
        //shirt.explore();
        Color green = new Color(0,255,0);

      Picture oG = original.replaceAllColor(background,green,200);
      oG.explore();

      Picture finalImage = oG.replaceOldColorInRange(shirt,original,Color.white,480,220,300,300,150);
      finalImage.explore();






    }
}
