package com.company.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: XianDaLi
 * Date: 2020/8/14 5:01
 * Remark:请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，
 * 每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null
 */
public class O35 {

	class Node{
		int val;
		Node next;
		Node random;
		Node(int x){
			val = x;
			next = null;
			random = null;
		}
	}

	/*
		方法一：HashMap 按照HashMap<原节点，新节点>放入
		时间O(n)
		空间O(n)
	 */
	public Node copyRandomList(Node head) {
		Map<Node,Node> hm = new HashMap<>();
		Node temp = head;
		while (temp != null){
			hm.put(temp,new Node(temp.val));
			temp = temp.next;
		}
		temp = head;
		while (temp != null){
			hm.get(temp).next = hm.get(temp.next);
			hm.get(temp).random = hm.get(temp.random);
			temp = temp.next;
		}
		return hm.get(head);
	}

	/*
		方法二：原地置换 首先复制next节点，再添加random节点
		1->2->3->null 复制为1->1->2->2->3->3->null
		时间O(n)
		空间O(1)
	 */
	public Node copyRandomList2(Node head) {
		if(head == null) return null;
		Node root = head;               //链表状态1->2->3->null
		while (root!=null){
			Node temp = new Node(root.val);
			temp.next = root.next;
			root.next = temp;
			root = root.next.next;
		}
		root = head;            //链表状态 1->1->2->2->3->3->null
		while (root != null){
			if(root.random != null){
				root.next.random = root.random.next;
			}
			root = root.next.next;
		}
		root = head;
		Node copyH = head.next;         //链表状态 1->2->2->3->3->null
		Node copyR = head.next;
		while (root != null){
			root.next = root.next.next;
			root = root.next;
			if(copyR.next != null){
				copyR.next = copyR.next.next;
				copyR = copyR.next;
			}
		}
		return copyH;
	}
}
