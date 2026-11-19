import acm.program.*;
import acm.graphics.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Name: <your name here>
 * 
 * CS 121
 * 
 * Core Topics: Creating Arrays of Objects, Passing Arrays of Objects as Parameters, Returning Arrays of Ojbects
 * from Methods, Determining if an Array of Objects collides with another object
 */
public class ObjectArrays extends GraphicsProgram {

    public static final int APPLICATION_HEIGHT = 800;
    public static final int APPLICATION_WIDTH = 1200;

    public static final int HAY_SIZE = 100;

    GImage cow; // declare cow here so it is visible in all methods like keyPressed

    public void run() {

        // TODO: call createTargets
        

        // create cow image object
        createCow();

        // add key Listener
        addKeyListeners();

        // TODO: call animateTargets after you finished defining the method
        

    }

    /**
     * This method creates an array of Solid Yellow GRect objects. These objects will
     * be animated and represent hay bales. The array size is passed in as a
     * parameter
     *
     * @param size of objects in array
     * @return an array of Solid Yellow GRect objects
     */
    public GRect[] createTargets(int size) {
        GRect[] hay = new GRect[size];

        for (int index = 0; index < hay.length; index++) {
            hay[index] = new GRect(randomCoordinate('x'), randomCoordinate('y'), HAY_SIZE, HAY_SIZE / 2); 
            hay[index].setFilled(true);
            hay[index].setFillColor(Color.YELLOW);

            add (hay[index]);
        }

        return hay;

    }

    /**
     * This method generates an integer coordinate location that is in the current
     * window space.  This method expects an 'x' or 'y' as a coordinate parameter.
     * If 'x' or 'y' is not passed an IllegalArgumentException is thrown.
     *
     * @param coordinate indicates whether x or y coordinate is desired
     * @return an integer coordinate location
     */
    public int randomCoordinate(char coordinate) {
        if (coordinate != 'x' && coordinate != 'y') {
            throw new IllegalArgumentException();
        }

        if (coordinate == 'x') {
            return new Random().nextInt(APPLICATION_WIDTH - HAY_SIZE);
        } else {
            return new Random().nextInt(APPLICATION_HEIGHT - HAY_SIZE / 2);
        }
    }

    /**
     * This method animates the array of targets and checks if a cow has collided with
     * one of the targets.  If so, the target is made invisible. The animation continues until the cow
     * has collided with size targets
     *
     * @param targets
     */
    public void animateTargets(GRect[] targets) {
        // TODO: add code here
    }

    /**
     * This method creates a cow GImage object that the user can move with the up,down,left, and
     * right arrows
     */
    public void createCow() {
        cow = new GImage("cow1.png");
        add(cow, APPLICATION_WIDTH / 2, APPLICATION_HEIGHT - cow.getHeight());
    }

    /**
     * This method moves the cow up, down, left, and right based the keyboard arrow pressed
     *
     * @param e KeyEvent for key pressed
     */
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            cow.move(0, -10);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            cow.move(0, 10);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            cow.move(-10, 0);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            cow.move(10, 0);
        }
    }

    /**
     * Launches an empty application window
     *
     * @param args not used
     */
    public static void main(String[] args) {
        new ObjectArrays().start();
    }
}

