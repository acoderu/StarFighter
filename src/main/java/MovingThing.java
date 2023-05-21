import java.awt.Color;
import java.awt.Graphics;

/**
 * An abstract class that implements the Moveable interface
 */
public abstract class MovingThing implements Moveable {
    //add instance variables (look at your constructors)
    private int xxcord;
    private int yycord;
    private int wwidth;
    private int hheight;

    public MovingThing() {
        this(10, 10, 10, 10);
    }

    public MovingThing(int x, int y) {
        this(x, y, 10, 10);
        //add code here
    }

    public MovingThing(int x, int y, int w, int h) {
        xxcord = x;
        yycord = y;
        wwidth = w;
        hheight = h;
        //add code here
    }

    //add necessary implementations (look at interface)
    public void setPos(int x, int y) {
        xxcord = x;
        yycord = y;
    }

    public void setX(int x) {
        xxcord = x;
    }

    public void setY(int y) {
        yycord = y;
    }

    public int getX() {
        return xxcord;
    }

    public int getY() {
        return yycord;
    }

    public int getWidth() {
        return wwidth;
    }

    public int getHeight() {
        return hheight;
    }

    public void setWidth(int w) {
        wwidth = w;
    }

    public void setHeight(int h) {
        hheight = h;
    }


    //do not change code below this line
    public abstract void move(String direction);

    public abstract void draw(Graphics window);

    public String toString() {
        return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
    }
}