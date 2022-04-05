// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Piyush Chauhan(cpiyush854)
package towerofhanoi;

/**
 * the test class for the Tower class
 * 
 * @author cpiyu
 * @version 2021.10.19
 *
 */
public class TowerTest extends student.TestCase {
    private Tower right;
    private Tower left;
    private Tower middle;

    /**
     * sets up the objects to be used for testing
     */
    public void setUp() {
        right = new Tower(Position.RIGHT);
        left = new Tower(Position.LEFT);
        middle = new Tower(Position.MIDDLE);
    }


    /**
     * tests position method for the Tower class
     */
    public void testPosition() {
        assertEquals(Position.RIGHT, right.position());
        assertEquals(Position.LEFT, left.position());
        assertEquals(Position.MIDDLE, middle.position());
    }


    /**
     * tests push method with valid parameters for the Tower class
     */
    public void testPush() {
        Disk test = new Disk(6);
        Disk smaller = new Disk(4);

        right.push(test);
        assertEquals(test, right.peek());
        right.push(smaller);
        assertEquals(smaller, right.peek());
    }


    /**
     * tests push method with null parameter for the Tower class
     */
    public void testNullPush() {
        Disk nullDisk = null;

        Exception exception = null;
        try {
            right.push(nullDisk);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
    }


    /**
     * tests push method with too large of a parameter for the Tower class
     */
    public void testInvalidPush() {
        Disk smaller = new Disk(4);
        Disk bigger = new Disk(8);
        right.push(smaller);

        Exception exception = null;
        try {
            right.push(bigger);
            fail("push() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("push() is throwing the wrong type of exceptions",
            exception instanceof IllegalStateException);
    }

}
