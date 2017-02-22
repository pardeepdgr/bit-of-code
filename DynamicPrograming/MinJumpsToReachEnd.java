
public class MinJumpsToReachEnd {

	public static void main(String[] args) {
		int[] array = { 2, 3, 1, 1, 2, 4, 1, 1, 2, 1 };
		int jumps = findMinimumNumberOfJumps(array);
		if (jumps != -1)
			System.out.println("Min. number of jumps : " + jumps);
	}

	private static int findMinimumNumberOfJumps(int[] array) {
		int[] jumpCounter = new int[array.length];
		jumpCounter[0] = 0;

		if (array.length == 0) {
			System.out.println("Array can't be empty");
			return -1;
		} else {
			for (int i = 1, j = 0; i < array.length; i++) {
				if (array[j] >= (i - j)) {
					if (jumpCounter[i - 1] == 0)
						jumpCounter[i] = 1;
					else
						jumpCounter[i] = jumpCounter[i - 1];
				} else {
					while ((array[j] < (i - j)) && (j < array.length - 1)) {
						j++;
					}
					jumpCounter[i] = jumpCounter[j] + 1;
				}
			}
		}

		for (int i : jumpCounter)
			System.out.print(i + " ");
		System.out.println();

		return jumpCounter[array.length - 1];
	}
}
