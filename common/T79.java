package com.company.leetcode.common;

public class T79 {
    public static void main(String[] args) {

    }
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int i, int j, int k){
        int len1 = board.length;
        int len2 = board[0].length;
        int wlen = word.length();
        if(i>=len1 || i<0 || j<0 || j>=len2 || board[i][j] != word.charAt(k)) return false;
        if(k == wlen-1) return true;
        char temp = board[i][j];
        board[i][j]='/';
        k++;
        boolean ans = dfs(board,word,i-1,j,k) || dfs(board,word,i+1,j,k)
                ||dfs(board,word,i,j-1,k) || dfs(board,word,i,j+1,k);
        board[i][j] = temp;
        return ans;
    }
}
