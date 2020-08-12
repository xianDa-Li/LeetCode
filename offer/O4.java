package com.company.leetcode.offer;

/**
 * Author: XianDaLi
 * Date: 2020/8/12 8:16
 * Remark:
 */
public class O4 {

	/*
		方法一：暴力枚举
		思路：使用双重for循环,从头到尾遍历二维数组即可
		时间O(n*m)
		空间O(1)
	 */

	/*
		方法二：二分查找
		思路：一般有序数组查找相关问题，首先就尝试二分查找
		时间O(n+m)
		空间O(1)
	 */
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if(matrix.length == 0) return false;
		int n = matrix.length;
		int col = matrix[0].length-1;
		int row = 0;
		while(row<n && col>=0){
			if(matrix[row][col] > target){
				col--;
			}else if(matrix[row][col] < target){
				row++;
			}else
				return true;
		}
		return false;
	}
}
