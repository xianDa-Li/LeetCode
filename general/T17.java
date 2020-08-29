package com.company.leetcode.general;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Author: XianDaLi
 * Date: 2020/8/26 20:51
 * Remark:
 */
public class T17 {
	public List<String> letterCombinations(String digits) {
		List<String> ans = new ArrayList<>();
		if(digits.length() == 0) return ans;
		Map<Character,String> hm = new HashMap<>();
		hm.put('2',"abc");
		hm.put('3',"def");
		hm.put('4',"ghi");
		hm.put('5',"jkl");
		hm.put('6',"mno");
		hm.put('7',"pqrs");
		hm.put('8',"tuv");
		hm.put('9',"wxyz");

		res(ans,hm,digits,0,new StringBuffer());
		return ans;
	}

	void res(List<String> ans, Map<Character, String> hm, String digits, int n, StringBuffer sb) {
		if(n == digits.length()){
			ans.add(sb.toString());
		}else {
			char digit = digits.charAt(n);
			String s = hm.get(digit);
			for (int i = 0; i <s.length() ; i++) {
				sb.append(s.charAt(i));
				res(ans,hm,digits,n+1,sb);
				sb.deleteCharAt(n);
			}
		}
	}

}
