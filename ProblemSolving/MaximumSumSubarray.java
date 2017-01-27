public class MaximumSumSubarray {

	public static int usingKadaneAlgorithm(int[] array) {
		int maxGlobal = array[0];
		int maxCurrent = array[0];

		for (int i = 1; i < array.length; i++) {
			maxCurrent = Math.max(array[i], (maxCurrent + array[i]));
			if (maxCurrent > maxGlobal)
				maxGlobal = maxCurrent;
		}
		return maxGlobal;
	}
}
