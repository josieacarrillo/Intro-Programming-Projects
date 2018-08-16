/* Filename: TestPictures.java
* Created by: CSE 8A Staff
* Date: Winter 2018
*/
public class TestPictures
{
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args)
    {
      String fileName =  FileChooser.pickAFile();
      Picture original = new Picture(fileName);
      //original.show();
      original.explore();

      Picture copy = new Picture(original);

      copy.scaleColor(1.2,2.2,1.2);
     copy.explore();
     //copy.scaleColor(1.2,2.2,3.2);
       //Then REMOVE THIS COMMENT.
    }
}
