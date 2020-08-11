package com.company.leetcode.common;

import java.util.Arrays;

public class T4 {
    public static void main(String[] args) {
        T4 t4 = new T4();
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double ans = t4.findMedianSortedArrays(nums1,nums2);
        System.out.println(ans);
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int[] nums = new int[l1+l2];
        double ans;
        for(int i=0;i<l1;i++){
            nums[i] = nums1[i];
        }
        int n = l1;
        for(int i=0;i<l2;i++){
            nums[n++] = nums2[i];
        }
        Arrays.sort(nums);
        System.out.println(nums);
        if((l1+l2)%2 == 0){
            ans = (nums[(l1+l2)/2] + nums[(l1+l2)/2-1]) / (double)2;
            System.out.println((l1+l2)/2-1);
            System.out.println((l1+l2)/2);
        } else{
            ans = nums[(l1+l2-1)/2];
            System.out.println((l1+l2-1)/2);
        }

        return ans;
    }
}
