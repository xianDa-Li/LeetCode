package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/1 22:39
 * Remark:
 */
public class T146 {
	class LRUCache {

		private int len;
		private HashMap<Integer,Integer> map;
		public LRUCache(int capacity) {
			map = new LinkedHashMap<>();
			len = capacity;
		}

		public int get(int key) {
			if(map.keySet().contains(key)){
				int value = map.get(key);
				map.remove(key);
				map.put(key,value);
				return value;
			}
			return -1;
		}

		public void put(int key, int value) {
			if(map.keySet().contains(key)){
				map.remove(key);
			}else if(map.size() == len){
				Iterator<Map.Entry<Integer,Integer>> iterator = map.entrySet().iterator();
				iterator.next();
				iterator.remove();
				// int firstKey = map.entrySet().iterator().next().getValue();
				// map.remove(firstKey);
			}
			map.put(key,value);
		}
	}
}
