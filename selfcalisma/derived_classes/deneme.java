package derived_classes;

class Computer {
// Data Fields
    private String manufacturer; 
    private String processor; 
    private double ramSize; 
    private int diskSize;

    private double processorSpeed;
    public Computer(String man, String processor, double ram, int disk, double procSpeed) {
        manufacturer = man;
        this.processor = processor;
        ramSize = ram;
        diskSize = disk;
        processorSpeed = procSpeed;
    }
    public double computePower() { return ramSize * processorSpeed; }
    public double getRamSize() { return ramSize; }
    public double getProcessorSpeed() { return processorSpeed; } 
    public int getDiskSize() { return diskSize; }
    // Insert other accessor and modifier methods here.
    public String toString() {
        String result = "Manufacturer: "+ manufacturer +
        "\nCPU: " + processor +
        "\nRAM: "+ramSize+" megabytes" + "\nDisk: " + diskSize+" gigabytes" + "\nProcessor speed: "
        + processorSpeed + " gigahertz";
        return result;
    }
}

class Notebook extends Computer{

    private double screenSize;
    private double weight;
    Notebook(String man, String processor, double ram, int disk, double procSpeed,double scsize,double wei){
        super(man, processor, ram, disk, procSpeed);
        screenSize = scsize;
        weight = wei;
    }
    @Override
    public String toString() {
        String str = super.toString();
        str = str + "\nScreen size: " + screenSize + "\nWeight: " + weight;
        return str;
    }

}

public class deneme{
    public static void main(String [] args){
        Computer newpc = new Computer("hakan", "intel", 16, 512, 999.30);
        Notebook newlaptop = new Notebook("hakan", "intel", 16, 512, 999.30, 15.2, 4.5);
        System.out.println(newpc);
        System.out.println("\n\n\n");
        System.out.println(newlaptop);
    }
}

