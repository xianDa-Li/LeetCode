package com.company.leetcode.common;

import java.util.*;



public class T105 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int prelen = preorder.length;
        int inlen = inorder.length;
        for(int i=0;i<inlen;i++){
            hm.put(inorder[i],i);
        }

        return buildTree(preorder,0,prelen-1,hm,0,inlen-1);
    }

    private TreeNode buildTree(int[] preorder, int pleft, int pright, HashMap<Integer, Integer> hm, int ileft, int iright) {
        if(pleft>pright || ileft>iright) return null;

        int rootval = preorder[pleft];

        TreeNode root = new TreeNode(rootval);
        int pindex = hm.get(rootval);

        root.left = buildTree(preorder,pleft+1,pleft+pindex-ileft,hm,ileft,pindex-1);
        root.right = buildTree(preorder,pleft+pindex-ileft+1,pright,hm,pindex+1,iright);
        return root;
    }

}
