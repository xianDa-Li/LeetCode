package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/8/31 9:57
 * Remark:
 */
public class T841 {
	public static void main(String[] args) {
		List<List<Integer>> rooms = new ArrayList<>();
		List<Integer> a = new ArrayList<>();
		List<Integer> b = new ArrayList<>();
		List<Integer> c = new ArrayList<>();
		List<Integer> d = new ArrayList<>();
		a.add(1);
		a.add(3);
		b.add(3);
		b.add(0);
		b.add(1);
		c.add(2);
		d.add(0);
		rooms.add(a);
		rooms.add(b);
		rooms.add(c);
		rooms.add(d);
		boolean ans = canVisitAllRooms(rooms);
		System.out.println(ans);
	}
	public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
		HashSet<Integer> set = new HashSet<>();
			set.add(0);
		dfs(rooms,0,set);
		return set.size() == rooms.size();
	}

	static void dfs(List<List<Integer>> rooms, int m, HashSet<Integer> set) {
		if(rooms.get(m)==null || rooms.get(m).size()==0)
			return;
		for (int i = 0; i < rooms.get(m).size(); i++) {
			int temp = rooms.get(m).get(i);
			if (!set.contains(temp)){
				set.add(temp);
				dfs(rooms,temp,set);
			}
		}
	}
}
