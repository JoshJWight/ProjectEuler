package problem081_090;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem82.java 
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
public class Problem82 {
	public static void main(String[] args) throws IOException {
		int[][] matrix = new int[80][80];
		int[][] mins = new int[80][80];

		BufferedReader br = new BufferedReader(new FileReader("matrix.txt"));
		for (int i = 0; i < 80; i++) {
			String s = br.readLine();
			String[] nums = s.split(",");
			for (int j = 0; j < 80; j++) {
				matrix[i][j] = Integer.valueOf(nums[j]);
			}
		}

		for (int c = 0; c < 80; c++) {
			System.out.println("c = " + c);
			// first iteration
			for (int r = 0; r < 80; r++) {
				if (c == 0) {
					mins[r][c] = matrix[r][c];
				} else {
					mins[r][c] = matrix[r][c] + mins[r][c - 1];
				}
			}
			// further iterations
			if (c < 79 && c > 0) {
				for (int i = 0; i < 80; i++) {
					for (int r = 0; r < 80; r++) {
						if (r > 0) {
							if (matrix[r][c] + mins[r - 1][c] < mins[r][c]) {
								mins[r][c] = matrix[r][c] + mins[r - 1][c];
							}
						}
						if (r < 79) {
							if (matrix[r][c] + mins[r + 1][c] < mins[r][c]) {
								mins[r][c] = matrix[r][c] + mins[r + 1][c];
							}
						}
					}
				}
			}
		}

		int min = Integer.MAX_VALUE;
		for (int r = 0; r < 80; r++) {
			if (mins[r][79] < min) {
				min = mins[r][79];
			}
		}

		System.out.println("" + min);

	}
}
