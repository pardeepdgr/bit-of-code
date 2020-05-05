package data_structure.sort.merge;

/**
 * runtime complexity:
 * worst case O(nlogn), best case Ω(nlogn), average case θ(nlogn)
 * for n elements, merge is done n times and recursions is done logn times
 * space complexity: 
 * for arrays O(n) while for linked lists requires constant space
 * 
 * Performs less comparisons than quick sort both worst case and on average, if
 * performing a comparison is costly choose merge sort
 * 
 * https://www.toptal.com/developers/sorting-algorithms
 * http://sorting.at/
 */
public class MergeSort {

	public static int[] sort(int[] dataSet) {
		if (dataSet == null || dataSet.length == 0)
			return null;
		mergeSort(dataSet, 0, dataSet.length - 1);
		return dataSet;
	}

	private static void mergeSort(int[] dataSet, int low, int high) {
		if (low < high) {
			int middle = low + (high - low) / 2;
			mergeSort(dataSet, low, middle);
			mergeSort(dataSet, middle + 1, high);
			merge(dataSet, low, middle, high);
		}
	}

	private static void merge(int[] dataSet, int low, int middle, int high) {
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

	private static int[] getDuplicateDataSet(int[] dataSet) {
		int[] duplicateDataSet = new int[dataSet.length];

		for (int index = 0; index < dataSet.length; index++)
			duplicateDataSet[index] = dataSet[index];
		return duplicateDataSet;
	}

}
