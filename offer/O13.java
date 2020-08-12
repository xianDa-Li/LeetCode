package com.company.leetcode.offer;

public class O13 {

    /*
        思路：
            DFS,因为可以走上下左右四个方向，所以有四条路径，用一个boolean二维数组存储已经走过的路，
            做一个记忆化搜索，每次计算出和的值，再排除边界情况和不满足题目要求的情况即可。
        时间O(m*n)
        空间O(m*n)
     */
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
