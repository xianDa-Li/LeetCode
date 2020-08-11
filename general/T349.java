package com.company.leetcode.general;
import java.util.*;
public class T349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> hs = new HashSet<>();
        int len1 = nums1.length;
        int len2 = nums2.length;
        for(int i=0;i<len1;i++){
            set.add(nums1[i]);
        }
        for(int i=0;i<len2;i++){
            if(set.contains(nums2[i])){
                hs.add(nums2[i]);
            }
        }
        int[] ans = new int[hs.size()];
        int index = 0;
        for(Integer i : hs){
            ans[index++] = (int)i;
        }
        return ans;
    }
}
