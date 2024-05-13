/**
 * QuickSort Class
 */
public class QuickSort extends SortAlgorithm {
    /**
     * Constructor
     * @param input_array
     */
	public QuickSort(int input_array[]) {
		super(input_array);
	}
	/**
     * Partition method
     * @param min
     * @param max
     * @return
     */
    private int partition(int min, int max) {
        // fill this method
        int pivot = arr[max];
        int i = min - 1;
        for (int j = min; j < max; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(i, j);
            }
            comparison_counter++;
        }
        swap(i + 1, max);
        return i + 1;
    }
    /**
     * Sort method
     * @param min
     * @param max
     */
    private void sort(int min, int max){ // ???
        // fill this method
        if (min < max) {
            int pi = partition(min, max);
            sort(min, pi - 1);
            sort(pi + 1, max);
        }
    }
    /**
     * Sort method
     */
    @Override
    public void sort() { 
    	sort(0, arr.length - 1);
    }
    /**
     * Print method
     */
    @Override
    public void print() {
    	System.out.print("Quick Sort\t=>\t");
    	super.print();
    }
}
