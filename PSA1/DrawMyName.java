/* MAKE SURE YOU UPDATE THESE COMMENTS WITH YOUR OWN INFORMATION
 * (And then remove this top instructional comment)
 * File Name: DrawMyName.java
 * Created by:  Shuaiqi Xia, cs8a3 and Tony Xia, cs8a4
 * Due Date:    Oct 8th, 2017
 *
 */

public class DrawMyName
{
    // The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args)
    {
      // This is some starter code, but it has errors.  You will
      // fix these errors and then add your code to draw your name
      // here.  Be sure to remove this comment once you've fixed the
      // errors and started adding your own code.
      World w = new World();

      //Creates a turtle in w at (x,y) (200,100)
      Turtle jose = new Turtle(200,100,w);

      //Make a U shape
      jose.forward(55);
      jose.turn(90)
      jose.forward(30);
      jose.turnRight(90);
      jose.forward(45);
      jose.forward(10);
      jose.turn(90);

    }
}
