package quicksort;

/**
 * runtime complexity:
 * worst case O(n*n), if in each case pivot is chosen either largest or smallest
 * best case Ω(nlogn), average case θ(nlogn)
 * n because (n-1) comparison and logn because list will be divided logn times
 * 
 * fasted sort on average do comparison in-place so no extra space
 * which cause less time as no exchange of element in between
 */
public class QuickSortRecursive {

	public static void main(String args[]) {
		int[] dataSet = { 43, 21, 67, 5, 87, 40, 100, 87, 72, 89, 2, 50 };
		QuickSortRecursive algo = new QuickSortRecursive();

		printDataSet(dataSet, "Unsorted");
		algo.sort(dataSet);
		printDataSet(dataSet, "Sorted");
	}

	private void sort(int[] dataSet) {
		if (dataSet == null || dataSet.length == 0)
			return;
		quickSort(dataSet, 0, dataSet.length - 1);
	}

	private void quickSort(int[] dataSet, int low, int high) {
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
