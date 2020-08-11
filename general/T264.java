package com.company.leetcode.general;

/*
    我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 */

public class T264 {

    public static void main(String[] args) {
        T264 t264 = new T264();
        int n = 10;
        System.out.println(t264.nthUglyNumber(15));
    }
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0;

        for(int i=1;i<n;i++){
            dp[i] = Math.min(dp[p2]*2,Math.min(dp[p3]*3,dp[p5]*5));
            System.out.println(dp[i]);
            if(dp[i] == dp[p2]*2) p2++;
            if(dp[i] == dp[p3]*3) p3++;
            if(dp[i] == dp[p5]*5) p5++;
        }
        return dp[n-1];
    }
}
