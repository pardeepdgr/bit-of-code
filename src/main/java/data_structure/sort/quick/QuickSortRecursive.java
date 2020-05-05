package data_structure.sort.quick;

/**
 * runtime complexity:
 * worst case O(n*n), if in each case pivot is chosen either largest or smallest
 * best case Ω(nlogn), average case θ(nlogn)
 * n because (n-1) comparison and logn because list will be divided logn times
 * 
 * fasted sort on average do comparison in-place so no extra space
 * which cause less time as no exchange of element in between
 *
 * https://www.toptal.com/developers/sorting-algorithms
 * http://sorting.at/
 */
public class QuickSortRecursive {

	public static int[] sort(int[] dataSet) {
		if (dataSet == null || dataSet.length == 0)
			return null;
		quickSort(dataSet, 0, dataSet.length - 1);
		return dataSet;
	}

	private static void quickSort(int[] dataSet, int low, int high) {
		int left = low;
		int right = high;
		int pivotValue = dataSet[low + (high - low) / 2];

		while (left <= right) {

			while (dataSet[left] < pivotValue) {
				left++;
			}
			while (dataSet[right] > pivotValue) {
				right--;
			}

			if (left <= right) {
				swap(dataSet, left, right);
				left++;
				right--;
			}
		}

		if (low < right) {
			quickSort(dataSet, low, right);
		}
		if (left < high) {
			quickSort(dataSet, left, high);
		}
	}

	private static void swap(int[] dataSet, int left, int right) {
		if (left != right) {
			dataSet[left] = dataSet[left] + dataSet[right];
			dataSet[right] = dataSet[left] - dataSet[right];
			dataSet[left] = dataSet[left] - dataSet[right];
		}
	}

}
