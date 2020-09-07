package com.company.leetcode.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * Author: XianDaLi
 * Date: 2020/9/7 7:37
 * Remark:
 * 从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 */
public class O61 {
	public boolean isStraight(int[] nums) {
		Set<Integer> set = new HashSet<>();
		int max = 0;
		int min = 14;
		for (int i = 0; i < 5; i++) {
			if(nums[i]==0) continue;
			max = Math.max(max,nums[i]);
			min = Math.min(min,nums[i]);
			if(set.contains(nums[i])) return false;
			set.add(nums[i]);
		}
		return max-min < 5;
	}
}
