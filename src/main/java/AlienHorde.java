import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

/**
 * Class to manage an AlienHorde ( a set of aliens)
 */
public class AlienHorde {
    private List<Alien> aliens;

    /**
     * //and fill with size amount of aliens (75 pixels apart)
     * //if your row is full (out of bounds of screen)
     * //move down a row (75 pixels)
     * //starting point is 25, 50
     * //first add aliens with speed of 0 to make sure you spacing is good
     *
     * @param size indicates number of aliens to create
     */
    public AlienHorde(int size) {
        aliens = new ArrayList<Alien>();

        int x = 25;
        int y = 50;
        //starting point is 25, 50
        //initialize the aliens array
        //and fill with size amount of aliens (75 pixels apart)
        //if your row is full (out of bounds of screen)
        //move down a row use the y methods (75 pixels)
        for (int i = 0; i < size; i++) {
            //setting the speed of the alien as 1, tried experimenting with
            //different speeds and 1 seemed to work well
            add(new Alien(x, y, 1));
            x += 75; //per instructions, the x coordinate of the clients are 75 pixels apart
            if (x + 75 > 800) {
                //if the alien goes out of bound on the right side
                //start the alien from the next row at left side
                x = 25; //since the starting x coordinate of the alien is 25
                y = y + 40; //since the height spacing of the alien is 40
            }
        }
    }

    /**
     * add the Alien
     *
     * @param al
     */
    public void add(Alien al) {
        //add an al to the list
        aliens.add(al);
    }

    /**
     * this method is called to draw all the aliens
     *
     * @param window
     */
    public void drawEmAll(Graphics window) {
        for (int i = 0; i < aliens.size(); i++) {
            aliens.get(i).draw(window);
        }
    }

    /**
     * method called to moves all aliens together
     */
    public void moveEmAll() {
        for (int i = 0; i < aliens.size(); i++) {
            Alien alien = aliens.get(i);
            alien.move("Down");
        }
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
    public String toString() {
        return "" + aliens;
    }
}
