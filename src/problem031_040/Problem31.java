package problem031_040;

public class Problem31 {
	public static void main(String args[]) {
		int n = 1; // 2 pound coin
		for (int b = 0; b <= 2; b++) {
			if (100 * b == 200) {
				n++;
				break;
			}
			for (int c = 0; c <= 4; c++) {
				if (100 * b + 50 * c == 200) {
					n++;
					break;
				}
				for (int d = 0; d <= 10; d++) {
					if (100 * b + 50 * c + 20 * d == 200) {
						n++;
						break;
					}
					for (int e = 0; e <= 20; e++) {
						if (100 * b + 50 * c + 20 * d + 10 * e == 200) {
							n++;
							break;
						}
						for (int f = 0; f <= 40; f++) {
							if (100 * b + 50 * c + 20 * d + 10 * e + 5 * f == 200) {
								n++;
								break;
							}
							for (int g = 0; g <= 100; g++) {
								if (100 * b + 50 * c + 20 * d + 10 * e + 5 * f + 2 * g == 200) {
									n++;
									break;
								}
								for (int h = 0; h <= 200; h++) {
									if (100 * b + 50 * c + 20 * d + 10 * e + 5 * f + 2 * g + h == 200) {
										n++;
										break;
									}
								}
							}
						}
					}
				}
			}
		}
		System.out.println(n);
	}
}
