package com.company.leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class T6 {
	public String convert(String s, int numRows) {
		if(numRows < 2) return s;
		List<StringBuilder> rows = new ArrayList<>();
		for(int i =0 ;i<Math.min(numRows,s.length());i++){
			rows.add(new StringBuilder());
		}
		int i = 0;
		int flag = -1;
		for(char c : s.toCharArray()){
			rows.get(i).append(c);
			if(i == 0 || i == numRows -1) flag =-flag;
			i += flag;
		}
		StringBuilder ans = new StringBuilder();
		for(StringBuilder a : rows){
			ans.append(a);
		}
		return ans.toString();
	}
}
