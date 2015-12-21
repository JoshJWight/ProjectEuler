package euler.util;

import java.awt.Point;

public class LinearAlgebra {
	public static int dotProduct(Point u, Point v) {
		return u.x*v.x + u.y*v.y;
	}
	/**
	 * maginitude of 2d vector
	 * @param v
	 * @return
	 */
	public static double magnitude(Point v) {
		return Math.sqrt(v.x*v.x + v.y*v.y);
	}
	
	/**
	 * Get angle between 2d vectors
	 * @param u
	 * @param v
	 * @return
	 */
	public static double getAngle(Point u, Point v) {
		return Math.acos(dotProduct(u, v)/(magnitude(u)*magnitude(v)));
	}
	
	/**
	 * Get angle formed by 2d points
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static double getAngle(Point a, Point b, Point c) {	
		Point u = new Point(a.x-b.x, a.y-b.y);
		Point v = new Point(c.x-b.x, c.y-b.y);
		return getAngle(u, v);
	}
}
