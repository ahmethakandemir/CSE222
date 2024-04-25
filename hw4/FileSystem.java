import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
/**
 * FileSystem class is the main class for the file system.
 * It has a root directory and a current directory.
 * It has createFile, createDirectory, remove, moveItem, printPath, search, printDirectoryTree, ls, cd, sortByTime methods.
 * It has a constructor that instantiates a FileSystem object with a root directory and a current directory.
 */
public class FileSystem extends FileSystemElement {
    /**
     * root directory of the file system.
     */
    Directory root;
    /**
     * current directory of the file system.
     */
    Directory currentDirectory;

    /**
     * Constructor of FileSystem class.
     * instantiates a FileSystem object with a root directory and a current directory.
     */
    public FileSystem() { // Constructor
        this.root = new Directory("root");
        this.currentDirectory = this.root;
    }
    /**
     * Creates a file in the current directory.
     * @param name name of the file.
     */
    public void createFile(String name) {
        try {
            currentDirectory.addFile(name);
            System.out.println("File created: " + name);
        } catch (Exception e) {
            System.out.println("File couldn't created!");
        }

    }
    /**
     * Creates a directory in the current directory.
     * @param name name of the directory.
     */
    public void createDirectory(String name) {
        try {
            currentDirectory.addDirectory(name);
            System.out.println("Directory created: " + name);
        } catch (Exception e) {
            System.out.println("Directory couldn't created!");
        }
    }
    /**
     * Removes a file or directory from the current directory.
     * @param name name of the file or directory.
     */
    public void remove(String name) {
        try{
            int index = 0;
            remove(name, index);    // Recursive function
        }
        catch(Exception e){
            System.out.println("No such file or directory!");
        }
            
    }
    /**
     * Overloaded recursive private remove method to use in public remove method.
     * Recursive function to remove a file or directory from the current directory.
     * @param name name of the file or directory.
     * @param index index of the file or directory in the current directory.
     */
    private void remove(String name,int index) {
        if(currentDirectory.children.get(index).name.equals(name)){
            String removedName = currentDirectory.children.get(index).name;
            currentDirectory.removeItem(removedName);
            return;
        }
        if(index == currentDirectory.children.size() - 1){
            System.out.println("No such file or directory!");
            return;
        }
        index++;
        remove(name, index);
    }
    /**
     * Moves a file or directory from the current directory to the given path.
     * @param name name of the file or directory.
     * @param path path to move the file or directory.
     */
    public void moveItem(String name, String path) {
        int index = 0;
        boolean found = false;
        try {
            for (FileSystemElement child : currentDirectory.children) {
                if (child.name.equals(name)) {
                    found = true;
                    break;
                }
                index++;
            }
            if (!found) {
                throw new Exception();
            }
            FileSystemElement temp = currentDirectory.children.remove(index);
            Directory temp2 = currentDirectory;
            cd(path);
            currentDirectory.children.add(temp);
            currentDirectory = temp2;
        } catch (Exception e) {
            System.out.println("No such file or directory!");
        }
    }
    /**

     * Prints the path to the current directory.
     */
    public void printPath() {
        Directory temp = new Directory("temp");
        temp = currentDirectory;
        pwd(temp);
    }
    /**
     * Overloaded private recursive pwd method (like in linux terminal) to use in public printPath method.
     * Recursive function to print the path to the current directory.
     * @param temp current directory.
     * @return current directory.
     */
    private Directory pwd(Directory temp) {
        if (temp.parent == null) {
            System.out.print("/" + temp.name);
            return temp;
        }
        pwd(temp.parent);
        System.out.print("/" + temp.name);
        return temp;
    }

    /**
     * Searches for a file or directory in the file system.
     * @param name name of the file or directory.
     */
    public void search(String name) {
        search(root, name);
    }
    /**
     * Overloaded private recursive search method to use in public search method.
     * Recursive function to search for a file or directory in the file system.
     * @param temp current directory.
     * @param name name of the file or directory.
     */
    private void search(Directory temp, String name) {
        for (FileSystemElement eleman : temp.children) {
            if (eleman.name.equals(name)) {
                System.out.print("\nFound at: ");
                pwd(temp);
                System.out.println();
                return;
            }
            if (eleman instanceof Directory) {
                search((Directory) eleman, name);
            }
        }
    }
    /**
     * Prints the directory tree of the file system.
     */
    public void printDirectoryTree() {
        Directory temp = currentDirectory;
        int depth = 1;
        while(temp.parent != null){
            depth++;
            temp = temp.parent;
        }
        printDirectoryTree(currentDirectory, 0, depth);
        System.out.print(" (current directory) \n");
        ls(depth);
    }
    /**
     * Overloaded private recursive printDirectoryTree method to use in public printDirectoryTree method.
     * Recursive function to print the directory tree of the file system.
     * @param tempCurrent current directory.
     * @param depth depth of the current directory.
     * @param totalDepth total depth of the file system.
     */
    private void printDirectoryTree(Directory tempCurrent, int depth, int totalDepth) {
        if (tempCurrent == null) {
            return;
        }
        printDirectoryTree(tempCurrent.parent, depth += 1,totalDepth);
        System.out.println();
        for (int i = 0; i < totalDepth - depth; i++) {
            System.out.print("  ");
        }
        System.out.print("* " +tempCurrent.name);

    }
    /**
     * Lists the contents of the current directory.
     * @param depth depth of the current directory, it is used for printDirectoryTree function to make indentations correct.
     */
    public void ls(int depth) {
        ArrayList<Directory> directories = new ArrayList<Directory>();
        ArrayList<File> files = new ArrayList<File>();
        for (FileSystemElement eleman : currentDirectory.children) {
            if (eleman instanceof Directory) {
                directories.add((Directory) eleman);
                // System.out.println(" * " + eleman.name + "/");
            }
            if (eleman instanceof File) {
                files.add((File) eleman);
                // System.out.println(eleman.name);
            }
        }
        for (Directory directory : directories) {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
            System.out.print("* " + directory.name + "/\n");
        }
        for (File file : files) {
            for (int i = 0; i < depth; i++) {
                System.out.print("  ");
            }
            System.out.print(file.name + "\n");
        }
    }
    /**
     * Lists the contents of the current directory.
     */
    public void ls() {
        ArrayList<Directory> directories = new ArrayList<Directory>();
        ArrayList<File> files = new ArrayList<File>();
        for (FileSystemElement eleman : currentDirectory.children) {
            if (eleman instanceof Directory) {
                directories.add((Directory) eleman);
                // System.out.println(" * " + eleman.name + "/");
            }
            if (eleman instanceof File) {
                files.add((File) eleman);
                // System.out.println(eleman.name);
            }
        }
        for (Directory directory : directories) {
            System.out.println("* " + directory.name + "/");
        }
        for (File file : files) {
            System.out.println(file.name);
        }
    }
    /**
     * Changes the current directory to the given path.
     * @param str path to change the current directory.
     */
    public void cd(String str) {
        try{
            /**
             * If the given path is a directory in the current directory, changes the current directory to the given path.
             */
            for (FileSystemElement eleman : currentDirectory.children) {
                if (eleman.name.equals(str)) {
                    currentDirectory = (Directory) eleman;
                    System.out.print("Directory changed to: ");
                    printPath();
                    System.out.println();
                    return;
                }
            }
            /**
             * If the given path is a directory in the file system, changes the current directory to the given path.
             */
            String[] strArray = str.split("/");
            /**
             * tempArray is the array that contains the path to the directory. When "/root" or "root" is given at the beginning of the path, tempArray is the strArray that does not include "" or root paths.
             */
            String[] tempArray = new String[strArray.length - 1];;
            if(!((strArray[0].equals("") && strArray[1].equals("root")) || strArray[0].equals("root"))){
                System.out.println("No such directory!");
                return;
            }
            else if(strArray[0].equals("root")){
                for (int i = 0; i < strArray.length - 1; i++) {
                    tempArray[i] = strArray[i + 1];
                }
            }
            else if(strArray[0].equals("") && strArray[1].equals("root")){
                tempArray = new String[strArray.length - 2];
                for (int i = 0; i < strArray.length - 2; i++) {
                    tempArray[i] = strArray[i + 2];
                }
            }
            /**
             * temp is the directory that the current directory will be changed to.
             */
            Directory temp = root;
            for (String string : tempArray) {
                
                boolean found = false;
                for (FileSystemElement eleman : temp.children) {
                    if (eleman.name.equals(string)) {
                        temp = (Directory) eleman;
                        found = true;
                    }
                }
                if (!found) {
                    System.out.println("No such directory!");
                    return;
                }
            }
            currentDirectory = temp;
            System.out.print("Directory changed to: ");
            printPath();
        }
        catch(Exception e){
            System.out.println("Error occured while changing directory!");
        }
    }
    /**
     * Sorts the contents of the current directory by date created.
     */
    public void sortByTime() {
        LinkedList<FileSystemElement> temp = currentDirectory.children;
        System.out.print("Sorted contents of: ");
        printPath();
        System.out.print(" by date created: \n");

        sortByTime(temp);
    }
    /**
     * Overloaded private recursive sortByTime method to use in public sortByTime method.
     * Recursive function to sort the contents of the current directory by date created.
     * @param temp current directory.
     */
    private void sortByTime(LinkedList<FileSystemElement> temp) {
        if(temp.size() == 0){
            return;
        }
        FileSystemElement earliest;
        earliest = temp.get(0);    
        for (int i = 0; i < temp.size(); i++) {
            if(temp.get(i).dateCreated.before(earliest.dateCreated)){
                earliest = temp.get(i);
            }
        }
        String s = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(earliest.dateCreated);
        if(earliest instanceof Directory){
            System.out.println("* " +earliest.name + "/ " + "(" + s + ")");
        }else{
            System.out.println(earliest.name + " " + "(" + s + ")");
        }
        temp.remove(earliest);
        sortByTime(temp);
    }
}