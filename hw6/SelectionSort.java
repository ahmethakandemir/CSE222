/**
 * SelectionSort class
 */
public class SelectionSort extends SortAlgorithm {
    /**
     * Constructor
     * 
     * @param input_array
     */
	public SelectionSort(int input_array[]) {
		super(input_array);
	}
    /**
     * Sort method
     */
    @Override
    public void sort() {
        for (int i = 0; i < arr.length-1; i++){
            int minindex = i;
            for (int j = i + 1; j < arr.length; j++){   // finding the minimum element in the unsorted part of the array
                comparison_counter++;
                if (arr[j] < arr[minindex]){
                    minindex = j;
                }
            }
            swap(i,minindex);
        }
    }
    /**
     * Print method
     */
    @Override
    public void print() {
    	System.out.print("Selection Sort\t=>\t");
    	super.print();
    }
}
