package problem081_090;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.PriorityQueue;

public class Problem83 {
	
	

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("matrix_83.txt"));
		
		int matrix[][] = new int[80][80];
		int costs[][] = new int[80][80];
		
		PriorityQueue<FrontierNode> frontier = new PriorityQueue<FrontierNode>();
		
		for(int i=0; i<80; i++) {
			String l = lines.get(i);
			String arr[] = l.split(",");
			for(int j=0; j<80; j++) {
				matrix[i][j] = Integer.valueOf(arr[j]);
			}
		}
		
		frontier.add(new FrontierNode(0, 0, 0));
		while(!frontier.isEmpty()) {
			FrontierNode n = frontier.remove();
			if(n.r<0 || n.r>=80 || n.c<0 || n.c>=80) {
				continue;
			}
			int val = matrix[n.r][n.c];
			int oldcost = costs[n.r][n.c];
			int newcost = n.cost + val;
			if(oldcost>0 && oldcost<newcost) {
				continue;
			} else {
				costs[n.r][n.c]=newcost;
				frontier.add(new FrontierNode(n.r-1, n.c, newcost));
				frontier.add(new FrontierNode(n.r+1, n.c, newcost));
				frontier.add(new FrontierNode(n.r, n.c-1, newcost));
				frontier.add(new FrontierNode(n.r, n.c+1, newcost));
			}
		}
		printMatrix(matrix);
		System.out.println("\n\n\n\n");
		printMatrix(costs);
		System.out.println(costs[79][79]);
	}
	
	public static void printMatrix(int m[][]) {
		for(int r[]: m) {
			for(int i: r) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static class FrontierNode implements Comparable{
		public int r;
		public int c;
		public Integer cost;
		public FrontierNode(int r, int c, int cost) {
			this.r=r;
			this.c=c;
			this.cost=cost;
		}
		
		@Override
		public int compareTo(Object other) {
			if(other instanceof FrontierNode) {
				FrontierNode n = (FrontierNode)other;
				return this.cost.compareTo(n.cost);
			} else return 0;
		}
		
	}
}
