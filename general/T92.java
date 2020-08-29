package com.company.leetcode.general;

/**
 * Author: XianDaLi
 * Date: 2020/8/25 8:50
 * Remark:
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 */
public class T92 {
	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	public ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode ans = new ListNode(0);
		ans.next = head;
		ListNode root = ans;
		// 遍历第一遍到位置为m的结点
		for (int i = 1; i < m; i++) {
			root = root.next;
		}
		ListNode p = root;
		ListNode c = root.next;
		// 反转m-n的链表
		for (int i = m; i <= n; i++) {
			ListNode temp = c.next;
			c.next = p;
			p = c;
			c = temp;
		}
		// 将后两段链表链接至ans链表
		root.next.next = c;
		root.next = p;
		return ans.next;
	}
}
