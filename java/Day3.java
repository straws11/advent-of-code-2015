import java.util.ArrayList;

public class Day3 {
	private static int gridSize = 200; // just a guess

	public static void main(String[] args) {
		int count = solve(false);
		System.out.println("Day 3 Part 1: " + count);

		int count2 = solve(true);
		System.out.println("Day 3 Part 2: " + count2);
	}

	// solve day 3, part decided by boolean param
	static int solve(boolean part2) {
		ArrayList<String> lines = Utils.readFile("input/day3_input.txt");
		String input = lines.get(0); // single line input problem

		int row = gridSize / 2;
		int col = gridSize / 2;
		int roboRow = gridSize / 2;
		int roboCol = gridSize / 2;
		int tempRow = 0;
		int tempCol = 0;

		ArrayList<ArrayList<Character>> grid = createGrid(gridSize);
		// get reference to the appropriate ArrayList, set element at `col`
		// position
		grid.get(row).set(col, 'X');
		for (char c : input.toCharArray()) {
			if (part2) {
				// swap out robo and normal so the `switch` is unchanged
				tempRow = row;
				row = roboRow;
				roboRow = tempRow;

				tempCol = col;
				col = roboCol;
				roboCol = tempCol;
			}
			switch (c) {
				case '^':
					row--;
					break;
				case '>':
					col++;
					break;
				case 'v':
					row++;
					break;
				case '<':
					col--;
					break;
			}
			grid.get(row).set(col, 'X');
		}

		// count visited positions
		return countVisited(grid);
	}

	// count all 'X' chars in ArrayList char grid
	static int countVisited(ArrayList<ArrayList<Character>> grid) {
		int count = 0;
		for (int i = 0; i < gridSize; i++) {
			for (int j = 0; j < gridSize; j++) {
				if (grid.get(i).get(j) == 'X') {
					count++;
				}
			}
		}
		return count;
	}

	// Create 2D grid of given size
	static ArrayList<ArrayList<Character>> createGrid(int size) {
		ArrayList<ArrayList<Character>> grid2D = new ArrayList<>();
		// fill with empty chars
		for (int i = 0; i < size; i++) {
			ArrayList<Character> row = new ArrayList<>();
			for (int j = 0; j < size; j++) {
				row.add(' ');
			}
			grid2D.add(row);
		}
		return grid2D;
	}
}
