// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Piyush Chauhan(cpiyush854)
package towerofhanoi;

/**
 * the test class for the HanoiSolver class
 * 
 * @author cpiyu
 * @version 2021.10.19
 */
public class HanoiSolverTest extends student.TestCase {
    private HanoiSolver test;

    /**
     * sets up the objects to be used for testing
     */
    public void setUp() {
        test = new HanoiSolver(6);
    }


    /**
     * tests disks method for the HanoiSolver class
     */
    public void testDisks() {
        assertEquals(6, test.disks());
    }


    /**
     * tests getTower method for the HanoiSolver class
     */
    public void testGetTower() {
        test.getTower(Position.LEFT).push(new Disk(10));
        test.getTower(Position.RIGHT).push(new Disk(20));
        test.getTower(Position.MIDDLE).push(new Disk(30));
        test.getTower(Position.DEFAULT).push(new Disk(20));
        assertEquals(new Disk(10), test.getTower(Position.LEFT).pop());
        assertEquals(new Disk(20), test.getTower(Position.RIGHT).pop());
        assertEquals(new Disk(20), test.getTower(Position.MIDDLE).pop());
        assertEquals(new Disk(30), test.getTower(Position.MIDDLE).pop());
    }


    /**
     * tests toString method for the HanoiSolver class
     */
    public void testToString() {
        test.getTower(Position.LEFT).push(new Disk(10));
        test.getTower(Position.MIDDLE).push(new Disk(20));
        test.getTower(Position.RIGHT).push(new Disk(30));
        assertEquals("[10][20][30]", test.toString());
        System.out.println(test.toString());
    }


    /**
     * tests solve method for the HanoiSolver class
     */
    public void testSolve() {
        test.getTower(Position.LEFT).push(new Disk(60));
        test.getTower(Position.LEFT).push(new Disk(50));
        test.getTower(Position.LEFT).push(new Disk(40));
        test.getTower(Position.LEFT).push(new Disk(30));
        test.getTower(Position.LEFT).push(new Disk(20));
        test.getTower(Position.LEFT).push(new Disk(10));
        test.solve();
        assertEquals(new Disk(10), test.getTower(Position.RIGHT).pop());
        assertEquals(new Disk(20), test.getTower(Position.RIGHT).pop());
        assertEquals(new Disk(30), test.getTower(Position.RIGHT).pop());
        assertEquals(new Disk(40), test.getTower(Position.RIGHT).pop());
        assertEquals(new Disk(50), test.getTower(Position.RIGHT).pop());
        assertEquals(new Disk(60), test.getTower(Position.RIGHT).pop());

    }
}
