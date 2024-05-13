/**
 * BubbleSort class
 */
public class BubbleSort extends SortAlgorithm {
    /**
     * Constructor
     * 
     * @param input_array
     */
    public BubbleSort(int input_array[]) {
        super(input_array);
    }

    /**
     * Sort method
     */
    @Override
    public void sort() {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comparison_counter += 1;
                if (arr[j] > arr[j + 1]) {
                    swap(j, j + 1);
                }
            }
        }
    }

    /**
     * Print method
     */
    @Override
    public void print() {
        System.out.print("Bubble Sort\t=>\t");
        super.print();
    }
}
