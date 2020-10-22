package samsung2016.exec;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class SolutionSenior2 {
    static int[] x;
    static int[] y;
    static int N;
    static int Answer;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("D:\\workspace_demo\\Algorithm\\data\\SolutionSenior2.txt"));
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int testCase = 1; testCase <= T; testCase++) {
            N = sc.nextInt();
            x = new int[N + 2];
            y = new int[N + 2];
            x[0] = sc.nextInt();
            y[0] = sc.nextInt();
            x[N + 1] = sc.nextInt();
            y[N + 1] = sc.nextInt();
            for (int i = 1; i < N + 1; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }
            Answer = 0;
            // ////////////////////////////
            // distance matrix
            int[][] dist = new int[N + 2][N + 2];
            for (int i = 0; i < N + 2; i++) {
                for (int j = 0; j <= i; j++) {
                    dist[i][j] = calDist(x[i], y[i], x[j], y[j]);
                    dist[j][i] = dist[i][j];
                }
            }
            dist[0][N + 1] = 100000;// Integer.MAX_VALUE;
            dist[N + 1][0] = dist[0][N +1];

//            for (int i = 0; i < N + 2; i++) {
//                System.out.println("\t" + Arrays.toString(dist[i]));
//            }
//            System.out.println();

            int distIkJ = 0;
            for (int k = 0; k < N + 2; k++) {
                for (int i = 0; i < N + 2; i++) {
                    for (int j = 0; j < N + 2; j++) {
                        distIkJ = dist[i][k] + dist[k][j];
                        if (dist[i][j] > distIkJ) {
                            System.out.println("** ("+i+","+j+") "+dist[i][j]+" ->" + distIkJ);
                            dist[i][j] = distIkJ;
                        }// if
                    }// for j
                }// for i
            }// k
            System.out.println();

//            for (int i = 0; i < N + 2; i++) {
//                for (int j = 0; j < N + 2; j++) {
//
//                }
//            }

            // ////////////////////////////
            System.out.println("#" + testCase + " " + Answer);
            System.out.println("(" + x[0] + "," + y[0] + ") -> (" + x[N +1] + "," + y[N +1] + ")");
            for (int i = 1; i < N + 1; i++) {
                System.out.print("(" + x[i] + "," + y[i] + ") ");
            }
            System.out.println();
            for (int i = 0; i < N + 2; i++) {
                System.out.println("\t" + Arrays.toString(dist[i]));
            }
            System.out.println();
        }// for testCase
    }

    private static int calDist(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

}
