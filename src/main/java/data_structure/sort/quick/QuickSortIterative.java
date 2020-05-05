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
public class QuickSortIterative {

	public static int[] sort(int[] dataSet) {
		if (dataSet == null || dataSet.length == 0)
			return null;

		int low = 0;
		int high = dataSet.length - 1;
		int[] stack = new int[dataSet.length];
		int top = -1;

		stack[++top] = low;
		stack[++top] = high;

		while (top >= 0) {
			high = stack[top--];
			low = stack[top--];

			int pivot = getPivotAndDoShuffle(dataSet, low, high);

			if (low < pivot - 1) {
				stack[++top] = low;
				stack[++top] = pivot - 1;
			}
			if (pivot + 1 < high) {
				stack[++top] = pivot + 1;
				stack[++top] = high;
			}
		}
		return dataSet;
	}

	private static int getPivotAndDoShuffle(int[] dataSet, int low, int high) {
		int pivotValue = dataSet[high];
		int lower = (low - 1);

		for (int left = low; left <= high - 1; left++) {
			if (dataSet[left] <= pivotValue) {
				lower++;
				swap(dataSet, lower, left);
			}
		}
		swap(dataSet, lower + 1, high);
		return lower + 1;
	}

	private static void swap(int[] dataSet, int left, int right) {
		if (left != right) {
			dataSet[left] = dataSet[left] + dataSet[right];
			dataSet[right] = dataSet[left] - dataSet[right];
			dataSet[left] = dataSet[left] - dataSet[right];
		}
	}

}
