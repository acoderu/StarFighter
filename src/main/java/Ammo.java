import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;

/**
 * Ammo is a concrete class that extends MovingThing
 */
public class Ammo extends MovingThing {
    private int speed;
    private boolean isDestroyed;
    /**
     * Default constructor for Ammo
     */
    public Ammo() {
        this(10, 10, 10, 10, 0);
    }

    /**
     * Constructor with x and y specified
     *
     * @param x
     * @param y
     */
    public Ammo(int x, int y) {
        this(x, y, 0);
    }

    /**
     * Constructor with x, y and speed specified.
     *
     * @param x
     * @param y
     * @param s
     */
    public Ammo(int x, int y, int s) {
        //call super to save Ammo details
        super(x, y, 1, 1);
        //set the speed of Ammo
        this.speed = s;
    }

    /**
     * Constructor with x,y, width, height and speed
     *
     * @param x
     * @param y
     * @param w
     * @param h
     * @param s
     */
    public Ammo(int x, int y, int w, int h, int s) {
        super(x, y, w, h);
        speed = s;
    }

    /**
     * returns whether the ammo is destroyed
     * @return
     */
    public boolean isDestroyed() {
        return isDestroyed;
    }

    /**
     * sets that the ammo is destroyed
     * @param destroyed
     */
    public void setDestroyed(boolean destroyed) {
        isDestroyed = destroyed;
    }

    /**
     * Method to set speed of the Ammo
     *
     * @param s
     */
    public void setSpeed(int s) {
        speed = s;
    }

    /**
     * Method to get speed of Ammo
     *
     * @return
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Method to draw Ammo
     *
     * @param window //add code to draw the ammo
     *               //ammo will be a yellow square
     *               //use window.setColor(COLOR) to set the color
     *               //if you don't set a color, your ammo will be black and you will not see it
     *               //use window.fillRect(x,y,w,h); to make a rectangle/square
     */
    public void draw(Graphics window) {
        window.setColor(Color.yellow);
        window.fillRect(getX(), getY(), getWidth(), getHeight());
    }


    /**
     * Move method for Ammo
     *
     * @param direction //add code to move the ammo
     *                  //ship ammo should only move up
     */
    public void move(String direction) {
        //when the Ammo moves, change its location up
        //by its speed.
        //hence, to move the Ammo up, speed must be subtracted from its y coordinate
        setY(getY() - speed);
    }

    public String toString() {
        return super.toString() + getSpeed();
    }
}
