package com.company.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: XianDaLi
 * Date: 2020/8/15 2:33
 * Remark:输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 */
public class O57 {
	/*
	思路：滑动窗口
	当窗口的和小于target,窗口需要扩大，右边界扩大
	当窗口的和大于target,窗口需要缩小，左边界缩小
	当窗口和等于target,记录值。记录完值后，左边界缩小即可，寻找left+1开头的数组
	时间O(n)
	空间O(1)
	 */
	public int[][] findContinuousSequence(int target) {
		int left=1,right=1;
		int sum=0;
		List<int[]> list = new ArrayList<>();
		while ( left <= target/2){
			if(sum < target){           //移动右边界
				sum+=right;
				right++;
			}else if(sum > target){     //移动左边界
				sum-=left;
				left++;
			}else {                     // 相等时就记录结果
				int [] arr = new int[right-left];
				for (int i = left; i < right; i++)
					arr[i-left] = i;

				list.add(arr);
				sum-=left;              //移动左边界
				left++;
			}
		}
		return list.toArray(new int[list.size()][]);
	}
}
