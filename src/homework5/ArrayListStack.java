package homework5;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E> {

    // Member Variables
    private ArrayList<E> stack;
    private int top;

    // Constructor
    public ArrayListStack() {
        stack = new ArrayList<E>();
        top = -1;
    }

    public boolean equals(ArrayListStack other) {
        return stack.equals(other.stack);
    }

    // Stack Interface Implementation
    public boolean empty() {
        return stack.isEmpty();
    }

    public E peek() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(top);
    }

    public E pop() {
        if (stack.isEmpty()) {
            throw new EmptyStackException();
        }
        E itemToPop = stack.remove(top);
        top--;

        return itemToPop;
    }

    public E push(E newItem) {
        stack.add(newItem);
        top++;
        return stack.get(top);
    }

    // Getters
    public int getSize() {
        return top + 1;
    }
}
