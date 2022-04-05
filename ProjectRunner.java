// Virginia Tech Honor Code Pledge:
//f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who do.
// -- Piyush Chauhan(cpiyush854)
package towerofhanoi;

/**
 * the ProjectRunner class runs the PuzzleWindow class which will show our project
 * @author cpiyu
 * @version 2021.10.19
 *
 */
public class ProjectRunner {

    /**
     * the main method that will run our program
     * @param args an array holding Strings
     */
    public static void main(String[] args) {
        int disks = 8;
        if(args.length == 1) {
            disks = Integer.parseInt(args[0]);
        }
        PuzzleWindow hanoi = new PuzzleWindow(new HanoiSolver(disks));

    }

}
