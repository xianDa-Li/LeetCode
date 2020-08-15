package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/8/16 4:08
 * Remark:有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 * 给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，让你重新上色这幅图像。
 * 为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像素点，
 * 接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 */
public class T733 {

	/*
		思路：dfs
		时间O(n*m)
		空间O(1)
	 */
	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

		return dfs(image,sr,sc,newColor,image[sr][sc]);
	}

	public int[][] dfs(int[][] image, int i, int j, int newColor,int num){
		if(i<0 || i>=image.length || j<0 || j>=image[0].length || image[i][j]==newColor || image[i][j]!=num){
		} else{
			int m = image[i][j];
			image[i][j]=newColor;
			dfs(image,i+1,j,newColor,m);
			dfs(image,i-1,j,newColor,m);
			dfs(image,i,j+1,newColor,m);
			dfs(image,i,j-1,newColor,m);
		}
		return image;
	}
}
