package com.leetcode.a829;

public class Solution {
    public int consecutiveNumbersSum(int N) {
        int count = 0;
        for (int n = 1; n <= N; n++) {
            int a1 = N / n - (n - 1)/2;
            int an = a1 + n - 1;
            if(N!=n*(a1+an)/2 || a1<= 0) {
                continue;
            }
            count++;
        }

        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] list = {5, 9 , 15, 17, 19, 21, 23, 25};
        for(int N : list) {
            System.out.println(solution.consecutiveNumbersSum(N));
        }
    }
}