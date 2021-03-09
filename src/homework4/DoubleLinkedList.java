package homework4;
import java.util.*;

public class DoubleLinkedList<E> extends AbstractSequentialList<E>  {  // Data fields
    	private Node<E> head = null;   // points to the head of the list
    	private Node<E> tail = null;   //points to the tail of the list
    	private int size = 0;    // the number of items in the list
  
  public void add(int index, E obj) { // Fill Here
    listIterator(index).add(obj);
  }

  public void addFirst(E obj) { // TODO Fill Here
      Node adding = new Node(obj);
      if (head != null) {
          adding.next = head;
          head.prev = adding;
      }
      head = adding;

      size++;
  }
  public void addLast(E obj) { // TODO Fill Here
      Node adding = new Node(obj);
      if (tail != null) {
          adding.prev = tail;
          tail.next = adding;
      }

      tail = adding;
      size++;
  }

  public E get(int index) throws IndexOutOfBoundsException
  {
      if (index < 0 || index >= size) {
          throw new IndexOutOfBoundsException();
      }
      ListIterator<E> iter = listIterator(index);
      	return iter.next();
  }

  public E getFirst() {
      return head.data;
  }

  public E getLast() {
      return tail.data;
  }

  public int size() {
      return size;
  }

  public E remove(int index) {
        E returnValue = null;
        ListIterator<E> iter = listIterator(index);
        if (iter.hasNext()) {
            returnValue = iter.next();
            iter.remove();
        }
        else {
            throw new IndexOutOfBoundsException();
        }
        return returnValue;
  }

  public Iterator iterator() {
      return new ListIter(0);
  }

  public ListIterator listIterator() {
      return new ListIter(0);
  }

  public ListIterator listIterator(int index) {
      return new ListIter(index);
  }

  public ListIterator listIterator(ListIterator iter) {
      return new ListIter( (ListIter) iter);
  }

  // Inner Classes
  private static class Node<E>
  {     private E data;
        private Node<E> next = null;
        private Node<E> prev = null;

        private Node(E dataItem)  //constructor
        {   data = dataItem;   }
  }  // end class Node

  public class ListIter implements ListIterator<E> {
        private Node<E> nextItem;      // the current node
        private Node<E> lastItemReturned;   // the previous node
        private int index = 0;   // 

    public ListIter(int i) {  // constructor for ListIter class
       if (i < 0 || i > size) {
            throw new IndexOutOfBoundsException("Invalid index " + i);
        }
        lastItemReturned = null;
 
        if (i == size) {    // Special case of last item
             index = size;
             nextItem = null;
        }
        else {         // start at the beginning
           nextItem = head;
           for (index = 0; index < i; index++) {
               nextItem = nextItem.next;
           }
        }// end else
    }  // end constructor

    public ListIter(ListIter other) // Copy constructor
    {   nextItem = other.nextItem;
        index = other.index;    }

    public boolean hasNext() {
        return index < size;
    }

    public boolean hasPrevious() {
        return index > 0;
    } // TODO Fill Here

    public int previousIndex() {  return index - 1;    } // TODO Fill Here

    public int nextIndex() {  return index;    } // TODO Fill here

    public void set(E o) throws IllegalStateException {
        if (lastItemReturned != null) {
            lastItemReturned.data = o;
        } else {
            throw new IllegalStateException();
        }
    }  // not implemented

    public void remove() throws IllegalStateException {

        if (lastItemReturned != null) {

            if (lastItemReturned.prev != null) { // If we are anywhere other than the start of the list
                lastItemReturned.prev.next = lastItemReturned.next;
            } else { // If we are at the start of the list
                head = lastItemReturned.next;

                if (head == null) {
                    tail = null;
                } else {
                    head.prev = null;
                }
            }

            if (lastItemReturned.next != null) { // If we are anywhere other then the end of the list
                lastItemReturned.next.prev = lastItemReturned.prev;
            } else { // If we are at the end of the list
                tail = lastItemReturned.prev;

                if (tail == null) {
                    head = null;
                } else {
                    tail.next = null;
                }
            }

            lastItemReturned = null;
            index--;
            size--;

        } else {
            throw new IllegalStateException();
        }
    }      // not implemented

    public E next() throws NoSuchElementException
    {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        E nextElement = nextItem.data;
        lastItemReturned = nextItem;
        nextItem = nextItem.next;
        index++;
        return nextElement; // Fill Here
    }

    public E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        if (nextItem == null) { // If we are at the tail
            nextItem = tail;
        } else {
            nextItem = nextItem.prev;
        }
        lastItemReturned = nextItem;
        index--;
        return lastItemReturned.data; // TODO Fill Here
    }

    public void add(E obj) {
        Node newNode = new Node(obj);

        if (head == null) { // If List is empty
            head = newNode;
            tail = head;
        } else if (nextItem == head) { // Insert at the Head
            nextItem.prev = newNode;
            newNode.next = nextItem;
            head = newNode;
        } else if (nextItem == null) { // Insert at the Tail
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else { // Insert anywhere else in the list
            newNode.next = nextItem;
            newNode.prev = nextItem.prev;
            nextItem.prev.next = newNode;
            nextItem.prev = newNode;
        }

        size++;
        index++;
        lastItemReturned = null;
    // Fill Here
    }
  }// end of inner class ListIter
}// end of class DoubleLinkedList
