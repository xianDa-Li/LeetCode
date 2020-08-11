package com.company.leetcode.offer;

/*
	定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
import java.util.Stack;

class MinStack {

	private Stack<Integer> A;
	private Stack<Integer> B;

	public MinStack() {
		A = new Stack<>();
		B = new Stack<>();
	}

	public void push(int x) {
		A.push(x);
		if(B.empty() || x<=B.peek()) B.push(x);
	}

	public void pop() {
		if(A.peek().equals(B.peek())) B.pop();
		A.pop();
	}

	public int top() {
		return A.peek();
	}

	public int min() {
		return B.peek();
	}
}
