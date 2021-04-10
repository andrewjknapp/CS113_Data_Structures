package homework5;

import java.util.NoSuchElementException;

public class CircularArrayQueue<E>{

    // Member variables
    private int size;
    private Object[] circularArray;
    private int front;
    private int back;

    // Constructors
    public CircularArrayQueue(int initialSize) {
        circularArray = new Object[initialSize];
        front = -1;
        back = 0;
        size = initialSize;
    }

    public void expandArray() {
        Object[] largerArray = new Object[size * 2];

        int index = front;
        for (int i = 0; i < size; i++) {
            largerArray[i] = circularArray[index % size];
            index++;
        }

        circularArray = largerArray;
        front = 0;
        back = size;
        size *= 2;
    }

    // Queue Method Implementations
    public boolean add(E newItem) {

        if (back == front) {
            expandArray();
            //throw new IllegalStateException();
        }

        circularArray[back] = newItem;
        back++;
        back %= size;
        if (front == -1) {
            front = 0;
        }
        return true;
    }

    public E element() {
        if (front == -1) {
            throw new NoSuchElementException();
        }

        return (E) circularArray[front];
    }

    public boolean offer(E newItem) {
        return add(newItem);
//        if (back == front) {
//            return false;
//        }
//
//        circularArray[back] = newItem;
//        back++;
//        back %= size;
//        if (front == -1) {
//            front = 0;
//        }
//        return true;
    }

    public E peek() {
        if (front == -1) {
            return null;
        }

        return (E) circularArray[front];
    }

    public E poll() {
        if (front == -1) {
            return null;
        }

        E elementToReturn = (E) circularArray[front];

        circularArray[front] = null;
        front++;
        front %= size;

        if (front == back) {
            front = -1;
            back = 0;
        }
        return elementToReturn;
    }

    public E remove() {
        if (front == -1) {
            throw new NoSuchElementException();
        }

        E elementToReturn = (E) circularArray[front];

        circularArray[front] = null;
        front++;
        front %= size;

        if (front == back) {
            front = -1;
            back = 0;
        }
        return elementToReturn;
    }

}
