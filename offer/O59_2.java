package com.company.leetcode.offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Author: XianDaLi
 * Date: 2020/9/7 5:29
 * Remark:
 */
public class O59_2 {
	class MaxQueue {

		public Deque<Integer> queueMax;
		public Queue<Integer> queue;
		public MaxQueue() {
			queueMax = new ArrayDeque<>();
			queue = new ArrayDeque<>();
		}

		public int max_value() {
			if(queueMax.isEmpty())
				return -1;
			else
				return queueMax.peek();
		}

		public void push_back(int value) {
			queue.add(value);
			while (!queueMax.isEmpty() && queueMax.peekLast() < value)
				queueMax.pollLast();
			queueMax.offer(value);
		}

		public int pop_front() {
			if(queue.isEmpty()) return -1;
			int poll = queue.poll();
			if(poll == queueMax.peek())
				queueMax.pop();
			return poll;
		}
	}
}
