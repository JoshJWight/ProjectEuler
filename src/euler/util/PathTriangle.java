package euler.util;

import java.util.ArrayList;

/**
 * PathTriangle.java 
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
public class PathTriangle {
	ArrayList<int[]> tree;
	ArrayList<int[]> linkTree;
	ArrayList<int[]> sumTree;

	public PathTriangle() {
		tree = new ArrayList<int[]>();
	}

	public void addRow(int[] row) {
		if (row.length != tree.size() + 1) {
			System.err.println("Wrong row size!");
		} else {
			tree.add(row);
		}
	}

	public int maxPath() {
		linkTree = new ArrayList<int[]>();
		for (int i = 0; i < tree.size(); i++) {
			int[] links = new int[i + 1];
			for (int a = 0; a < i + 1; a++) {
				links[a] = -1;
			}
		}
		sumTree = new ArrayList<int[]>();
		for (int i = 0; i < tree.size(); i++) {
			int[] sum = new int[i + 1];
			for (int a = 0; a < i + 1; a++) {
				sum[a] = 0;
			}
			sumTree.add(sum);
		}
		sumTree.get(0)[0] = tree.get(0)[0];
		for (int a = 1; a < tree.size(); a++) {
			for (int b = 0; b < a + 1; b++) {
				int cur = tree.get(a)[b];
				if (b == 0) {
					sumTree.get(a)[0] = sumTree.get(a - 1)[0] + cur;
				} else if (b == a) {
					sumTree.get(a)[b] = sumTree.get(a - 1)[b - 1] + cur;
				} else {
					int first = sumTree.get(a - 1)[b - 1];
					int second = sumTree.get(a - 1)[b];
					if (first > second) {
						sumTree.get(a)[b] = first + cur;
					} else {
						sumTree.get(a)[b] = second + cur;
					}
				}
			}
		}
		int max = 0;
		for (int a = 0; a < sumTree.size(); a++) {
			int sum = sumTree.get(sumTree.size() - 1)[a];
			if (sum > max) {
				max = sum;
			}
		}
		return max;
	}
}
