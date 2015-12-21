package problem011_020;

import euler.util.PathTriangle;

/**
 * Problem18.java 
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
public class Problem18 {
	public static void main(String[] args) {
		PathTriangle p = new PathTriangle();

		p.addRow(new int[] { 75 });
		p.addRow(new int[] { 95, 64 });
		p.addRow(new int[] { 17, 47, 82 });
		p.addRow(new int[] { 18, 35, 87, 10 });
		p.addRow(new int[] { 20, 04, 82, 47, 65 });
		p.addRow(new int[] { 19, 01, 23, 75, 03, 34 });
		p.addRow(new int[] { 88, 02, 77, 73, 07, 63, 67 });
		p.addRow(new int[] { 99, 65, 04, 28, 06, 16, 70, 92 });
		p.addRow(new int[] { 41, 41, 26, 56, 83, 40, 80, 70, 33 });
		p.addRow(new int[] { 41, 48, 72, 33, 47, 32, 37, 16, 94, 29 });
		p.addRow(new int[] { 53, 71, 44, 65, 25, 43, 91, 52, 97, 51, 14 });
		p.addRow(new int[] { 70, 11, 33, 28, 77, 73, 17, 78, 39, 68, 17, 57 });
		p.addRow(new int[] { 91, 71, 52, 38, 17, 14, 91, 43, 58, 50, 27, 29, 48 });
		p.addRow(new int[] { 63, 66, 04, 68, 89, 53, 67, 30, 73, 16, 69, 87, 40, 31 });
		p.addRow(new int[] { 04, 62, 98, 27, 23, 9, 70, 98, 73, 93, 38, 53, 60, 04, 23 });

		System.out.println(p.maxPath() + "");
	}
}
