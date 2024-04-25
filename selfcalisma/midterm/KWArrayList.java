import java.util.Arrays;

public class KWArrayList<E> {
    private static final int INITIAL_CAPACITY = 10;
    private int size = 0;
    private int capacity = 0;
    private E[] arr;

    @SuppressWarnings("unchecked")
    public KWArrayList(){
        capacity = INITIAL_CAPACITY;
        arr = (E[]) new Object[capacity];
    }

    public E get(int index) {
        return arr[index];
    }

    public boolean add(E other) {
        if (size == capacity) {
            capacity = capacity * 2;
            arr = Arrays.copyOf(arr, capacity);
        }
        arr[size] = other;
        size++;

        return true;
    }

    public boolean add(int index, E data) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        if (size == capacity) {
            capacity = capacity * 2;
            arr = Arrays.copyOf(arr, capacity);
        }
        for (int i = size; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = data;
        size++;
        return true;

    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E removed = arr[index];
        for(int i = index; i < size; i++){
            arr[i] = arr[i + 1];
        }        
        size--;
        return removed;
    }

    public E set(int index, E data) {
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E old = arr[index];
        arr[index] = data;
        return old;
    }
    public int indexOf(E data){
        for(int i = 0;i < size;i++){
            if (arr[i] == data){
                return i;
            }
        }
        return -1;
    }
    
}
