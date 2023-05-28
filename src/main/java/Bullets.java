import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;

/**
 * Bullets class
 */
public class Bullets {
    private List<Ammo> ammo;

    /**
     * Constructor for the Bullets class
     */
    public Bullets() {
        ammo = new ArrayList<Ammo>();
    }

    /**
     * adds a given amo to the list of amm inside the class
     *
     * @param al
     */
    public void add(Ammo al) {
        ammo.add(al);
    }

    /**
     * method to draw all the bullets
     *
     * @param window
     */
    public void drawEmAll(Graphics window) {
        for (int i = 0; i < ammo.size(); i++) {
            ammo.get(i).draw(window);
        }
    }

    /**
     * method moves the collection of the ammo
     */
    public void moveEmAll() {
        for (int i = 0; i < ammo.size(); i++) {
            //direction doesn't matter for ammo since ammo always moves up
            ammo.get(i).move(null);
        }
    }

    /**
     * method to clean up the ammo's that have crossed the grid boundary
     * //for every ammo in the list
     * //if the ammo is out of bounds
     * //remove it
     */
    public void cleanEmUp() {
        //since the older ammo's are at beginning of the list, they need to be removed first
        //hence start from beginning of the list and move towards the end
        for (int i = 0; i < ammo.size(); i++) {
            //only remove an Ammo if its y coordinate is out of the grid's bound at top of the grid
            if (ammo.get(i).getY() < 0) {
                ammo.remove(i);
            }
        }
    }

    public List<Ammo> getList() {
        return ammo;
    }

    public String toString() {
        return "" + ammo;
    }
}
