import java.util.Random;

public class Game {

	public final static int C = 21; // Constant

	/*
	 * Possible Issues:
	 * - Car will eventually go off the screen with enough down shifts.
	 * - Is the car suppose to stay at the bottom or top of the screen?da
	 * - 
	 */

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[][] grid = new int[21][21];

		for (int j = 0; j < grid.length; j++) {
			for (int k = 0; k < grid.length; k++) {
				if (j >= 0 && j <= 6) {
					grid[j][k] = 0;
				} else if (j > 6 && j <= 12) {
					grid[j][k] = 1;
				} else if (j >= 14 && j <= 21) {
					grid[j][k] = 0;

				}

			}
		}
		for(int i = 0 ; i <200;i++)
		{
			randomShift(grid);
			printArray(grid);
		}
	}
	static void randomShift(int grid[][])
	{
		Random rand = new Random();
		int n = rand.nextInt(3);
		if(n ==1)
			shiftLeft(grid);
		if(n ==2)
			shiftRight(grid);
		shiftDown(grid);
	}
	static void printArray(int grid[][]) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				System.out.print(grid[j][i] + " ");
			}
			System.out.print("\n");
		}
	}
	static void shiftDown(int grid[][]) {
		for (int row = C - 1; row > 0; row--) {
			for (int col = 0; col < C; col++) {
				grid[col][row] = grid[col][row - 1];
			}
		}
		System.out.print("\n");
	}
	static void shiftRight(int grid[][]) {
		if (grid[C-2][0] ==1)
			return;
		for (int col = C-1; col > 0; col--) {
			if ((col + 1) == C)
				grid[col][0] = 0;
			else
			{
				grid[col][0] = grid[col - 1][0];
			}
		}
	}
	static void shiftLeft(int grid[][]) {
		if (grid [1][0] ==1)
			return;	
		for (int col = 0; col < C-1; col++) {
			grid[col][0] = grid[col + 1][0];
		}
		System.out.println();
	}
}
