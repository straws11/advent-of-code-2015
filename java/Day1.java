import java.util.ArrayList;

public class Day1 {
	public static void main(String[] args) {
		ArrayList<String> lines = Utils.readFile("input/day1_input.txt");
		// day 1 is single line
		String input = lines.get(0);
		int level = 0;
		boolean finding = true;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '(') {
				level++;
			} else if (c == ')') {
				level--;
			}
			if (finding && level == -1) {
				System.out.println("Day 1 Part 2: " + (i + 1));
				finding = false;
			}
		}
		System.out.println("Day 1 Part 1: " + level);
	}
}
