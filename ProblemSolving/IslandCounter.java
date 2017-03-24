

/**
 * In matrix  character represents land while 0 represents water.
 * Find all islands
 */
public class IslandCounter {

	public static void main(String[] args) {
		System.out.println(new IslandCounter().getIslandCount(5, 5, "ab000cd00d00fk0cm0000000D"));
	}

	public int getIslandCount(int row, int column, String sequence) {
		int island = 0;
		char[][] continent = createContinent(row, column, sequence);
		boolean[][] passport = new boolean[row][column];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (!Character.isLetter(continent[i][j])) {
					passport[i][j] = true;
				} else if (passport[i][j] == false) {
					visitWholeIsland(i, j, continent, passport);
					island++;
				}
			}
		}
		return island;
	}

	private char[][] createContinent(int row, int column, String sequence) {
		char[][] matrix = new char[row][column];
		for (int i = 0, index = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				matrix[i][j] = sequence.charAt(index++);
		return matrix;
	}

	private void visitWholeIsland(int row, int column, char[][] continent, boolean[][] passport) {
		if (row > continent.length && column > continent[row].length)
			return;
		int[] accessibleRows = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int[] accessibleColumns = { -1, 0, 1, -1, 1, -1, 0, 1 };

		passport[row][column] = true;

		for (int k = 0; k < 8; k++) {
			if (isLand(row + accessibleRows[k], column + accessibleColumns[k], continent.length, continent[row].length,
					continent, passport))
				visitWholeIsland(row + accessibleRows[k], column + accessibleColumns[k], continent, passport);
		}
	}

	private boolean isLand(int row, int column, int numberOfRows, int numberOfColumns, char[][] continent,
			boolean[][] passport) {
		return (row >= 0) && (row < numberOfRows) && (column >= 0) && (column < numberOfColumns)
				&& (Character.isLetter(continent[row][column])) && (passport[row][column] == false);
	}

}
