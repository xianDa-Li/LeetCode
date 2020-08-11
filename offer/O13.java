package com.company.leetcode.offer;

public class O13 {
    public static void main(String[] args) {
        O13 o13 = new O13();
        int m = 2;
        int n = 3;
        int k = 1;
        int ans = o13.movingCount(2,3,1);
        System.out.println(ans);
    }
    public int movingCount(int m, int n, int k) {
        boolean visited[][] = new boolean[m][n];
        return dfs(m,n,0,0,k,visited);
    }
    int dfs(int m, int n, int i, int j, int k, boolean visited[][]){
        int isum;
        int jsum;

        if(i == 100) isum = 1;
        else isum = (int)i/10 + i%10;
        if(j == 100) jsum = 1;
        else jsum = (int)j/10 + j%10;
        if(i<0 || j<0 || i>=m || j>=n || isum+jsum > k || visited[i][j]) return 0;
        visited[i][j] = true;
        return dfs(m,n,i-1,j,k,visited)+dfs(m,n,i+1,j,k,visited)+dfs(m,n,i,j-1,k,visited)+dfs(m,n,i,j+1,k,visited)+1;
    }
}
