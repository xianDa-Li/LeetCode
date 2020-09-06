package com.company.leetcode.general;

import java.util.*;

/**
 * Author: XianDaLi
 * Date: 2020/9/1 22:39
 * Remark:模拟LRU缓存
 */
public class T146 {

	/*
	 LinkedHashMap模拟
	 */
	class LRUCache {
		int size;
		LinkedHashMap<Integer,Integer> map;
		public LRUCache(int capacity) {
			size = capacity;
			map = new LinkedHashMap<Integer,Integer>(size,0.75f,true){
				@Override
				public boolean removeEldestEntry(Map.Entry eldest){
					return map.size() > size;
				}
			};
		}

		public int get(int key) {
			return map.getOrDefault(key,-1);
		}

		public void put(int key, int value) {
			map.put(key,value);
		}
	}


	/*
		双端队列模拟
	 */
	class LRUCache2 {
		Queue<Integer> queue;
		Map<Integer,Integer> map;
		int capacity;
		public LRUCache2(int capacity) {
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
