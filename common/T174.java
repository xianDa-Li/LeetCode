package com.company.leetcode.common;

public class T174 {
    public static void main(String[] args) {
        T174 t174 = new T174();
        int[][] arr = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int ans = t174.calculateMinimumHP(arr);
        System.out.println("ans = " + ans);
    }

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = dungeon[0][0];
//        dp[0][1] = dungeon[0][0]+dungeon[0][1];
//        dp[1][0] = dungeon[0][0]+dungeon[1][0];
        for(int i=1;i<=m;i++){
            //从上来
            for(int j=1;j<=n;j++){
                dp[i][j] += Math.max(dp[i-1][j],dp[i][j-1]) + dungeon[i-1][j-1];
                System.out.println(dp[i][j]);
            }
        }
        return dp[m][n];
    }
}
