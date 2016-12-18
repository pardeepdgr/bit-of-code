package mergesort;

/**
 * runtime complexity:
 * worst case O(nlogn), best case Ω(nlogn), average case θ(nlogn)
 * for n elements, merge is done n times and recursions is done logn times
 * space complexity: O(n) 
 * 
 * performs less comparisons than quick sort both worst case and on average, if
 * performing a comparison is costly choose merge sort
 */
public class MergeSort {

	public static void main(String args[]) {
		int[] dataSet = { 43, 21, 67, 5, 87, 40, 100, 87, 72, 89, 2, 50 };
		MergeSort algo = new MergeSort();

		printDataSet(dataSet, "Unsorted");
		algo.sort(dataSet);
		printDataSet(dataSet, "Sorted");
	}

	private void sort(int[] dataSet) {
		if (dataSet == null || dataSet.length == 0)
			return;
		mergeSort(dataSet, 0, dataSet.length - 1);
	}

	private void mergeSort(int[] dataSet, int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			mergeSort(dataSet, low, middle);
			mergeSort(dataSet, middle + 1, high);
			merge(dataSet, low, middle, high);
		}
	}

	private void merge(int[] dataSet, int low, int middle, int high) {
		int left = low;
		int start = low;
		int pin = middle + 1;
		int[] duplicateDataSet = getDuplicateDataSet(dataSet);

		while (left <= middle && pin <= high) {
			if (duplicateDataSet[left] <= duplicateDataSet[pin])
				dataSet[start++] = duplicateDataSet[left++];
			else
				dataSet[start++] = duplicateDataSet[pin++];
		}
		while (left <= middle)
			dataSet[start++] = duplicateDataSet[left++];
	}

	private int[] getDuplicateDataSet(int[] dataSet) {
		int[] duplicateDataSet = new int[dataSet.length];

		for (int index = 0; index < dataSet.length; index++)
			duplicateDataSet[index] = dataSet[index];
		return duplicateDataSet;
	}

	private static void printDataSet(int[] dataSet, String status) {
		System.out.print(status + " Data Set: ");
		for (int element : dataSet)
			System.out.print(element + " ");
		System.out.println();
	}
}
