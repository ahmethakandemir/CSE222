import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class Tree<E extends Comparable<E>> implements Serializable {
    Node<E> root;
    private boolean addReturn;
    private E removeReturn;

    public void serialize(String filename){
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
            out.writeObject(out);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }
    }
    public Tree<E> deserialize(String filename) {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
            Object obj = in.readObject();
            in.close();
            @SuppressWarnings("unchecked")
            Tree<E> deserializedTree = (Tree<E>) obj;
            return deserializedTree;
        } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(1);
            return null;
        }
    }
    // constructors
    public Tree(){
        root = null;
    }
    protected Tree(Node<E> root){
        this.root = root;
    }
    public Tree(E aData, Tree<E> leftnode, Tree<E> rightnode){
        root = new Node<E>(aData);
        if (leftnode != null) {
            root.left = leftnode.root;
        } else {
            root.left = null;
            }
        if (rightnode != null) {
            root.right = rightnode.root;
        } else {
            root.right = null;
            }
    }
    // methods
    public Tree<E> getLeftSubtree(){
        if(root != null && root.left != null){
            return new Tree<E>(root.left);
        }
        else{
            return null;
        }
    }
    public Tree<E> getRightSubtree(){
        if(root != null && root.right != null){
            return new Tree<E>(root.right);
        }
        else{
            return null;
        }
    }
    public E getData(){
        return root.data;
    }
    public boolean isLeaf(){
        return (root.right == null && root.left == null);
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root,1,sb);
        return sb.toString();
    }
    private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb){
        for(int i = 0; i < depth; i++){
            sb.append(" - ");
        }
        if(node == null){
            sb.append("null\n");
        }
        else{
            sb.append(node.toString() + "\n");
            preOrderTraverse(node.left, depth + 1, sb);
            preOrderTraverse(node.right, depth + 1, sb);
        }
    }
    public static Tree<String> readBinaryTree(Scanner scan) {
        String data = scan.next();
        if(data.equals("null")){
            return null;
        }
        else{
            Tree<String> leftTree = readBinaryTree(scan);
            Tree<String> rightTree = readBinaryTree(scan);
            return new Tree<String>(data,leftTree,rightTree);
        }
    }
    public boolean add(E item) {
        root = add(root, item);
        return addReturn;
    }
    private Node<E> add(Node<E> localRoot, E item){

        if(localRoot == null){
            addReturn = true;
            return new Node<E>(item);
        }
        else{
            if(item.compareTo(localRoot.data) < 0){
                localRoot.left = add(localRoot.left, item);
                return localRoot;
            }
            else if(item.compareTo(localRoot.data) > 0){
                localRoot.right = add(localRoot.right, item);
                return localRoot;
            }
            else{
                addReturn = false;
                return localRoot;
            }
        }
    }
    private Node<E> findNextMax(Node<E> node) {
        Node<E> current = null;
        if(node.right != null){
            current = node.right;
            while (current != null && current.left != null) {
                current = current.left;
            }
        }
        else if (node.left != null){
            current = node.left;
            while (current != null && current.right != null) {
                current = current.right;
            }
        }
        return current;
    }
    
    public E remove(E item) {
        root = remove(root, item);
        return removeReturn;
    }
    
    private Node<E> remove(Node<E> localRoot, E item) {
        if (localRoot == null) {
            removeReturn = null;
            return null;
        }
    
        if (item.compareTo(localRoot.data) > 0) {
            localRoot.right = remove(localRoot.right, item);
        } else if (item.compareTo(localRoot.data) < 0) {
            localRoot.left = remove(localRoot.left, item);
        } else {
            removeReturn = localRoot.data;
            if (localRoot.left == null) {
                return localRoot.right;
            } else if (localRoot.right == null) {
                return localRoot.left;
            } else {
                Node<E> nextMaxNode = findNextMax(localRoot);
                localRoot.data = nextMaxNode.data;
                localRoot.right = remove(localRoot.right, nextMaxNode.data);
            }
        }
        return localRoot;
    }
}

