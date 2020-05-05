package problem;

public class ReverseArrayByGroupSize {

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4, 5, 6 };
		int groupSize = 4;
		int[] reversedArray = reverse(array, groupSize);
		for (int i : reversedArray)
			System.out.print(i + " ");
	}

	private static int[] reverse(int[] array, int groupSize) {

		for (int i = 0; i < array.length; i += groupSize) {
			int low = i;
			int high = (low + (groupSize - 1)) > array.length ? array.length-1
					: (low + (groupSize - 1));

			while (low < high) {
				swap(array, low, high);
				low++;
				high--;
			}
		}
		return array;
	}

	private static void swap(int[] array, int low, int high) {
		array[low] = array[low] + array[high];
		array[high] = array[low] - array[high];
		array[low] = array[low] - array[high];
	}
}
