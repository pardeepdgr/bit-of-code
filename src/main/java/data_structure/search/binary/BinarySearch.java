package data_structure.search.binary;

import data_structure.sort.quick.QuickSortRecursive;

/**
 * Binary Search has O(logn) Runtime complexity.
 *
 * Binary Search doesn't return index of found element as dataset is already sorted and not in original form.
 */
public class BinarySearch {

	public static boolean search(int[] dataSet, int elementToSearch) {
		QuickSortRecursive.sort(dataSet);

		int index = binarySearch(dataSet, 0, dataSet.length - 1, elementToSearch);

		return index > -1;
	}

	private static int binarySearch(int[] dataSet, int low, int high, int element) {
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

}
