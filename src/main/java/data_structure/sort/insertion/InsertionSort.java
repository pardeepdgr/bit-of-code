package data_structure.sort.insertion;

/**
 * runtime complexity:
 * best case Ω(n), when list is already sorted
 * average case θ(n*n), worst case O(n*n)
 * 
 * Algorithm of choice either when the data is sorted or nearly sorted[1]
 * or when the problem size is small (because it has low overhead[2])
 * or there is few unique data and no extra space required (Merge)
 * 
 * [1] while inserting elements into the sorted portion only a single comparison required
 * [2] low overhead because of shorter code, less memory consumption and avoiding recursion
 *     higher overhead in divide-and-conquer sorting algorithms, such as merge/quick sort
 *
 * https://www.toptal.com/developers/sorting-algorithms
 * http://sorting.at/
 */
public class InsertionSort {

	public static int[] sort(int[] dataSet) {
		int high = dataSet.length - 1;

		for (int low = 1; low <= high; low++) {
			for (int mark = low; mark > 0; mark--) {
				if (dataSet[mark-1] > dataSet[mark]) {
					swap(dataSet, mark-1, mark);
				}
			}
		}
		return dataSet;
	}

	private static void swap(int[] dataSet, int left, int right) {
		if (left != right) {
			dataSet[left] = dataSet[left] + dataSet[right];
			dataSet[right] = dataSet[left] - dataSet[right];
			dataSet[left] = dataSet[left] - dataSet[right];
		}
	}

}
