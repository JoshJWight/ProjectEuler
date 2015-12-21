package problem061_070;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import euler.util.PathTriangle;

/**
 * Problem67.java 
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
public class Problem67 {
	public static void main(String[] args) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader("triangle.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}

		PathTriangle p = new PathTriangle();
		try {
			String s = br.readLine();
			while (s != null) {
				String[] nums = s.split(" ");
				int[] ints = new int[nums.length];
				for (int i = 0; i < nums.length; i++) {
					ints[i] = Integer.valueOf(nums[i]);
				}
				p.addRow(ints);
				s = br.readLine();
			}
		} catch (IOException e) {

		}
		System.out.println("" + p.maxPath());

	}
}
