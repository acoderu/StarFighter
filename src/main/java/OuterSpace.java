import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;

/**
 * OuterSpace is a class that extends Canvas and implements the various drawing related interactions
 */
public class OuterSpace extends Canvas implements KeyListener, Runnable {
    // uncomment and comment as necessary as you add functionality to your project*
    private AlienHorde horde;
    //private Bullets shots;
    private Ship ship;
    private Alien alienOne;
    private Alien alienTwo;

    private boolean[] keys;
    private BufferedImage back;

    /**
     * Default Constructor for OuterSpace
     */
    public OuterSpace() {
        setBackground(Color.black);

        keys = new boolean[5];
        ship = new Ship(310, 450, 5);
        //instantiate what you need as you need it (from global objects above)
        //(one at position: 100,50 and one at 150,50).
        alienOne = new Alien(100, 50);
        alienTwo = new Alien(150, 50);
        horde = new AlienHorde(20);
        this.addKeyListener(this);
        new Thread(this).start();
        setVisible(true);
    }

    public void update(Graphics window) {
        paint(window);
    }

    //the top part of the paint method is done for you
    public void paint(Graphics window) {
        //set up the double buffering to make the game animation nice and smooth
        Graphics2D twoDGraph = (Graphics2D) window;

        //take a snap shot of the current screen and save it as an image
        //that is the exact same width and height as the current screen
        if (back == null)
            back = (BufferedImage) (createImage(getWidth(), getHeight()));

        //create a graphics reference to the back ground image
        //we will draw all changes on the background image
        Graphics graphToBack = back.createGraphics();
        //this sets the background for the graphics window
        graphToBack.setColor(Color.BLACK);
        graphToBack.fillRect(0, 0, getWidth(), getHeight());

        //add code to move Ship, Alien, etc.-- Part 1
        //various interactions to move the ship
        if (keys[0]) {
            ship.move("LEFT");
        }
        if (keys[1]) {
            ship.move("RIGHT");
        }
        if (keys[2]) {
            ship.move("UP");
        }
        if (keys[3]) {
            ship.move("DOWN");
        }
        //add code to fire a bullet - Part 3

        //add in collision detection to see if Bullets hit the Aliens and if Bullets hit the Ship -- Part 3

        //make sure you've drawn all your stuff
        ship.draw(graphToBack);

        //commenting the two aliens out since they interfere with the AlineHorde interactions
        //alienOne.draw(graphToBack);
        //alienTwo.draw(graphToBack);
        horde.moveEmAll();
        horde.drawEmAll(graphToBack);
        twoDGraph.drawImage(back, null, 0, 0);
        back = null;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[0] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keys[1] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keys[2] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keys[3] = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            keys[4] = true;
        }
        repaint();
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            keys[0] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            keys[1] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            keys[2] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keys[3] = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            keys[4] = false;
        }
        repaint();
    }

    public void keyTyped(KeyEvent e) {
        //no code needed here
        //method needs to be implemented
        //because class implements KeyListner
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(5);
                repaint();
            }
        } catch (Exception e) {
            //feel free to add something here, or not
        }
    }
}

