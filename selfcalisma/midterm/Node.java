import java.io.Serializable;

public class Node<E> implements Serializable{
    E data;
    Node<E> right;
    Node<E> left;
    
    public Node(){
        left = null;
        right = null;
        data = null;
    }

    public Node(E aValue){
        left = null;
        right = null;
        data = aValue;
    }
    public String toString(){
        return data.toString();
    } 
}
