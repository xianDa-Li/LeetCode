package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/1 22:39
 * Remark:模拟LRU缓存
 */
public class T146 {
	class LRUCache {
		Queue<Integer> queue;
		Map<Integer,Integer> map;
		int capacity;
		public LRUCache(int capacity) {
			this.map = new HashMap<>();
			this.queue = new LinkedList<>();
			this.capacity = capacity;
		}

		public int get(int key) {
			if(queue.contains(key)){
				queue.remove(key);
				queue.add(key);
				return map.get(key);
			}else return -1;
		}

		public void put(int key, int value) {
			if(queue.contains(key)){
				queue.remove(key);
				queue.add(key);
				map.put(key,value);
			}else if(capacity == 0){
				map.remove(queue.poll());
				queue.add(key);
				map.put(key,value);
			}else{
				queue.add(key);
				map.put(key,value);
				capacity--;
			}
		}
	}
}
