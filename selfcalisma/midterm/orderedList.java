
/**
 * orderedList
 */
import java.util.ListIterator;
import java.util.Iterator;
import java.util.LinkedList;

public class orderedList<E extends Comparable<E>> implements Iterable<E> {
    private LinkedList<E> theList = new LinkedList<E>();
    private ListIterator<E> iter = theList.listIterator();
    private int size;

    public ListIterator<E> iterator() {
        return iter;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Iterator<E> newiter = theList.iterator();
        for (int i = 0; i < index & newiter.hasNext(); i++) {
            newiter.next();
        }
        return newiter.next();
    }

    public orderedList(LinkedList<E> aList) {
        theList = aList;
        size = aList.size();
        theList.sort(null);
    }

    public void add(E element) {
        ListIterator<E> newiter = theList.listIterator();
        // int index = 0;  
        while (newiter.hasNext()) {
            if (element.compareTo(newiter.next()) < 0) {
                newiter.previous();
                newiter.add(element);
                break;
            }
            // index++;
        }
        // theList.add(index, element);
        //newiter.add(element);
    }

    public String toString() {
        Iterator<E> newiter = theList.iterator();
        String s = "";
        while (newiter.hasNext()) {
            s = s + " " + newiter.next();
        }
        return s;
    }
}
