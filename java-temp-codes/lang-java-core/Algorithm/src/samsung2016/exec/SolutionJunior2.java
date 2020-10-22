package samsung2016.exec;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class SolutionJunior2 {
	static int N;
	static int k;
	static String s;
	static int Answer;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream(
				"D:\\workspace_demo\\Algorithm\\data\\SolutionJunior2.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int testCase = 1; testCase <= T; testCase++) {
			N = sc.nextInt();
			k = sc.nextInt();
			s = sc.next();
			Answer = 0;
			// ////////////////////////////
			Stack<Integer> stack = new Stack<Integer>();
			for (int j = 0; j < s.length(); j++) {
				if (s.charAt(j) == '(') {
					stack.push(j + 1);
				} else if (stack.isEmpty()) {
					Answer = 0;
					break;
				} else if (stack.pop() == k) {
					Answer = j + 1;
				}
			}// for j
			// ////////////////////////////
			System.out.println(N + " " + k + " " + s);
			System.out.println("#" + testCase + " " + Answer);
		}// for testCase
	}

}
