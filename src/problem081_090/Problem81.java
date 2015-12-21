package problem081_090;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Problem81.java 
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
public class Problem81 {

	/**
	 * @param args
	 * @throws IOException
	 */
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

		for (int r = 0; r < 80; r++) {
			for (int c = 0; c < 80; c++) {
				if (r == 0 && c == 0) {
					mins[r][c] = matrix[r][c];
				} else if (r == 0) {
					mins[r][c] = matrix[r][c] + mins[r][c - 1];
				} else if (c == 0) {
					mins[r][c] = matrix[r][c] + mins[r - 1][c];
				} else {
					if (mins[r - 1][c] > mins[r][c - 1]) {
						mins[r][c] = matrix[r][c] + mins[r][c - 1];
					} else {
						mins[r][c] = matrix[r][c] + mins[r - 1][c];
					}
				}
			}
		}
		System.out.println("" + mins[79][79]);

	}

}
