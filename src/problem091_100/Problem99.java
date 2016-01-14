package problem091_100;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Problem99 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Paths.get("exponents.txt"));

		double bigB = 1;
		double bigE = 1;
		
		for(int i=0; i<lines.size(); i++) {
			String l = lines.get(i);
			String nums[] = l.split(",");
			double b = Long.valueOf(nums[0]);
			double e = Long.valueOf(nums[1]);
			
			if(e > bigE * Math.log(bigB) / Math.log(b)) {
				System.out.println((i+1) + ": " + b + "^" + e);
				bigB = b;
				bigE = e;
			}
		}
		
	}

}
