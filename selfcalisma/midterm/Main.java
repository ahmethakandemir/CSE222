import java.util.LinkedList;
// import java.util.Iterator;

public class Main<E> {
    public static void main(String[] args) {

        LinkedList<String> hkalpelove_list = new LinkedList<String>();
        hkalpelove_list.addLast("Tom");
        hkalpelove_list.addLast("Dick");
        hkalpelove_list.addLast("Harry");
        hkalpelove_list.addLast("Sam");

        // Get the index of "Sam"
        // int indexOfSam = hkalpelove_list.indexOf("Sam");

        // ListIterator<String> iteratorToSam = hkalpelove_list.listIterator(indexOfSam);
        
        // Sam
        //     * next = null (size = 1) 
        // System.out.println(iteratorToSam.next());

        // iteratorToSam.remove();

        // Iterate forward from the beginning
        // ListIterator<String> iterator = hkalpelove_list.listIterator();
        // System.out.println("Iterating forward from the beginning:");

        // while (iterator.hasNext()) {
        //     // System.out.println(iterator.next());
        // }

        // Iterator<String> iter = hkalpelove_list.iterator();
        
        





        LinkedList<String> list = new LinkedList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Obtain an iterator from the list
        // Iterator<String> iterator = list.iterator();
    //     iterator.next();
    //     iterator.next();
    //     // Test the prev method
    //     String prevElement = prev(iterator, list);
    //     System.out.println("Previous element: " + prevElement);

    // }
    // private static String prev(Iterator<String> iter, LinkedList<String> list){
    //     Iterator<String> newiter = list.iterator();
    //     String zort = newiter.next();
    //     while(newiter.hasNext()){
    //         if(newiter == iter){
    //             return zort;
    //         }
    //         zort = newiter.next();
    //     }
    //     return null;
    // }

        LinkedList<Integer> intlist = new LinkedList<Integer>();
        intlist.addLast(1);
        intlist.addLast(2);
        intlist.addLast(5);
        intlist.addLast(3);

        orderedList<Integer> set = new orderedList<Integer>(intlist);
        
        System.out.println(set);
        
        // System.out.println(set.get(0));
        // System.out.println(set.get(1));

        // System.out.println(set.get(2));
        // System.out.println(set.get(3));
        
        set.add(4);
        set.add(8);
        set.add(0);
        set.add(2);
        
        System.out.println(set);



    }
}


// biyer = 4

