// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Piyush Chauhan(cpiyush854)
package towerofhanoi;

/**
 * the tower class representing the three towers used in the hanoi problem
 * 
 * @author cpiyu
 * @version 2021.10.19
 */
public class Tower extends LinkedStack<Disk> {
    private Position position;

    /**
     * the constructor for the Tower class
     * 
     * @param position
     *            the position the tower is representing
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * gives us the position of the tower
     * 
     * @return the position
     */
    public Position position() {
        return position;
    }


    /**
     * pushes a disk object into the tower
     * 
     * @param disk
     *            the object to be pushed
     */
    @Override
    public void push(Disk disk) {
        if (disk == null) {
            throw new IllegalArgumentException();
        }
        if (this.isEmpty() || this.peek().compareTo(disk) == 1) {
            super.push(disk);
        }
        else {
            throw new IllegalStateException();
        }
    }
}
