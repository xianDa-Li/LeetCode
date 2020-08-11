package com.company.leetcode.common;

import java.util.*;

public class T350 {
    public static void main(String[] args) {
        T350 t350 = new T350();
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        int[] ans = t350.intersect(nums1,nums2);
        for(int i: ans){
            System.out.println(i);
        }
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> hm = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i : nums1){
            int count = 1;
            if(hm.containsKey(i)){
                int value = hm.get(i)+1;
                hm.put(i,value);
            }else
                hm.put(i,count);
        }

        for(int j : nums2){
            if(hm.containsKey(j) && hm.get(j)>0){
                list.add(j);
                int value = hm.get(j)-1;
                hm.put(j,value);
            }
        }
        int[] ans = new int[list.size()];
        int index = 0;
        for(Integer i : list){
            ans[index++] = (int)i;
        }
        return ans;
    }
}
