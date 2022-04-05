// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Piyush Chauhan(cpiyush854)
package towerofhanoi;

import java.util.EmptyStackException;
import stack.StackInterface;

/**
 * Makes a LinkedStack class which is implemented by later classes in our
 * project
 * 
 * @author cpiyu
 * @version 2021.10.19
 *
 * @param <T>
 *            generic object
 */
public class LinkedStack<T> implements StackInterface<T> {

    private Node<T> topNode;
    private int size;

    /**
     * the constructor for the LinkedStack calss
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }


    /**
     * gives us the size of the stack
     * 
     * @return an int representing the size of the stack
     */
    public int size() {
        return size;
    }


    /**
     * sets all the entries in the stack to null
     */
    @Override
    public void clear() {
        topNode = null;
        size = 0;
    }


    /**
     * checks if the stack is empty
     * 
     * @return true if empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return topNode == null;
    }


    /**
     * gives us a string representation of all the objects in the stack
     * 
     * @return a string with all the elements in the stack listed
     */
    public String toString() {
        String str = "[";
        Node<T> currentNode = topNode;
        for (int i = 0; i < size; i++) {
            str += currentNode.getData();
            if (i < size - 1) {
                str += ", ";
            }
            currentNode = currentNode.getNextNode();
        }
        str += "]";
        return str;
    }


    /**
     * gives the user a glimpse of the object at the top of the stack
     * 
     * @return the object on top of the stack
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        else {
            return topNode.getData();
        }
    }


    /**
     * removes the object at the top of the stack
     * 
     * @return the object at the top of the stack
     */
    @Override
    public T pop() {
        T top = peek();
        topNode = topNode.getNextNode();
        size--;
        return top;
    }


    /**
     * adds an object to the top of the stack
     * 
     * @param anEntry
     *            the object to be added
     */
    @Override
    public void push(T anEntry) {
        topNode = new Node(anEntry, topNode);
        size++;
    }

    /**
     * private node class that is used by the LinkedStack class
     * 
     * @author cpiyu
     *
     * @param <T>
     *            generic object
     */
    private class Node<T> {
        private Node<T> next;
        private T data;

        /**
         * the first constructor for this class
         * 
         * @param entry
         *            the data for the node
         * @param node
         *            the node for the constructor
         */
        public Node(T entry, Node<T> node) {
            this(entry);
            this.setNextNode(node);
        }


        /**
         * second constructor for this class
         * 
         * @param data
         *            the data for the node
         */
        public Node(T data) {
            this.data = data;
        }


        /**
         * gets the next node in line
         * 
         * @return the next node
         */
        public Node<T> getNextNode() {
            return next;
        }


        /**
         * gets the data in the node
         * 
         * @return the data held in the node
         */
        public T getData() {
            return data;
        }


        /**
         * sets the next node to another node
         * 
         * @param next
         *            the node that the next will be set to
         */
        public void setNextNode(Node<T> node) {
            this.next = node;
        }

    }

}
