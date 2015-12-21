package problem101_110;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import euler.util.LinearAlgebra;

public class Problem102 {
	public static void main(String args[]) {
		ArrayList<String> lines = new ArrayList<String>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("triangles_102.txt"));
			for(String line=br.readLine();line!=null;line=br.readLine()) {
				System.out.println(line);
				lines.add(line);
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		int total = 0;
		Point o = new Point(0, 0);
		
		for(String line: lines) {
			String vals[] = line.split(",");
			Point p = new Point(Integer.valueOf(vals[0]), Integer.valueOf(vals[1]));
			Point q = new Point(Integer.valueOf(vals[2]), Integer.valueOf(vals[3])); 
			Point r = new Point(Integer.valueOf(vals[4]), Integer.valueOf(vals[5])); 
			
			//there has to be a better way to do this
			
			double qpr = LinearAlgebra.getAngle(q, p, r);
			double rqp = LinearAlgebra.getAngle(r, q, p);
			double prq = LinearAlgebra.getAngle(p, r, q);
			
			double opq = LinearAlgebra.getAngle(o, p, q);
			double opr = LinearAlgebra.getAngle(o, p, r);
			double oqp = LinearAlgebra.getAngle(o, q, p);
			double oqr = LinearAlgebra.getAngle(o, q, r);
			double orp = LinearAlgebra.getAngle(o, r, p);
			double orq = LinearAlgebra.getAngle(o, r, q);
			
			System.out.print("Triangle (" +p.x + ", " +p.y + "); (" + q.x + ", " + q.y + "); (" + r.x + ", " + r.y + ")");
			
			if(opq<=qpr && opr<=qpr && oqp<=rqp && oqr<=rqp && orp<=prq && orq<=prq) {
				total++;
				System.out.println(" contains the origin");
			}
			else {
				System.out.println(" does not contain the origin");
			}
		}
		System.out.println(total);
	}
}
