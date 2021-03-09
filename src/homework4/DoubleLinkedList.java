package homework4;
import java.util.*;

public class DoubleLinkedList<E> extends AbstractSequentialList<E>
{  // Data fields
    	private Node<E> head = null;   // points to the head of the list
    	private Node<E> tail = null;   //points to the tail of the list
    	private int size = 0;    // the number of items in the list
  
  public void add(int index, E obj)
  { // Fill Here 
   }
  public void addFirst(E obj) { // TODO Fill Here
      Node adding = new Node(obj);
      adding.next = head;
      head.prev = adding;
      head = adding;
  }
  public void addLast(E obj) { // TODO Fill Here
      Node adding = new Node(obj);
      adding.prev = tail;
      tail.next = adding;
      tail = adding;
  }

  public E get(int index) 
  { 	ListIterator<E> iter = listIterator(index); 
      	return iter.next();
  }  
  public E getFirst() { return head.data;  }
  public E getLast() { return tail.data;  }

  public int size() {  return size;  }

  public E remove(int index)
  {     E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext())
        {   returnValue = iter.next();
            iter.remove();
        }
        else {   throw new IndexOutOfBoundsException();  }
        return returnValue;
  }

  public Iterator iterator() { return new ListIter(0);  }
  public ListIterator listIterator() { return new ListIter(0);  }
  public ListIterator listIterator(int index){return new ListIter(index);}
  public ListIterator listIterator(ListIterator iter)
  {     return new ListIter( (ListIter) iter);  }

  // Inner Classes
  private static class Node<E>
  {     private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        private Node(E dataItem)  //constructor
        {   data = dataItem;   }
  }  // end class Node

  public class ListIter implements ListIterator<E> 
  {
        private Node<E> nextItem;      // the current node
        private Node<E> lastItemReturned;   // the previous node
        private int index = 0;   // 

    public ListIter(int i)  // constructor for ListIter class
    {   if (i < 0 || i > size)
        {     throw new IndexOutOfBoundsException("Invalid index " + i); }
        lastItemReturned = null;
 
        if (i == size)     // Special case of last item
        {     index = size;     nextItem = null;      }
        else          // start at the beginning
        {   nextItem = head;
            for (index = 0; index < i; index++)  nextItem = nextItem.next;   
        }// end else
    }  // end constructor

    public ListIter(ListIter other)
    {   nextItem = other.nextItem;
        index = other.index;    }

    public boolean hasNext() {
        return nextItem != null;
    }
    public boolean hasPrevious()
    {   return false;   } // TODO Fill Here
    public int previousIndex() {  return 0;    } // TODO Fill Here
    public int nextIndex() {  return 0;    } // TODO Fill here
    public void set(E o)  { }  // not implemented
    public void remove(){}      // not implemented

    public E next()
    {  
        return lastItemReturned.data; // Fill Here 
    }

    public E previous() 
    {  return lastItemReturned.data; // TODO Fill Here
    }

    public void add(E obj) {

    // Fill Here
    }
  }// end of inner class ListIter
}// end of class DoubleLinkedList
