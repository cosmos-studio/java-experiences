package samsung2016.exec;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SolutionJunior3 {
	static int R;
	static int[] x;
	static int[] y;
	static int Answer;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(
				"D:\\workspace_demo\\Algorithm\\data\\SolutionJunior3.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			R = sc.nextInt();
			x = new int[R + 1];
			y = new int[R + 1];
			for (int i = 0; i < R + 1; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			Answer = 0;
			// ////////////////////////////
			for (int j = 1; j <= R; j++) {
				if ((x[j] == x[0]) || (y[j] == y[0])
						|| (x[j] - x[0] == y[j] - y[0])) {
					Answer++;
				}
			}
			// ////////////////////////////
			System.out.println("Fox -> (" + x[0] + ", " + y[0] + ")");
			for (int i = 1; i <= R; i++) {
				System.out.print("(" + x[i] + ", " + y[i] + ") ");
			}
			System.out.println();
			System.out.println("#" + testCase + " " + Answer);
		}// for testCase
	}

}
