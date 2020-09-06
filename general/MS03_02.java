package com.company.leetcode.general;

import java.util.Stack;

/**
 * Author: XianDaLi
 * Date: 2020/9/7 6:30
 * Remark:
 * 请设计一个栈，除了常规栈支持的pop与push函数以外，还支持min函数，
 * 该函数返回栈元素中的最小值。执行push、pop和min操作的时间复杂度必须为O(1)。
 */
public class MS03_02 {
	class MinStack {

		/** initialize your data structure here. */
		public Stack<Integer> stack;
		public Stack<Integer> stackMin;
		public MinStack() {
			stack = new Stack<>();
			stackMin = new Stack<>();
		}

		public void push(int x) {
			stack.push(x);
			if (stackMin.isEmpty() || stackMin.peek() >= x)
				stackMin.push(x);
		}

		public void pop() {
			int pop = stack.pop();
			if(stackMin.peek() == pop)
				stackMin.pop();
		}

		public int top() {
			return stack.peek();
		}

		public int getMin() {
			return stackMin.peek();
		}
	}
}
