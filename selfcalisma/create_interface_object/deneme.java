package create_interface_object;

interface DenemeInterface {
    void sayhi();
}

class DenemeClass implements DenemeInterface {
    public void sayhi() {
        System.out.println("Hello, Zorld!");
    }
    public void sayzort(){
        System.out.println("zortt");
    }
}

public class deneme {
    public static void main(String[] args) {

        DenemeClass class1 = new DenemeClass();
        class1.sayhi();
        class1.sayzort();
        DenemeInterface inter1 = new DenemeClass();
        
        inter1.sayhi();
        //inter1.sayzort(); is undefined; 
    }
}
