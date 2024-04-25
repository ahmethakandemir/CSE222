import java.util.NoSuchElementException;
// import java.util.Iterator;
public class KWDoubleLL<E> {
    static protected class Node<E>{
        private E data;
        private Node<E> next;
        @SuppressWarnings("unused")
        private Node<E> prev; // Reference to the previous node

        Node(E aData) {
            data = aData;
            next = null;
            prev = null;
        }

        Node(E aData, Node<E> aNext, Node<E> aPrev) {
            data = aData;
            next = aNext;
            prev = aPrev;
        }   
    }


    private Node<E> head;
    private int size;

    public KWDoubleLL() {
        size = 0;
        head = null;
    }

    public void addFirst(E data) {
        head = new Node<>(data, head, null);
        if (head.next != null) {
            head.next.prev = head; // Update the previous reference of the next node
        }
        size++;
    }

    public void addLast(E data) {
        if (head == null) {
            addFirst(data);
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new Node<>(data, null, current);
            size++;
        }
    }

    private Node<E> getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public void add(int index, E data) {
        if (index == 0) {
            addFirst(data);
        } else if (index == size) {
            addLast(data);
        } else {
            Node<E> prevNode = getNode(index - 1);
            Node<E> newNode = new Node<>(data, prevNode.next, prevNode);
            prevNode.next.prev = newNode; // Update the previous reference of the next node
            prevNode.next = newNode;
            size++;
        }
    }

    public E removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("List is empty");
        }
        E removedData = head.data;
        head = head.next;
        if (head != null) {
            head.prev = null;
        }
        size--;
        return removedData;
    }

    // Implement other methods such as removeLast, remove, get, etc.

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<E> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}
