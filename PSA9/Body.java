import java.awt.*;

/**
 * This is a class that represents a single planet, particle, or actor in a
 * system.
 */
public class Body {

    private static final double GRAVITATIONAL_CONSTANT = 6.67E-11;

    public static double timeStep;
    public static double universeSize;

    private double xPosition;
    private double yPosition;
    private double xVelocity;
    private double yVelocity;
    private double mass;
    private Picture image;

    /**
     * Full constructor for this body.
     *
     * @param xPosition The starting x coordinate in the universe.
     * @param yPosition The starting y coordinate in the universe.
     * @param xVelocity The starting momentum in the x direction.
     * @param yVelocity The starting momentum in the y direction.
     * @param mass The mass of the body, used to apply gravity.
     * @param image The picture to draw for this body.
     */
    public Body(double xPosition, double yPosition, double xVelocity,
                double yVelocity, double mass, Picture image) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;
        this.mass = mass;
        this.image = image;
    }

    /**
     * Getter for this body's x position.
     *
     * @return The body's x position, in the universe.
     */
    public double getXPosition()
    {

        return this.xPosition;
    }

    /**
     * Getter for this body's y position.
     *
     * @return The body's y position, in the universe.
     */
    public double getYPosition()
    {

        return this.yPosition;
    }

    /**
     * Getter for the mass of this body.
     *
     * @return The body's mass.
     */
    public double getMass()
    {
        // TODO
        return this.mass;
    }

    /**
     * Get the distance to another body.
     *
     * @param otherBody The body to compare for distance to this one.
     * @return The distance to the other body.
     */
    public double getDistance(Body otherBody)
    {
        double deltaX = (otherBody.getXPosition() - this.getXPosition());
        double deltaY = (otherBody.getYPosition() - this.getYPosition());

        double r = Math.hypot(deltaX,deltaY);
        return r;
    }

    /**
     * Calculate the magnitude of the acceleration between this body and another.
     *
     * @param otherBody The other body to accelerate towards.
     * @return The magnitude of acceleration to the other body.
     */
    public double getAcceleration(Body otherBody)
    {
        double r = this.getDistance(otherBody);
        double a = (GRAVITATIONAL_CONSTANT*(otherBody.getMass()/(r*r)));
        return a;
    }

    /**
     * Apply the acceleration due to gravity on this body from another.
     *
     * @param planet The body to accelerate towards.
     */
    public void updateVelocity(Body otherBody)
    {
      double r = this.getDistance(otherBody);
        double aX = (this.getAcceleration(otherBody)*((otherBody.getXPosition() - this.getXPosition())/r));
        double aY = (this.getAcceleration(otherBody)*((otherBody.getYPosition()-this.getYPosition())/r));
    }

    /**
     * Move the body based on its current velocity.
     */
    public void move()
    {
        // TODO
    }

    /**
     * Calculate the x pixel location where the center of this body will be drawn.
     *
     * @return The x pixel location of the center of this body.
     */
    public int centerXToPixelPosition()
    {
        // TODO
        return 0;
    }

    /**
     * Calculate the y pixel location where the center of this body will be drawn.
     *
     * @return The y pixel location of the center of this body.
     */
    public int centerYToPixelPosition()
    {
        // TODO
        return 0;
    }

    /**
     * Draw the planet for the current frame on the image.
     *
     * @param universe The picture on which to draw the planet.
     */
    public void draw(Picture universe)
    {
        // TODO
    }

    /**
     * Serialize this planet such that it can be read and converted to a planet
     * object from a text file.
     *
     * @return A line that contains all the information about this planet.
     */
    public String toString()
    {
        String serialization = xPosition + " " + yPosition + " " +
                               xVelocity +  " " + yVelocity + " " + mass;
        serialization += " " + image.getFileName();
        return serialization;
    }
}
