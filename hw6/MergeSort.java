/**
 * MergeSort class
 */
public class MergeSort extends SortAlgorithm {
    /**
     * Constructor
     * 
     * @param input_array
     */
	public MergeSort(int input_array[]) {
		super(input_array);
	}
	/**
     * Merge method to merge two subarrays
     * @param left
     * @param mid
     * @param right
     */
    private void merge(int left, int mid, int right) {
        // division of array to two subarrays, n1 and n2 is the size of the two subarrays
        int n1 = mid - left + 1;
        int n2 = right - mid;
        // creation of two subarrays
        int L[] = new int[n1];
        int R[] = new int[n2];
        // copy the elements to the subarrays
        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];
            
        int i = 0, j = 0;
        
        // merge the two subarrays
        // k is the index of the merged subarray
        // i is the index of the first subarray
        // j is the index of the second subarray

        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
            comparison_counter++;
        }
        // copy the remaining elements of L[] if there are any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        // copy the remaining elements of R[] if there are any
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    /**
     * Recursive sort method
     * @param left
     * @param right
     */
    private void sort(int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            sort(left, mid);
            sort(mid + 1, right);

            merge(left, mid, right);
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
    	System.out.print("Merge Sort\t=>\t");
    	super.print();
    }
}
