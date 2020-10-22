import java.io.FileInputStream;
import java.util.Scanner;

public class Solution1 {
	static int N;
	static int[] A;
	static int[] Answer;
	static int AnswerLength;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/sample1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tcase = 1; tcase <= T; tcase++) {
			N = sc.nextInt();
			A = new int[N];
			for (int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			Answer = new int[N];
			AnswerLength = 0;
			// //////// algrithm begin
			int len = N / 2;
			do {
				for (int i = 0; i < N; i++) {
					int j = i + len - 1;//inline
					for (int s = j + 1; s < N; s++) {
						int t = s + len - 1;
						if (t > N - 1) {
							continue;
						}
						int leftStart = i;
						int rightEnd = t;
						int cnt = 0;
						while (leftStart < rightEnd) {
							if (A[leftStart] == A[rightEnd]) {
								cnt++;
								leftStart++;
								rightEnd--;
							} else {
								break;
							}
						}
						if (cnt == len) {
							if (len > AnswerLength) {
								AnswerLength = len;
								for (int k = 0; k < len; k++) {
									Answer[k] = A[i + k];
								}
							}
						}
					}
				}
			} while (--len > 0);
			// //////// algrithm end
			System.out.print("#" + tcase + " " + AnswerLength);
			for (int i = 0; i < AnswerLength; i++) {
				System.out.print(" " + Answer[i]);
			}
			System.out.println();
		}
	}
}
