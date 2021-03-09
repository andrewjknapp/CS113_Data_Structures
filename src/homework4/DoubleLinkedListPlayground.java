package homework4;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * DoubleLinkedListTest : Test class for the DoubleLinkedList implementation and its constituent ListIterator
 * inner class.
 */
public class DoubleLinkedListPlayground {

    private List<String> stringList;
    private ListIterator<String> stringListIterator;

    @Before
    public void setUp() {
        stringList = new DoubleLinkedList<String>();
        stringListIterator = stringList.listIterator();
    }

    @Test
    public void trial() {
        assertTrue(stringList instanceof DoubleLinkedList);
        stringList.add(0, "Hello");
        stringList.add(1, "There");
        System.out.println(stringList.get(0));
        System.out.println(stringList.get(1));
        stringList.clear();
        stringList.add(0, "General");
        System.out.println(stringList.lastIndexOf("General"));
//        stringList.add("Hello");
//        stringList.clear();
    }

    // endregion ListIterator tests ====================================================================================
    // =================================================================================================================

} // End of class DoubleLinkedListTest