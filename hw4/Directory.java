import java.util.LinkedList;
/**
 * Directory class is a subclass of FileSystemElement class.
 * It has a LinkedList of FileSystemElement objects.
 * It has addFile, addDirectory, removeItem methods.
 */
public class Directory extends FileSystemElement{
    /**
     * LinkedList of FileSystemElement objects.
     */
    LinkedList<FileSystemElement> children;
    /**
     * Constructor of Directory class.
     * @param name name of the directory.
     */
    public Directory(String name) {
        this.name = name;
        this.children = new LinkedList<FileSystemElement>();
    }
    /**
     * Adds a file to the directory.
     * @param name name of the file.
     */
    public void addFile(String name) {
        File temp = new File(name);
        temp.parent = this;
        this.children.add(temp);
    }
    /**
     * Adds a directory to the directory.
     * @param name name of the directory.
     */
    public void addDirectory(String name) {
        Directory temp = new Directory(name);
        temp.parent = this;
        this.children.add(temp);
    }
    /**
     * Removes a file or directory from the directory.
     * @param name name of the file or directory.
     */
    public void removeItem(String name) {
        for (FileSystemElement eleman : this.children) {
            if (eleman.name == name) {
                this.children.remove(eleman);
                return;
            }
        }
        System.out.println("No such file or directory!");
        return;
    }

}
