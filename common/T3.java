package com.company.leetcode.common;

import java.util.*;


public class T3 {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> hm = new HashMap<>();
        int max = 0;
        int head = 0;
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i))){
                head = Math.max(head,hm.get(s.charAt(i))+1);
            }
            hm.put(s.charAt(i),i);
            max = Math.max(i-head+1,max);
        }
        return max;
    }

    public static void main(String[] args) {

        String a = "bbb";
        T3 t = new T3();
        int n = t.lengthOfLongestSubstring(a);
        System.out.println(n);
    }
}

