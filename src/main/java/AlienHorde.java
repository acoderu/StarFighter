import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

public class AlienHorde
{
    private List<Alien> aliens;

    public AlienHorde(int size)
    {
        aliens = new ArrayList<Alien>();
        //initalize ArrayList

        //and fill with size amount of aliens (75 pixels apart)
        //if your row is full (out of bounds of screen)
        //move down a row (75 pixels)
        //starting point is 25, 50
        //first add aliens with speed of 0 to make sure you spacing is good

    }

    public void add(Alien al)
    {
        add(al);
        //add an al to the list
    }

    public void drawEmAll(Graphics window) {
        for (int i = 0; i < aliens.size(); i++)
        {
            aliens.get(i).draw(window);
        }
        // make sure you draw all aliens in the list
    }

    public void moveEmAll() {
        for (int i = 0; i < aliens.size(); i++)
        {
            aliens.get(i).move("DOWN");
        }
        // make sure you move all aliens in the list
    }
    /*
       public void removeDeadOnes(List<Ammo> shots)
        {
          //Part 3
          //for every shot in the list
          //check if you've hit any alien in the list
          //(do the coordinates of the shot fall between the boundarises of the alien)
          //if they do then remove the alien and the shot
          //make sure you break out of the loop if this happens
        }
    */
    public String toString()
    {
        return "" + aliens;
    }
}
