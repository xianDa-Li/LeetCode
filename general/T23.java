package com.company.leetcode.general;

import java.util.PriorityQueue;

/**
 * Author: XianDaLi
 * Date: 2020/9/4 2:13
 * Remark:
 */
public class T23 {

	class ListNode{
		int val;
		ListNode next;
		ListNode(int x){
			val = x;
		}
	}
	public ListNode mergeKLists(ListNode[] lists) {
		if(lists.length == 0) return null;
		ListNode ans = new ListNode(0);
		ListNode res = ans;
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
		for (ListNode list : lists) {
			if(list == null) continue;
			pq.add(list);
		}
		while (!pq.isEmpty()){
			ListNode temp = pq.poll();
			res.next = temp;
			res = res.next;
			if(temp.next != null){
				pq.add(temp.next);
			}
		}
		return ans.next;
	}
}
