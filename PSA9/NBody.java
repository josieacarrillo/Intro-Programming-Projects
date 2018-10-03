import java.awt.*;

/**
* This is the primary class that will drive the universe simulation.
*/
public class NBody {

    public static final int CANVAS_WIDTH = 512;
    public static final int CANVAS_HEIGHT = 512;

    // This can be changed to modify the amount of delay between frames.
    private static final int SLEEP_TIME = 10;

    /**
    * Main program driver.
    *
    * @param args Arguments passed in from the command line.
    */
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java NBody [simulationFile]");
            return;
        }

        Picture universe = new Picture(CANVAS_WIDTH, CANVAS_HEIGHT);
        Picture background = new Picture("images/starfield.jpg");

        String file = args[0];

        PlanetReader reader = new PlanetReader(file);
        Body.universeSize = reader.getUniverseSize();
        Body.timeStep = reader.getTimestep();
        Body[] bodies = reader.getPlanets();
        double totalTime = reader.getTotalTime();

        drawBodies(bodies, universe, background);
    }

    /**
    * Helper method that runs the physics simulation on all planets.
    *
    * @param planets Array of all bodies in the system.
    */
    public static void moveBodies(Body[] bodies) {
      for(int i = 0; i < bodies.length; i++){
        Body body = bodies[i].getBody;
         body.updateVelocity();

      }

    }

    /**
    * Helper method that resets the picture of the universe and draws all
    * planets onto it.
    *
    * @param bodies Array of all bodies in the system.
    * @param universe A picture of the universe that wil be shown to the user.
    * @param background The background of the universe.
    */
    public static void drawBodies(Body[] bodies, Picture universe,Picture background)
    {
            for(int i = 0; i < universe.getWidth(); i++){
              for(int i = j; i <universe.getHeight(); j++){
                Pixel sourcePixel = background.getPixel(i,j);
                int sourceRed = sourcePixel.getRed();
                int sourceGreen = sourcePixel.getGreen();
                int sourceBlue = sourcePixel.getBlue();

                Pixel targetPixel = universe.getPixel(i,j);
                targetPixel.setRed(sourceRed);
                targetPixel.setGreen(sourceGreen);
                targetPixel.setBlue(sourceBlue);
              }
            }


    }

    /**
    * You can use this to pause between frames.
    */
    private static void pause() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException interrupt) {}
    }
}
