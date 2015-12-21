package problem091_100;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Problem96 {

	private static int NUM_GRIDS = 50;
	
	public static void main(String[] args) {
		ArrayList<int[]> grids = new ArrayList<int[]>();
		try {
			BufferedReader br = new BufferedReader(new FileReader("sudoku.txt"));
			for(int i=0; i<NUM_GRIDS; i++) {
				br.readLine();
				int grid[] = new int[81];
				for(int j=0; j<9; j++) {
					String line = br.readLine();
					for(int k=0; k<9; k++) {
						grid[j*9 + k] = Integer.valueOf(line.substring(k, k+1));
					}
				}
				grids.add(grid);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int sum = 0;
		for(int grid[]: grids) {
			solve(grid);
			sum += (grid[0]*100 + grid[1]*10 + grid[2]) ;
		}
		
		
	}
	
	public static void solve(int gird[]) {
		
	}

}
