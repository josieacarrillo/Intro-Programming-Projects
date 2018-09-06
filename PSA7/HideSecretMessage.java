/* Filename: HideSecretMessage.java
 * Created by:  Christine Alvarado
 * Due Date: 2018, February 26
 *
 * Date:
 * Description: This class is designed to...
 */
public class HideSecretMessage extends Picture
{
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args)
    {
      String fileName = FileChooser.pickAFile();
      Picture orig = new Picture(fileName);
      Picture messagePic = new Picture(fileName2);
      Picture origWithMessage = orig.hideSecretMessage2Bits(messagePic);

      orig.explore();
      message.explore();
      origWithMessage.explore();

      Picture message = origWithMessage.recoverSecretMessage2Bits();
      message.explore();
    }
}
