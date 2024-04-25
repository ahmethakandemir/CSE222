public class KWLinkedList<E> {
    static private class Node<E> {
        private E data;
        private Node<E> next;

        Node(E aData) {
            data = aData;
            next = null;
        }

        Node(E aData, Node<E> aNext) {
            data = aData;
            next = aNext;
        }
    }

    private Node<E> head;
    private int size;

    private Node<E> getNode(int index) {
        Node<E> node = head;
        for (int i = 0; i < index && node != null; i++) {
            node = node.next;
        }
        return node;
    }
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        return node.data;
    }
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        Node<E> node = getNode(index);
        E result = node.data;
        node.data = newValue;
        return result;
    }
    public KWLinkedList() {
        size = 0;
        head = null;
    }

    private void addfirst(E aData) {
        head = new Node<E>(aData, head);
        size++;
    }

    @SuppressWarnings("unused")
    private void addafter(Node<E> node, E item) {
        node.next = new Node<E>(item, node.next);
        size++;
    }
    
    
    
    @SuppressWarnings("unused")
    private E removeAfter(Node<E> node) {
        if(node.next != null){
            Node<E> temp = node.next;
            node.next = temp.next;
            size--;
            return temp.data;
        }
        else {
            return null;
        }
    }
    
    @SuppressWarnings("unused")
    private E removeFirst(){
        Node<E> temp = head;
        if (head != null){
            head = temp.next;
            size--;
            return (E)head.data;
        }
        else{
            return null;
        }
    }

    public void add(E veri) {
        Node<E> item = new Node<E>(veri);
        if (head == null) {
            head = item;
        } else {
            Node<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            item.data = veri;
            current.next = item;
        }
        size++;

    }

    public E remove(int index){
        E removed;
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index==0){
            removed = removeFirst();
        }
        else{
            Node<E> temp = getNode(index-1);
            removed = removeAfter(temp);

        }
        return removed;

    }

    public void add(int index, E data){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        if(index == 0){
            addfirst(data);
        }
        else{
            Node<E> temp = getNode(index-1);
            addafter(temp, data);
        }
    }

    

}