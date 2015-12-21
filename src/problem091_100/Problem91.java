package problem091_100;

import java.awt.Point;

import euler.util.LinearAlgebra;

public class Problem91 {

	public static void main(String[] args) {
		int max = 50;
		
		int count = 0;
		Point p = new Point(0,0);
		//for(Point p = new Point(0, 0); p.x<=max; p=nextPoint(p, max)) {
			//System.out.println("p: " + p.x + ", " + p.y);
			for(Point q = nextPoint(p, max); q.x<=max; q=nextPoint(q, max)) {
				//System.out.println("q: " + q.x + ", " + q.y);
				for(Point r = nextPoint(q, max); r.x<=max; r=nextPoint(r, max)) {
					//System.out.println("r: " + r.x + ", " + r.y);
					if(isRightTriangle(p, q, r)){
						System.out.println("Right triangle: (" + p.x + ", " + p.y + "); (" + q.x + ", " + q.y + "); (" + r.x + ", " + r.y + ")");
						count++;
					}
				}
			}
		//}
		
		System.out.println(count);
	}
	
	private static Point nextPoint(Point p, int max) {
		
		
		if(p.x>=max) {
			return new Point(p.y+1, max);
		}
		if(p.y<=0) {
			return new Point(0, p.x+1);
		}
		return new Point(p.x+1, p.y-1);
	}
	
	private static boolean isRightTriangle(Point p, Point q, Point r) {
		Point u = new Point(p.x-q.x, p.y-q.y);
		Point v = new Point(r.x-q.x, r.y-q.y);
		Point w = new Point(p.x-r.x, p.y-r.y);
		
		if(LinearAlgebra.dotProduct(u, v)==0) {
			return true;
		}
		if(LinearAlgebra.dotProduct(v, w)==0) {
			return true;
		}
		if(LinearAlgebra.dotProduct(w, u)==0) {
			return true;
		}
		return false;
	}

}
