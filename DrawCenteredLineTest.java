public class DrawCenteredLineTest
{
  public static void main (String [] args )
  {
    World w = new World();

    ASCIITurtle pepe = new ASCIITurtle();
    //newSymbol = '|'
    pepe.drawCenteredLine(10, '&');
    
    pepe.drawCenteredLine(15, '$');
  }
}
