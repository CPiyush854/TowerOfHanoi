// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Piyush Chauhan(cpiyush854)
package towerofhanoi;

import java.util.Observable;

/**
 * the HanoiSOlver class which represents the solution of the towers of hanoi
 * problem
 * 
 * @author cpiyu
 * @version 2021.10.19
 *
 */
@SuppressWarnings("deprecation")
public class HanoiSolver extends Observable {
    private Tower left;
    private Tower right;
    private Tower middle;
    private int numDisks;

    /**
     * the constructor for the HanoiSolver class
     * 
     * @param numDisks
     *            the number of disks
     */
    public HanoiSolver(int numDisks) {
        left = new Tower(Position.LEFT);
        right = new Tower(Position.RIGHT);
        middle = new Tower(Position.MIDDLE);
        this.numDisks = numDisks;
    }


    /**
     * gives us the number of disks
     * 
     * @return how many disks are in the solver
     */
    public int disks() {
        return numDisks;
    }


    /**
     * gets the tower the at the given position
     * 
     * @param pos
     *            the position of the tower
     * @return the tower at that position
     */
    public Tower getTower(Position pos) {
        if (pos == Position.LEFT) {
            return left;
        }
        else if (pos == Position.RIGHT) {
            return right;
        }
        else if (pos == Position.MIDDLE) {
            return middle;
        }
        else {
            return middle;
        }
    }


    /**
     * creates a string of widths of all the disks in the HanoiSolver
     * 
     * @return String the string of all the objects
     */
    public String toString() {

        return left.toString() + middle.toString() + right.toString();
    }


    /**
     * moves a disk from one tower to another
     * 
     * @param source
     *            the original placement of the disk
     * @param destination
     *            where the disk will be moved too
     */
    private void move(Tower source, Tower destination) {
        Disk temp = source.pop();
        destination.push(temp);
        setChanged();
        notifyObservers(destination.position());
    }


    /**
     * gets all the disks in a proper order following the rules of the the
     * towers of hanoi problem
     * 
     * @param currentDisks
     *            the number of disks to be solved
     * @param startPole
     *            the tower where the disk will be moved from
     * @param tempPole
     *            the tower where the disk will be moved to for a temporary
     *            amount of time
     * @param endPole
     *            the tower where the disk will end up
     */
    private void solveTowers(
        int currentDisks,
        Tower startPole,
        Tower tempPole,
        Tower endPole) {
        if (currentDisks == 1) {
            move(startPole, endPole);
        }
        else {
            solveTowers(currentDisks - 1, startPole, endPole, tempPole);
            move(startPole, endPole);
            solveTowers(currentDisks - 1, tempPole, startPole, endPole);
        }
    }


    /**
     * calls the solveTowers method with parameters to solve the towers of hanoi
     * problem
     */
    public void solve() {
        solveTowers(numDisks, left, middle, right);
    }
}
