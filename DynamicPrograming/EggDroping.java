public class EggDroping {

	private static final int NUMBER_OF_EGGS = 2;
	private static final int NUMBER_OF_FLOORS = 100;

	public static void main(String[] args) {
		EggDroping eggDroppingProblem = new EggDroping();

		int attempts = eggDroppingProblem.calculateMinNumberOfAttempts(NUMBER_OF_EGGS, NUMBER_OF_FLOORS);

		System.out.println("When " + NUMBER_OF_EGGS + " eggs will be dropped from a building of " + NUMBER_OF_FLOORS + " floors.");
		System.out.println("Minimum number of attempts to find out from what floor eggs will start breaking is " + attempts + ".");
	}

	private int calculateMinNumberOfAttempts(int eggs, int floors) {
		// Bigger size matrix because 0th array is not being used
		int[][] matrix = new int[eggs + 1][floors + 1];

		for (int floor = 0; floor < floors; floor++)
			matrix[1][floor] = floor;

		int attempts = 0;
		for (int numberOfEggs = 2; numberOfEggs <= eggs; numberOfEggs++) {
			for (int numberOfFloors = 1; numberOfFloors <= floors; numberOfFloors++) {
				matrix[numberOfEggs][numberOfFloors] = NUMBER_OF_FLOORS;

				for (int currentFloor = 1; currentFloor <= numberOfFloors; currentFloor++) {
					attempts = 1 + Math.max(matrix[numberOfEggs - 1][currentFloor - 1], matrix[numberOfEggs][numberOfFloors - currentFloor]);
					System.out.print(" "+attempts);
					if (attempts < matrix[numberOfEggs][numberOfFloors])
						matrix[numberOfEggs][numberOfFloors] = attempts;
				}
				System.out.println();
			}
		}
		return matrix[eggs][floors];
	}
	
}
