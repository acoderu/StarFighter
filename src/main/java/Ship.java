import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Ship extends MovingThing
{
    private int speed;
    private Image image;

    public Ship()
    {
        this(0,0,50,50,0);
        // super(0,0,50,50);
        // speed = 0;
    }

    public Ship(int x, int y)
    {
        this(x,y,50,50, 0);
        //add code here
    }

    public Ship(int x, int y, int s)
    {
        this(x,y,50,50,s);
        //add code here
    }

    public Ship(int x, int y, int w, int h, int s)
    {
        super(x,y,w,h);
        speed = s;
        //add code here
        try
        {
            //this sets ship.jpg as the image for your ship
            //for this to work ship.jpg needs to be in the same folder as this .java file
            URL url = getClass().getResource("ship.jpg");
            image = ImageIO.read(url);
        }
        catch(Exception e)
        {
            //feel free to do something here or not
        }
    }


    public void setSpeed(int s)
    {
        speed = s;
        //add more code
    }

    public int getSpeed()
    {
        return speed;
        //continue coding
    }

    //add code here
    //think about ALL your global variables and how you can use them to "move"
    //keep your parameter in mind as well
    public void move(String direction)
    {
        if (direction.equals("RIGHT"))
        {
            setX(min(795, getX()+getSpeed()));
        }

        if (direction.equals("LEFT"))
        {
            setX(max(5,getX()-getSpeed()));
        }

        if (direction.equals("UP"))
        {
            setY(max(5,getY()-getSpeed()));
        }

        if (direction.equals("DOWN"))
        {
            setY(min(595,getY()+getSpeed()));
        }
    }

    public void draw( Graphics window )
    {
        window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
    }

    public String toString()
    {
        return super.toString() + " " + getSpeed();
    }
}
