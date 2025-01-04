import java.util.ArrayList;
import java.util.Arrays;

public class Day2 {
	public static void main(String[] args) {
		ArrayList<String> lines = Utils.readFile("input/day2_input.txt");
		int total = 0;
		int ribbonTotal = 0;
		for (String s : lines) {
			// split into String[3]
			String[] dimStrings = s.split("x");

			// convert String[3] to int[3]
			int[] dims = new int[3];
			for (int i = 0; i < 3; i++) {
				dims[i] = Integer.parseInt(dimStrings[i]);
			}
			Arrays.sort(dims);
			total += 2 * (dims[0] * dims[1] + dims[0] * dims[2] + dims[1] * dims[2]) + dims[0] * dims[1];
			/*
			 * alternative
			 * for (int i = 0; i < 2; i++) {
			 * for (int j = i+1; j < 3; j++) {
			 * total += 2 * dims[i] * dims[j];
			 * }
			 * }
			 * total += dims[0] * dims[1];
			 */
			ribbonTotal += totalRibbon(dims); // for part 2
		}
		System.out.println("Day 2 Part 1: " + total);
		System.out.println("Day 2 Part 2: " + ribbonTotal);
	}

	// for part 2
	public static int totalRibbon(int[] dimensions) {
		// `dimensions` is already sorted
		int smallestPeri = 2 * (dimensions[0] + dimensions[1]);
		return smallestPeri + dimensions[0] * dimensions[1] * dimensions[2];
	}
}
