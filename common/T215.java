package com.company.leetcode.common;

/*
    在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class T215 {
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        quickSort(nums,0,len-1);
        return nums[len-k];
    }

    private void quickSort(int[] arr, int start, int end){
        if(start>end) return;
        int left = start; //左指针
        int right = end; // 右指针
        int piovt = arr[start]; // 获取第一个元素作为基准数

        while(left != right){ // 只要左右指针不重合就继续移动指针，直到所有元素交换完成
            //右指针开始移动,找到比基准数小的就停止
            while(arr[right]>arr[start] && left < right)
                right--;
            //左指针开始移动,找到比基准大的就停止
            while(arr[left]<=arr[start] && left < right)
                left++;

            //都停止后说明可以交换位置
            if(left < right){
                int temp = arr[right];
                arr[right] = arr[left];
                arr[left] = temp;
            }
        }
        //一轮交换结束,把基准数从第一位移动到左右指针重合位置
        int t = arr[left];
        arr[left] = arr[start];
        arr[start] = t;

        quickSort(arr,start,right-1);// 左边递归
        quickSort(arr,left+1,end);// 右边递归
    }

}
