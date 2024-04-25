public class lambda {

    public static void main(String[] args) {
        calculate islem = (a,b) -> {
            return a + b;    
        };

        System.out.println(islem.zort(3, 5));
        
        islem = (a,b) -> {
            return a * b;
        };
        
        System.out.println(islem.zort(3, 5));
    }
}

@FunctionalInterface
interface calculate {
    int zort(int a, int b);
}
