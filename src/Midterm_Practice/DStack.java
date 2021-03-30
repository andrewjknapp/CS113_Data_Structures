package Midterm_Practice;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class DStack {
    LinkedList<Double> mlist;

    public DStack() {
        mlist = new LinkedList<>();
    }

    // Returns true is stack is empty
    // false if otherwise
    public boolean isEmpty() {
        return mlist.isEmpty();
    }

    // Adds d to the top od the stack
    public void push(double d) {
        mlist.addFirst(d);
    }

    // Returns and removes the item at the top of the stack
    // @throws EmptyStackException if stack is empty
    public double pop() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return mlist.removeFirst();
        }
    }

    // Returns (and does not remove) the item at the top of the stack
    // @throws EmptyStackException if stack is empty
    public double peek() {
        if (this.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return mlist.getFirst();
        }
    }

    // Moves the smallest element in the stack to the top of the stack
    // Algorithm:
    /**
     * If stack is empty, return
     * Create temporary stack
     * Move each element in given stack into temporary stack O(n)
     * Check current element to see if it is the smallest one seen yet
     *      if so then store as min
     *
     * Move all elements except the min from the tempStack back into the given stack O(n)
     *
     * Push min onto given stack
     *
     * Overall time complexity: O(n+n), simplifies to O(n)
     */
    public static void moveSmallestToTop(DStack stack) {
        if (stack.isEmpty()) {
            return;
        }

        DStack tempStack = new DStack();
        double currentVal;
        double min = stack.peek();

        while (!stack.isEmpty()) {
            currentVal = stack.pop();
            if (currentVal < min) {
                min = currentVal;
            }
            tempStack.push(currentVal);
        }

        while(!tempStack.isEmpty()) {
            currentVal = tempStack.pop();
            if (currentVal != min) {
                stack.push(currentVal);
            }
        }

        stack.push(min);
    }
}
