package homework4;

public class MyDoubleLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    MyDoubleLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void add(int index, E obj) {

    }

    private class Node<E> {
        E data;
        Node<E> next;
        Node<E> prev;

        Node(E obj) {
            data = obj;
            next = null;
            prev = null;
        }
    }
}
