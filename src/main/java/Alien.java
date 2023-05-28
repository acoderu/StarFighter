import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 * Alien is a concrete class and extends abstract class MovingThing
 *
 */
public class Alien extends MovingThing {
    //private variables
    private int speed;
    private Image image;
    private boolean isDestroyed;
    /**
     * Default constructor
     */
    public Alien() {
        this(0, 0, 30, 30, 0);
    }

    /**
     * Constructor with x, y coordinate parameters
     *
     * @param x
     * @param y
     */
    public Alien(int x, int y) {
        this(x, y, 30, 30, 0);
    }

    /**
     * Constructor with x,y & speed parameters
     *
     * @param x
     * @param y
     * @param s
     */
    public Alien(int x, int y, int s) {
        this(x, y, 30, 30, s);
        //add code here
    }

    /**
     * Constructor with x,y & width, height & speed parameters
     *
     * @param x
     * @param y
     * @param w
     * @param h
     * @param s
     */
    public Alien(int x, int y, int w, int h, int s) {
        super(x, y, w, h);
        speed = s;
        //add code here
        try {
            URL url = getClass().getResource("alien.JPG");
            image = ImageIO.read(url);
        } catch (Exception e) {
            //when errors occur in creating alien.JPG, exception is thrown and execution
            //comes in this block of code
            System.out.println("cant create alien.JPG " + e);
        }
    }

    /**
     * method returns whether the alien is destroyed
     * @return
     */
    public boolean isDestroyed() {
        return isDestroyed;
    }

    /**
     * method marks that the alien is destroyed
     * @param destroyed
     */
    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    /**
     * Set the speed of the alien
     *
     * @param s
     */
    public void setSpeed(int s) {
        speed = s;
    }

    /**
     * Get the speed of alien
     *
     * @return
     */
    public int getSpeed() {
        return speed;
        //add code
    }

    /**
     * The method is called to move the Alien
     *
     * @param direction -- dont see the use of this parameter in this class
     *
     * //add code here
     * //check that the alien is within the bounds of the screen (see Starfighter.java)
     * //if alien is out of bounds change speed direction
     * //and move the alien down a  row (40 pixels)
     * //constantly change the x position of the alien by the speed
     */
    public void move(String direction) {
        int theSpeed = getSpeed();
        int nextX = getX() + theSpeed;
        //if the alien crosses the boundary on the right side then move the
        //alien down one row. And choose the coordinate of the alien at the right boundary
        //we also change the direction of speed so that the alien moves in the opposite direction
        if (nextX > 800 - getWidth()) {
            nextX = 800 - getWidth();
            setY(getY() + 75); //moving down 40 was causing aliens to overlap
            theSpeed *= -1;
        }

        //this is exactly symmetric to the code above
        //if the alien crosses the left boundary, we set the X coordinate of the alien at the left boundary
        //and move the alien to the next row.
        //we are assuming that the left x starting coordinate of the alien is 25
        if (nextX < 25) {
            nextX = 25;
            setY(getY() + 75); //moving down 40 was causing aliens to overlap
            theSpeed *= -1;
        }
        setX(nextX);
        setSpeed(theSpeed);
    }

    /**
     * The draw method is done for  you.
     * This method will move the alien and update it's location on screen by
     * constantly redrawing it.
     *
     * @param window
     */
    public void draw(Graphics window) {
        //move the alien on each call to draw
        //direction doesn't matter for the alien since alien always moves down
        move(null);
        //draw the alien at the new coordinate after the alien has moved
        window.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
    }

    public String toString() {
        return super.toString() + getSpeed();
    }
}