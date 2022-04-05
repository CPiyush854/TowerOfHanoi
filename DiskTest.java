// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Piyush Chauhan(cpiyush854)
package towerofhanoi;

/**
 * the test class for the Disk class
 * 
 * @author cpiyu
 * @version 2021.10.19
 */
public class DiskTest extends student.TestCase {
    private Disk test;
    private Disk nullDisk;
    private Disk smaller;
    private Disk bigger;

    /**
     * sets up the Disk objects to be used for testing
     */
    public void setUp() {
        test = new Disk(6);
        nullDisk = null;
        smaller = new Disk(4);
        bigger = new Disk(8);
    }


    /**
     * tests the compareTo method for the Disk class
     */
    public void testCompareTo() {
        assertEquals(1, test.compareTo(smaller));
        assertEquals(-1, test.compareTo(bigger));
        Disk clone = new Disk(6);
        assertEquals(0, clone.compareTo(test));
        Exception exception = null;
        try {
            test.compareTo(nullDisk);
            fail("compareTo() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("compareTo() is throwing the wrong type of exceptions",
            exception instanceof IllegalArgumentException);
    }


    /**
     * tests the toString method for the Disk class
     */
    public void testToString() {
        assertEquals("6", test.toString());
    }


    /**
     * tests the equals method for the Disk class
     */
    public void testEquals() {
        assertFalse(test.equals(new Object()));
        assertFalse(test.equals(nullDisk));
        assertFalse(test.equals(smaller));
        Disk clone = new Disk(6);
        assertTrue(test.equals(clone));
    }
    
    public void testContains() {
        assertTrue(test.containsDigit("Hello0"));
        assertFalse(test.containsDigit("Hey"));
    }

}
