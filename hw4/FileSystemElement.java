import java.sql.Timestamp;

/**
 * FileSystemElement class is an abstract class.
 */

abstract class FileSystemElement{
    /**
     * name of the FileSystemElement.
     */
    String name;
    /**
     * creation date of the FileSystemElement.
     */
    Timestamp dateCreated;
    /**
     * parent directory of the FileSystemElement.
     */
    Directory parent;
    /**
     * Constructor of FileSystemElement class.
     * instantiates a FileSystemElement object with a name and a creation date.
     * @param name name of the FileSystemElement.
     */
    FileSystemElement(String name){
        this.name = name;
        this.dateCreated = new Timestamp(System.currentTimeMillis());   
    }
    /**
     * Constructor of FileSystemElement class.
     * instantiates a FileSystemElement object only with a creation date.
     */
    FileSystemElement(){
        this.dateCreated = new Timestamp(System.currentTimeMillis());   
    }
    
}