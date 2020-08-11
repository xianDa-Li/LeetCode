package com.company.leetcode.general;

public class T114 {

	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(){};
		TreeNode(int val){
			this.val = val;
		}
		TreeNode(int val,TreeNode left,TreeNode right){
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	/*
		解法二：循环迭代
	 */
	public void flatten(TreeNode root) {
		while (root != null){
			//左子树为null,直接考虑下一个节点
			if(root.left == null) root = root.right;
			else {
				//找左子树最右边的节点
				TreeNode left = root.left;
				while (left.right != null){
					left = left.right;
				}
				//将原来的右子树接到左子树的最右边节点
				left.right = root.right;
				//将左子树插入到右子树的地方
				root.right = root.left;
				root.left = null;
				//考虑下一个节点
				root = root.right;
			}
		}
	}


	/*
		解法一：递归

	public void flatten(TreeNode root) {
		if(root == null){
			return;
		}
		//将左子树展开为单链表
		flatten(root.left);
		//将右子树展开为单链表
		flatten(root.right);
		//暂存右子树
		TreeNode right = root.right;
		//左子树接到根的右侧
		root.right = root.left;
		//左子树置空
		root.left = null;
		//在接上右子树
		while (root.right != null){
			root = root.right;
		}
		root.right = right;
	}
	*/
}
