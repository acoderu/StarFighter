import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;

public class Alien extends MovingThing
{
    private int speed;
    private Image image;

    public Alien()
    {
        this(0,0,30,30,0);
    }

    public Alien(int x, int y)
    {
        this(x,y,30,30, 0);
        //add code here
    }

    public Alien(int x, int y, int s)
    {
        this(x,y,30,30, s);
        //add code here
    }

    public Alien(int x, int y, int w, int h, int s)
    {
        int xcord = x;
        int ycord = y;
        int width = w;
        int height = h;
        int speed = s;
        //add code here
        try
        {
            URL url = getClass().getResource("alien.jpg");
            image = ImageIO.read(url);
        }
        catch(Exception e)
        {
            //feel free to do something here
        }
    }

    public void setSpeed(int s)
    {
       speed = s;
        //add code
    }

    public int getSpeed()
    {
        return speed;
        //add code
    }

    public void move(String direction)
    {
        //add code here
        //check that the alien is within the bounds of the screen (see Starfighter.java)
        //if alien is out of bounds change speed direction
        //and move the alien down a  row (40 pixels)
        //constantly change the x position of the alien by the speed
    }

    /* The draw method is done for  you.
    This method will move the alien and update it's location on screen by
    constantly redrawing it.
    */
    public void draw( Graphics window )
    {
        move("DOWN");
        window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
    }

    public String toString()
    {
        return super.toString() + getSpeed();
    }
}