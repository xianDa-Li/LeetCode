package com.company.leetcode.general;

import com.sun.source.tree.Tree;

/**
 * Author: XianDaLi
 * Date: 2020/8/18 6:00
 * Remark:给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class T109 {
	class ListNode {
		int val;
		ListNode next;
		ListNode(int val) {
			this.val = val;
		}
		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode() {
		}
		TreeNode(int val) {
			this.val = val;
		}
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}
	/*
		快慢指针
		时间O(n)
		空间O(n)
	 */
	public TreeNode sortedListToBST(ListNode head){
		if(head == null) return null;
		else if(head.next == null) return new TreeNode(head.val);
		ListNode root = null;
		ListNode f = head;
		ListNode s = head;
		while (f != null && f.next != null){
			f = f.next.next;
			root = s;
			s = s.next;
		}
		// 分割左链表
		root.next = null;
		TreeNode ans = new TreeNode(s.val);
		ans.left = sortedListToBST(head);
		// s后面是右子树
		ans.right = sortedListToBST(s.next);
		return ans;
	}

}
