package binary;

/**
 * Binary search has O(logn) time complexity
 */
public class BinarySearch {

	public static void main(String[] args) {
		int[] dataSet = { 10, 78, 87, 14, 25, 4, 92, 72, 89, 1 };
		sortDataSet(dataSet);
		int index = binarySearch(dataSet, 0, dataSet.length - 1, 100);
		printResult(index);
	}

	private static void sortDataSet(int[] dataSet) {
		QuickSort algo = new QuickSort();
		algo.sort(dataSet);
	}

	private static int binarySearch(int[] dataSet, int low, int high,
			int element) {
		while (low < high) {
			int median = low + (high - low) / 2;
			if (dataSet[median] > element)
				high = median - 1;
			else if (dataSet[median] < element)
				low = median + 1;
			else
				return median;
		}
		if (low == high && dataSet[low] == element)
			return low;

		return -1;
	}

	private static void printResult(int index) {
		if (index >= 0)
			System.out.println("Element is fount at " + index + "th position.");
		else
			System.out.println("Element not found.");
	}

}
