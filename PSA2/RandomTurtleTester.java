/* Filename: RandomTurtleTester.java
* Created by:
* Date:
*/
import java.util.*;
public class RandomTurtleTester {
    //The line below is magic, you don't have to understand it (yet)
    public static void main (String[] args) {
       //Put all your code to test the random turtle walk here
       //Then REMOVE THIS COMMENT.
       World world1 = new World();
       Turtle turtle0 = new Turtle(world1);
       turtle0.takeStep(-1);
       turtle0.takeStep(1);

       World world2 = new World();
       Turtle turtle1 = new Turtle(world2);

       Random random1 = new Random();


       int deltaX = turtle1.takeNSteps(5, random1);
       System.out.println("Turtle 1 took 5 steps and ended in position" + deltaX);

       Turtle turtle2 = new Turtle(world2);

       Random random2 = new Random();


       int deltaX2 = turtle2.takeNSteps(2, random2);
       System.out.println("Turtle 2 took 2 steps and ended in position" + deltaX2);

       Turtle turtle3 = new Turtle(world2);

       Random random3 = new Random();


       int deltaX3 = turtle3.takeNSteps(7, random3);
       System.out.println("Turtle 3 took 7 steps and ended in position" + deltaX3);


       Turtle turtle4 = new Turtle(world2);

       Random random4 = new Random();


       int deltaX4 = turtle4.takeNSteps(2, random4);
       System.out.println("Turtle 1 took 2 steps and ended in position" + deltaX4);










    }
}
