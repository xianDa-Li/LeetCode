package com.company.leetcode.common;

/*
    给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
    函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。

    说明:
    返回的下标值（index1 和 index2）不是从零开始的。
    你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。

 */
public class T167 {
    public static void main(String[] args) {
        T167 t167 = new T167();
        int[] numbers = {0,7,0,13,15};
        int target = 0;
        int[] ans = t167.twoSum(numbers,target);
        for(int i: ans){
            System.out.println(i);
        }
    }

    /*
        Map法：效率低

    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int index = 1;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(hm.containsKey(target-numbers[i])){
                ans[0] = hm.get(target-numbers[i]);
                ans[1] = i+1;
            }
            hm.put(numbers[i],i+1);
        }
        return ans;
    }
    */
    /*
        双指针：效率高
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        int start = 0;
        int end = numbers.length-1;
        while(start<end){
            int sum = numbers[start]+numbers[end];
            if(sum == target){
                ans[0] = start+1;
                ans[1] = end+1;
                return ans;
            }
            if(sum > target) end--;
            if(sum < target) start++;
        }
        return ans;
    }

}
