package com.company.leetcode.offer;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: XianDaLi
 * Date: 2020/8/14 5:55
 * Remark:输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class O36 {
	class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val,Node _left,Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	}
	/*
		中序遍历 pre为前一个节点 temp为当前节点 head为头节点
		遍历时 pre->temp, pre<-temp, pre = temp
		最后将pre 和 head 链接
		时间O(n)
		空间O(n)
	 */
	Node pre,head;
	public Node treeToDoublyList(Node root) {
		if(root == null) return null;
		dfs(root);
		head.left = pre;
		pre.right = head;
		return head;
	}

	public void dfs(Node temp){
		if(temp == null) return;
		dfs(temp.left);
		if(pre == null) head = temp;
		else pre.right = temp;
		temp.left = pre;
		pre = temp;
		dfs(temp.right);
	}
}
