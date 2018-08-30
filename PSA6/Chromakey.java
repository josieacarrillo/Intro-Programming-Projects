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
        original.replaceAllColor(background,Color.green,20).explore();
      Picture oG = new Picture(original.replaceAllColor(background,Color.green,20));

        oG.replaceOldColorInRange(shirt,original,Color.blue,10,10,20,20,25).explore();






    }
}
