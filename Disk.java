// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Piyush Chauhan(cpiyush854)
package towerofhanoi;

import java.awt.Color;

import cs2.Shape;
import student.TestableRandom;

/**
 * the Disk class creates Disk shapes for our project
 * 
 * @author cpiyu
 * @version 2021.10.19
 */
public class Disk extends Shape implements Comparable<Disk> {

    /**
     * the constructor for our Disk class
     * 
     * @param width
     *            the width of the Disk object created
     */
    public Disk(int width) {
        super(0, 0, width, PuzzleWindow.DISK_HEIGHT);
        TestableRandom randomGenerator = new TestableRandom();
        Color color = new Color(randomGenerator.nextInt(256), randomGenerator
            .nextInt(256), randomGenerator.nextInt(256));
        this.setBackgroundColor(color);
    }


    /**
     * compares two Disk objects with each other
     * 
     * @param otherDisk
     *            the other Disk object to be compared
     * @return 1 if otherDisk is smaller, -1 if otherDisk is larger,
     *         0 the widths are equal, and an exception if otherDisk is null
     */
    public int compareTo(Disk otherDisk) {
        if (otherDisk == null) {
            throw new IllegalArgumentException();
        }
        if (otherDisk.getWidth() < this.getWidth()) {
            return 1;
        }
        else if (otherDisk.getWidth() > this.getWidth()) {
            return -1;
        }
        else {
            return 0;
        }
    }


    /**
     * prints out the width of a Disk
     * 
     * @return String format of the width of a given Disk
     */
    public String toString() {
        String str = "" + this.getWidth() + "";
        return str;
    }


    /**
     * checks if two objects are equal to each other
     * 
     * @param obj
     *            a random object to be checked with the original Disk object
     * @return true if two of the same objects are being compared or if two
     *         Disks
     *         have equal width, false otehrwise
     */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        Disk check = (Disk)obj;
        return this.getWidth() == check.getWidth();

    }
    
    public boolean containsDigit(String password) {
        if(password == "") {
            return false;
        } else if(password.charAt(0) == '0' || password.charAt(0) == '1' || password.charAt(0) == '2' || password.charAt(0) == '3') {
            return true;
        } else {
            return containsDigit(password.substring(1));
        }
    }
}
