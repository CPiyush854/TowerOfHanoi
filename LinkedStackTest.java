// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Piyush Chauhan(cpiyush854)
package towerofhanoi;

import java.util.EmptyStackException;

/**
 * the test class for the LinkedStack class
 * 
 * @author cpiyu
 * @version 2021.10.19
 *
 */
public class LinkedStackTest extends student.TestCase {
    private LinkedStack<String> test;

    /**
     * sets up the object to be used for testing
     */
    public void setUp() {
        test = new LinkedStack<String>();
    }


    /**
     * tests the size, push, and peek method for the LinkedStack class
     */
    public void testSizeAndPushAndPeek() {
        assertEquals(0, test.size());
        Exception exception = null;
        try {
            test.peek();
            fail("peek() is not throwing an exception when it should");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue("peek() is throwing the wrong type of exceptions",
            exception instanceof EmptyStackException);
        test.push("Hello");
        assertEquals("Hello", test.peek());
        assertEquals(1, test.size());

    }


    /**
     * tests the isEmpty and clear method for the LinkedStack class
     */
    public void testIsEmptyAndClear() {
        assertTrue(test.isEmpty());
        test.push("Hello");
        assertFalse(test.isEmpty());
        test.clear();
        assertTrue(test.isEmpty());
    }


    /**
     * tests the pop method for the LinkedStack class
     */
    public void testPop() {
        test.push("Hello");
        assertEquals("Hello", test.pop());
    }


    /**
     * tests the toString method for the LinkedStack class
     */
    public void testToString() {
        test.push("Hello");
        test.push("Hey");
        test.push("Hi");
        assertEquals("[Hi, Hey, Hello]", test.toString());
    }

}
