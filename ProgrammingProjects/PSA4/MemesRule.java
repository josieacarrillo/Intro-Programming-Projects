public class MemesRule
{
  public static void main (String[] args)
  {
    String fileName =  FileChooser.pickAFile();
    Picture original = new Picture(fileName);

    original.explore();

    Picture copy = new Picture(original);
    copy.grayscale(0,100);
    copy.explore();
  }
}
