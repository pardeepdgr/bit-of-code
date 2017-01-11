package insertionsort;

/**
 * runtime complexity:
 * best case Ω(n), when list is already sorted
 * average case θ(n*n), worst case O(n*n)
 * 
 * Algorithm of choice either when the data is sorted or nearly sorted[1]
 * or when the problem size is small (because it has low overhead[2]) 
 * 
 * [1] while inserting elements into the sorted portion only a single comparison required
 * [2] low overhead because of shorter code, less memory consumption and avoiding recursion
 *     higher overhead in divide-and-conquer sorting algorithms, such as merge/quick sort
 */
public class InsertionSort {

	public static void main(String args[]) {
		int[] dataSet = { 43, 21, 89, 67, 87, 5, 40, 100, 87, 72, 89, 2, 50 };
		InsertionSort algo = new InsertionSort();

		printDataSet(dataSet, "Unsorted");
		algo.insertionSort(dataSet);
		printDataSet(dataSet, "Sorted");
	}

	private void insertionSort(int[] dataSet) {
		int high = dataSet.length - 1;

		for (int low = 1; low <= high; low++) {
			for (int mark = low; mark > 0; mark--) {
				if (dataSet[mark-1] > dataSet[mark]) {
					swap(dataSet, mark-1, mark);
				}
			}
		}
	}

	private void swap(int[] dataSet, int left, int right) {
		if (left != right) {
			dataSet[left] = dataSet[left] + dataSet[right];
			dataSet[right] = dataSet[left] - dataSet[right];
			dataSet[left] = dataSet[left] - dataSet[right];
		}
	}

	private static void printDataSet(int[] dataSet, String status) {
		System.out.print(status + " Data Set: ");
		for (int element : dataSet)
			System.out.print(element + " ");
		System.out.println();
	}
}
