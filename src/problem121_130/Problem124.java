package problem121_130;

import java.util.ArrayList;
import java.util.Collections;

public class Problem124 {

	public static void main(String[] args) {
		
		ArrayList<Node> nodes = new ArrayList<Node>();
		for(int n=1; n<=100000; n++) {
			nodes.add(getNode(n));
		}
		Collections.sort(nodes);
		System.out.println(nodes.get(9999).n);
	}
	
	public static Node getNode(int n) {
		int r = 1;
		
		int i = n;
		for(int j=2; j<=i; j++) {
			if(i%j==0) {
				r *= j;
			}
			while(i%j==0) {
				i = i/j;
			}
		}
		
		return new Node(n, r);
	}
	
	public static class Node implements Comparable{
		public Integer n;
		public Integer r;
		
		public Node(int n, int r) {
			this.n = n;
			this.r = r;
		}
		
		@Override
		public int compareTo(Object other) {
			if(other instanceof Node) {
				Node node = (Node) other;
				if(r!=node.r) {
					return r.compareTo(node.r);
				}
				return n.compareTo(node.n);
			}
			
			return 0;
		}
	}

}
