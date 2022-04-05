package towerofhanoi;

import java.util.Observable;
import java.util.Observer;
import cs2.Button;
import cs2.Shape;
import cs2.Window;
import cs2.WindowSide;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Piyush Chauhan(cpiyush854)

/**
 * the PuzzleWindow class creates all the GUI objects that the user is able to
 * see
 * 
 * @author cpiyu
 * @version 2021.10.10
 *
 */
@SuppressWarnings("deprecation")
public class PuzzleWindow implements Observer {
    private HanoiSolver game;
    private Shape left;
    private Shape right;
    private Shape middle;
    private Window window;
    public static final int WIDTH_FACTOR = 12;
    public static final int DISK_GAP = 0;
    public static final int DISK_HEIGHT = 10;

    /**
     * the constructor for the PuzzleWindow class
     * 
     * @param game
     *            an object of the HanoiSolver class
     */
    public PuzzleWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window();
        window.setTitle("Tower of Hanoi");
        left = new Shape(50, window.getGraphPanelHeight() / 3, 10, 75);
        right = new Shape(window.getGraphPanelWidth() - 75, window
            .getGraphPanelHeight() / 3, 10, 75);
        middle = new Shape((0 + window.getGraphPanelWidth()) / 2, window
            .getGraphPanelHeight() / 3, 10, 75);

        for (int i = 7; i >= 0; i--) {
            Disk temp = new Disk(i * WIDTH_FACTOR);
            game.getTower(Position.LEFT).push(temp);
            moveDisk(Position.LEFT);
            window.addShape(temp);
        }
        window.addShape(left);
        window.addShape(right);
        window.addShape(middle);
        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.NORTH);
        solve.onClick(this, "clickedSolve");
    }


    /**
     * pauses between disk movements
     */
    private void sleep() {
        try {
            Thread.sleep(500);
        }
        catch (Exception e) {
        }
    }


    /**
     * initiates the solution of the towers of hanoi problem
     * 
     * @param button
     *            the solve button that will initiate the solution
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * moves the disk to the proper spot on the proper tower
     * 
     * @param position
     *            the position of the towr the disk will be moved too
     */
    private void moveDisk(Position position) {
        Disk currentDisk = game.getTower(position).peek();
        Shape currentPole;
        if (position == Position.LEFT) {
            currentPole = left;
        }
        else if (position == Position.RIGHT) {
            currentPole = right;
        }
        else {
            currentPole = middle;
        }
        currentDisk.moveTo(currentPole.getX() + currentPole.getWidth() / 2
            - (currentDisk.getWidth() / 2), currentPole.getY() + currentPole
                .getHeight() - ((game.getTower(position).size() * 10)));
    }


    /**
     * updates the window with the changes
     * 
     * @param o
     *            an Observable object
     * @param arg
     *            an object to be passed
     */
    public void update(
        @SuppressWarnings("deprecation") Observable o,
        Object arg) {
        if (arg.getClass() == Position.class) {
            Position newPos = (Position)arg;
            moveDisk(newPos);
            sleep();
        }
    }

}
