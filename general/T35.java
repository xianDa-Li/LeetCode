package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/8/12 8:50
 * Remark:
 */
public class T35 {

	/*
		思路：
			一般看到这种已排序数组中查找的相关题目，很容易就想到二分查找了，
			二分查找可以将时间复杂度从暴力枚举的O(n)降为O(logn)
			然后就是写二分查找的时候注意边界值。画画图很轻松就能理解了。
			很典型的二分查找,每次和最中间的数比较,比它大就从后半段找，反之就找前半段，
            需要注意的是假如没找到的时候,返回前半段起点start即可
        时间O(logn)
        空间O(1)
	 */
	public int searchInsert(int[] nums, int target) {
		int start = 0;
		int end = nums.length;
		while(start < end){ // 因为我的end是等于length的，所以这里 "<" 即可, 如果end = nums.length-1;这里就需要 "<=" 了
			int mid = (start+end)/2; // 取中间值
			if(target > nums[mid]) start = mid+1; // 这里一定记得mid+1再赋值。
			else if(target < nums[mid]) end = mid;// 这里是否+1取决于前面的end是length还是length-1;
			else return mid;
		}
		return start;
	}

}
