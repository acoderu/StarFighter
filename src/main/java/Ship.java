import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 * Ship is a concrete class that extends the MovingThing interface
 */
public class Ship extends MovingThing
{
    private int speed;
    private Image image;

    /**
     * Ship default constructor
     */
    public Ship() {
        this(0,0,50,50,0);
    }

    /**
     * Ship constructor with x,y coordinates
     * @param x
     * @param y
     */
    public Ship(int x, int y) {
        this(x,y,50,50, 0);
    }

    /**
     * Ship constructor with x,y  & speed parameters
     * @param x
     * @param y
     * @param s
     */
    public Ship(int x, int y, int s) {
        this(x,y,50,50,s);
    }

    /**
     * Ship constructor with x, y, width , height and speed parameters
     * @param x
     * @param y
     * @param w
     * @param h
     * @param s
     */
    public Ship(int x, int y, int w, int h, int s) {
        //call super since x,y,w,h are stored in the MovingThing abstract class
        super(x,y,w,h);
        //set speed in the ship class since speed is a parameter inside the Ship class
        speed = s;
        //add code here
        try {
            //this sets ship.jpg as the image for your ship
            //for this to work ship.jpg needs to be in the same folder as this .java file
            URL url = getClass().getResource("ship.jpg");
            image = ImageIO.read(url);
        }
        catch(Exception e)
        {
            System.out.println("project accessing resource ship.jpg " + e);
        }
    }


    /**
     *
     * @param s
     */
    public void setSpeed(int s) {
        speed = s;
    }

    /**
     *
     * @return
     */
    public int getSpeed()
    {
        return speed;
        //continue coding
    }

    /**
     * method to handle various move interactions for the ship
     * @param direction
     * //add code here
     * //think about ALL your global variables and how you can use them to "move"
     * //keep your parameter in mind as well
     */
    public void move(String direction)
    {
        if (direction.equals("RIGHT")) {
            //set the X to minimum of 795 or current X + speed.
            //using minimum of the two so ship doesn't go out of bounds
            setX(min(795, getX()+getSpeed()));
        }

        if (direction.equals("LEFT")) {
            //set the X to max of 5 or current x - speed
            //so that the ship doesn't get out of bound on the left hand side
            setX(max(5,getX()-getSpeed()));
        }

        if (direction.equals("UP")) {
            //set the Y to max of 5 or the current Y - speed
            //so that the ship doesn't go out of bounds on the top axis
            setY(max(5,getY()-getSpeed()));
        }

        if (direction.equals("DOWN")) {
            //set the Y to minimum of 595 and currentY+speed
            //this is so that the ship doesnt go out bounds on the bottom of the grid
            setY(min(595,getY()+getSpeed()));
        }
    }

    /**
     * method to draw the ship
     * @param window
     */
    public void draw( Graphics window ) {
        window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
    }

    public String toString() {
        return super.toString() + " " + getSpeed();
    }
}
