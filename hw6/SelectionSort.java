public class SelectionSort extends SortAlgorithm {

	public SelectionSort(int input_array[]) {
		super(input_array);
	}

    @Override
    public void sort() {
        for (int i = 0; i < arr.length-1; i++){
            int minindex = i;
            for (int j = i + 1; j < arr.length; j++){
                comparison_counter++;
                if (arr[j] < arr[minindex]){
                    minindex = j;
                }
            }
            swap(i,minindex);
        }
    }

    @Override
    public void print() {
    	System.out.print("Selection Sort\t=>\t");
    	super.print();
    }
}
