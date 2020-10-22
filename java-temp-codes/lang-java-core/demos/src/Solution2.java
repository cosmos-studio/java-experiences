import java.io.FileInputStream;
import java.util.Scanner;

public class Solution2 {
	static int V, E;
	static int[] E1, E2;
	static int AnswerN;
	static int[] Answer;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/sample2.txt"));
		Scanner sc = new Scanner(System.in);
		// for (int tcase = 1; tcase <= 10; tcase++) {
		for (int tcase = 1; tcase <= 2; tcase++) {
			V = sc.nextInt();
			E = sc.nextInt();
			E1 = new int[E];
			E2 = new int[E];
			for (int i = 0; i < E; i++) {
				E1[i] = sc.nextInt();
				E2[i] = sc.nextInt();
			}
			// algrithm begin
			AnswerN = -1;
			Answer = new int[V];
			final int white = 0;
			final int blank = 1;
			final int noColor = -1;
			int[] nodes = new int[V + 1];
			for (int i = 0; i <= V; i++) {
				nodes[i] = noColor;
			}
			boolean flag = true;
			for (int i = 0; i < E; i++) {
				if ((nodes[E1[i]] == noColor) && (nodes[E2[i]] == noColor)) {
					nodes[E1[i]] = blank;
					nodes[E2[i]] = white;
				} else if ((nodes[E1[i]] != noColor) && (nodes[E2[i]] == noColor)) {
					if (nodes[E1[i]] == white) {
						nodes[E2[i]] = blank;
					} else {
						nodes[E2[i]] = white;
					}
				} else if ((nodes[E1[i]] == noColor) && (nodes[E2[i]] != noColor)) {
					if (nodes[E2[i]] == white) {
						nodes[E1[i]] = blank;
					} else {
						nodes[E1[i]] = white;
					}
				} else if ((nodes[E1[i]] != noColor) && (nodes[E2[i]] != noColor)) {
					if (nodes[E1[i]] == nodes[E2[i]]) {
						flag = false;
						break;
					}
				}
			}
			if (flag == true) {
				AnswerN = 0;
				for (int j = 1; j <= V; j++) {
					if (nodes[j] == white) {
						Answer[AnswerN++] = j;
					}
				}
			}

			// algrithm end
			System.out.print("#" + tcase + " " + AnswerN);
			for (int i = 0; i < AnswerN; i++) {
				System.out.print(" " + Answer[i]);
			}
			System.out.println();
		}
	}
}
