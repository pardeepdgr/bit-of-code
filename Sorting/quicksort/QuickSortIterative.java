package quicksort;

/**
 * average or best case time complexity O(nlogn) 
 * O(n) because (n-1) comparison and O(logn) because list will be divided logn times
 * 
 * worst case time complexity O(n*n) 
 * if in each case pivot is chosen either largest or smallest number
 * 
 * fasted sort on average do comparison in-place so no extra space (O(logn) in worst case) 
 * which cause less time because no exchange of element in between
 */
public class QuickSortIterative {

	public static void main(String[] args) {
		int[] dataSet = { 43, 21, 67, 5, 87, 40, 100, 87, 72, 89, 2, 50 };
		QuickSortIterative algo = new QuickSortIterative();

		printDataSet(dataSet, "Unsorted");
		algo.quickSort(dataSet);
		printDataSet(dataSet, "Sorted");
	}

	private void quickSort(int[] dataSet) {
		if (dataSet == null || dataSet.length == 0)
			return;

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
	}

	private int getPivotAndDoShuffle(int[] dataSet, int low, int high) {
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
