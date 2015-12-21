package problem011_020;
/**
 * Problem15.java 
 * 
 * Version: 
 *     $Id$ 
 * 
 * Revisions: 
 *     $Log$ 
 */

/**
 * @author Josh Wight
 *
 */
public class Problem15 {
	public static void main(String[] args) {
		new Problem15();
	}

	private double[][] moveGrid;

	public Problem15() {
		moveGrid = new double[21][21];
		for (int r = 0; r < 21; r++) {
			for (int c = 0; c < 21; c++) {
				moveGrid[r][c] = 0;
			}
		}
		moveGrid[20][20] = 1;
		System.out.println((fork(0, 0, 0) + fork(0, 0, 1)) + "");
		printGrid();
	}

	// 0 is down, 1 is right
	public double fork(int x, int y, int dir) {
		if (dir == 0) {
			y++;
		} else {
			x++;
		}

		System.out.println("Fork(" + x + ", " + y + ", " + dir);
		if (moveGrid[y][x] == 0) {
			double sum = 0;
			if (y < 20) {
				sum += fork(x, y, 0);
			}
			if (x < 20) {
				sum += fork(x, y, 1);
			}
			moveGrid[y][x] = sum;
			return sum;
		} else {
			return moveGrid[y][x];
		}

	}

	public void printGrid() {
		for (int r = 0; r < 21; r++) {
			for (int c = 0; c < 21; c++) {
				System.out.print("|" + moveGrid[r][c]);
			}
			System.out.println("|");
		}
	}
}
