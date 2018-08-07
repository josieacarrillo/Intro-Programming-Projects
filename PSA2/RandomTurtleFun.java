import java.util.Random;
import java.util.ArrayList;
import java.util.List;
public class RandomTurtleFun

{
    public static void main (String [] args)
    {
      World world1 = new World();
      RandomTurtleFun fun = new RandomTurtleFun();

      for (int i = 0; i< 5000; i++){
        fun.turtleFun(world1);
      }

      boolean passed = true;

      int h = world1.getHeight();
      int w = world1.getWidth();

      List turtleList = world1.getTurtleList();

      for (Object turtle : turtleList){
        int tx = ((Turtle)turtle).getXPos();
        int ty = ((Turtle)turtle).getYPos();

        if (tx < 0 || tx > (w-1)) passed = false;
        if (ty < 0 || ty > (h-1)) passed = false;
      }

      String message = (passed) ? "You passed!" : "Failed";

      System.out.println(message);

    /*  World w = new World();
//set variables for max size and thickness for num gen.
  int size = (100);
  int thickness = (10);

//set turtle at random location
      Random generator = new Random();

      int x = generator.nextInt(100);
      int y = generator.nextInt(200);
      final  Turtle t = new Turtle(x +200 , y +200 , w);

      //set variables for size and thickness max

//set turtle to create a random sie of the shapes

      int x2 = generator.nextInt(size);
      int y2 = generator.nextInt(thickness);

      t.createShapes(x2,y2);
// create another random spot for shape

      int x3 = generator.nextInt(size);
      int y3 = generator.nextInt(thickness);

      t.createShapes(x3, y3);

    // create another random spot for shape

      int x4 = generator.nextInt(size);
      int y4 = generator.nextInt(thickness);

      t.createShapes(x4,y4);
*/

}
  public void turtleFun (World w)
  {
  //  World w = new World();
//set variables for max size and thickness for num gen.
int maxSize = (100);
int maxThickness = (10);

//set turtle at random location
    Random generator = new Random();
      int width = w.getWidth();
      int height = w.getHeight();

    int x = generator.nextInt(width);
    int y = generator.nextInt(height);
      Turtle t = new Turtle(x  , y  , w);

    //set variables for size and thickness max

//set turtle to create a random sie of the shapes

     int size = generator.nextInt(maxSize);
     int thickness = generator.nextInt(maxThickness);

    t.createShapes(size,thickness);
// create another random spot for shape
      x = generator.nextInt(width);
      y = generator.nextInt(height);
      t.moveTo(x,y);
      size = generator.nextInt(maxSize);
      thickness = generator.nextInt(maxThickness);

      t.createShapes(size,thickness);

  // create another random spot for shape
      x = generator.nextInt(width);
      y = generator.nextInt(height);
      t.moveTo(x,y);
      size = generator.nextInt(maxSize);
      thickness = generator.nextInt(maxThickness);

    t.createShapes(size, thickness);


  }

}
