package binary;

public class QuickSort {

	public void sort(int[] dataSet) {
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

}