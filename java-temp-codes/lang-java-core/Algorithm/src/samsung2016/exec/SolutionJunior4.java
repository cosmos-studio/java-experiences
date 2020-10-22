package samsung2016.exec;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class SolutionJunior4 {
	static String x;
	static String y;
	static String Answer;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(
				"D:\\workspace_demo\\Algorithm\\data\\SolutionJunior4.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			x = sc.next();
			y = sc.next();
			Answer = "";
			// ////////////////////////////
			int maxLen = x.length() > y.length() ? x.length() + 1
					: y.length() + 1;
			int[] xi = new int[maxLen];
			setData(x, xi);
			int[] yi = new int[maxLen];
			setData(y, yi);
			int[] zi = new int[maxLen];
			String s = "";
			for (int j = 0; j < maxLen - 1; j++) {
				if (xi[j] == 0) {
					zi[j] += yi[j];
				} else if (yi[j] == 0) {
					zi[j] += xi[j];
				} else if (xi[j] != yi[j]) {
					zi[j] += 0;
				} else if (xi[j] == 1) {
					zi[j] += 2;
					while (zi[j] >= 2) {
						zi[j] += -2;
						zi[j + 1] += 1;
					}
				} else if (xi[j] == -1) {
					zi[j] += -2;
					while (zi[j] <= -2) {
						zi[j] += 2;
						zi[j + 1] += -1;
					}
				}
			}
			boolean flag = false;
			for (int i = maxLen - 1; i >= 0; i--) {
				if ((!flag) && (zi[i] != 0)) {
					flag = true;
				}
				if (flag) {
					switch (zi[i]) {
					case 1:
						s += "+";
						break;
					case 0:
						s += "0";
						break;
					case -1:
						s += "-";
						break;
					}
				} else if (i == 0) {
					s = "0";
				}
			}
			Answer = s;
			// ////////////////////////////
			// System.out.println(x + "\t" + y);
			System.out.println("#" + testCase + " " + Answer);
		}// for testCase
	}

	private static void setData(String s, int[] x) {
		int len = s.length();
		for (int i = len - 1; i >= 0; i--) {
			switch (s.charAt(len - 1 - i)) {
			case '+':
				x[i] = 1;
				break;
			case '0':
				x[i] = 0;
				break;
			case '-':
				x[i] = -1;
				break;
			}
		}
	}

}
